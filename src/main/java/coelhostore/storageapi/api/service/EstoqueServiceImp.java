package coelhostore.storageapi.api.service;

import coelhostore.storageapi.api.dtos.EstoqueRequest;
import coelhostore.storageapi.api.dtos.EstoqueResponse;
import coelhostore.storageapi.domain.exceptions.ModelNotFoundException;
import coelhostore.storageapi.domain.repositories.EstoqueRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static coelhostore.storageapi.api.dtos.EstoqueRequest.toEntidade;

@Service
@Log4j2
@AllArgsConstructor
public class EstoqueServiceImp implements EstoqueService{

    private final EstoqueRepository estoqueRepository;

    @Override
    public List<EstoqueResponse> findEstoqueList() {
        try {
            var findEstoqueList=estoqueRepository.findAll();
            if (findEstoqueList==null){
                throw new ModelNotFoundException("List from estoque not found!");
            }
            return findEstoqueList.stream().map(EstoqueResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error inside search estoque list: {}",e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<EstoqueResponse> findEstoqueId(UUID uuid) {
        return estoqueRepository
                .findById(uuid)
                .map(EstoqueResponse::toResponse)
                .or(()->{throw new ModelNotFoundException("ID :"+uuid+" not found");});
    }

    @Override
    public void createEstoque(EstoqueRequest estoqueRequest) {
    estoqueRepository.save(toEntidade(estoqueRequest));
    }

    @Override
    public void updateEstoque(UUID uuid, EstoqueRequest estoqueRequest) {
        var findEstoqueId=estoqueRepository
                .findById(uuid)
                .orElseThrow(()->new  ModelNotFoundException("ID : "+uuid+" not found!"));
        findEstoqueId.setProduto(estoqueRequest.produtos());
        findEstoqueId.setQuantidade(estoqueRequest.quantidade());
        findEstoqueId.setValorEmEstoque(estoqueRequest.valorEmEstoque());
        findEstoqueId.setQuantidadeReservada(estoqueRequest.quantidadeReservada());
        findEstoqueId.setEstoqueTipo(estoqueRequest.estoqueTipo());
        findEstoqueId.setTipologiaEstoque(estoqueRequest.tipologiaEstoque());
        estoqueRepository.save(findEstoqueId);
    }

    @Override
    public void deleteEstoque(UUID uuid) {
    try{
        var findEstoqueId=estoqueRepository
                .findById(uuid)
                .orElseThrow(()->new ModelNotFoundException("ID : "+uuid+" not found!"));
            estoqueRepository.delete(findEstoqueId);
    }catch (RuntimeException e){
        log.error("Error inside delete estoque info: ",e.getMessage());
        throw e;
    }
    }
}

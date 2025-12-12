package coelhostore.storageapi.api.service;

import coelhostore.storageapi.api.dtos.EstoqueEntradaRequest;
import coelhostore.storageapi.api.dtos.EstoqueEntradaResponse;
import coelhostore.storageapi.domain.exceptions.ModelNotFoundException;
import coelhostore.storageapi.domain.repositories.EstoqueEntradaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static coelhostore.storageapi.api.dtos.EstoqueEntradaRequest.toEntidade;

@Service
@AllArgsConstructor
@Log4j2
public class EstoqueEntradaServiceImp implements EstoqueEntradaService{
    private final EstoqueEntradaRepository estoqueEntradaRepository;
    @Override
    public List<EstoqueEntradaResponse> findEstoqueEntradaList() {
        try {
            var findEstoqueEntrada=estoqueEntradaRepository.findAll();
            if (findEstoqueEntrada.isEmpty()){

                throw new ModelNotFoundException("Lista nao encontrada");
            }
            return findEstoqueEntrada.stream().map(EstoqueEntradaResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error :{} inside find estoque list",e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<EstoqueEntradaResponse> findEstoqueEntradaId(UUID uuid) {
        return estoqueEntradaRepository
                .findById(uuid)
                .map(EstoqueEntradaResponse::toResponse)
                .or(()->{
            throw new ModelNotFoundException("ID : "+uuid+" not found!");
        });
    }

    @Override
    public void createEstoqueEntrada(EstoqueEntradaRequest estoqueEntradaRequest) {

        estoqueEntradaRepository.save(toEntidade(estoqueEntradaRequest));
    }

    @Override
    public void updateEstoqueEntrada(UUID uuid, EstoqueEntradaRequest estoqueEntradaRequest) {
    var findEstoqueEntradaId=estoqueEntradaRepository
            .findById(uuid)
            .orElseThrow(()-> new ModelNotFoundException("ID : "+uuid+" not found"));
    findEstoqueEntradaId.setProduto(estoqueEntradaRequest.produtos());
    findEstoqueEntradaId.setFornecedor(estoqueEntradaRequest.fornecedor());
    findEstoqueEntradaId.setQuantidade(estoqueEntradaRequest.quantidade());
    findEstoqueEntradaId.setValorUnidade(estoqueEntradaRequest.valorUnidade());
    findEstoqueEntradaId.setImpostos(estoqueEntradaRequest.impostos());
    findEstoqueEntradaId.setDataEntrada(estoqueEntradaRequest.dataEntrada());
    findEstoqueEntradaId.setValorTotalBruto(estoqueEntradaRequest.valorTotalBruto());
    findEstoqueEntradaId.setValorTotalLiquido(estoqueEntradaRequest.valorTotalLiquido());
    estoqueEntradaRepository.save(findEstoqueEntradaId);
    }

    @Override
    public void deleteEstoqueEntrada(UUID uuid) {
    try {
        var findEstoqueId=estoqueEntradaRepository
                .findById(uuid)
                .orElseThrow(()-> new ModelNotFoundException("ID "+uuid+" not found!"));
        estoqueEntradaRepository.delete(findEstoqueId);
    }catch (RuntimeException e){
        log.error("Error: {} ,inside delete estoque entrada",e.getMessage());
        throw e;
    }
    }
}

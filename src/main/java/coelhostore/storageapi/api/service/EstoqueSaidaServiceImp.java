package coelhostore.storageapi.api.service;

import coelhostore.storageapi.api.dtos.EstoqueRequest;
import coelhostore.storageapi.api.dtos.EstoqueResponse;
import coelhostore.storageapi.api.dtos.EstoqueSaidaRequest;
import coelhostore.storageapi.api.dtos.EstoqueSaidaResponse;
import coelhostore.storageapi.domain.exceptions.ModelNotFoundException;
import coelhostore.storageapi.domain.repositories.EstoqueSaidaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static coelhostore.storageapi.api.dtos.EstoqueSaidaRequest.toEntidade;

@Service
@AllArgsConstructor
@Log4j2
public class EstoqueSaidaServiceImp implements EstoqueSaidaService{

    private final EstoqueSaidaRepository estoqueSaidaRepository;

    @Override
    public List<EstoqueSaidaResponse> findEstoqueSaidaList() {
        try {
            var findEstoqueList=estoqueSaidaRepository.findAll();
            if (findEstoqueList.isEmpty()){
                throw new ModelNotFoundException("List of estoque saida not found!");
            }
            return findEstoqueList.stream().map(EstoqueSaidaResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error: {} inside search estoque saida list",e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<EstoqueSaidaResponse> findEstoqueSaidaId(UUID uuid) {
        return estoqueSaidaRepository.findById(uuid).map(EstoqueSaidaResponse::toResponse).or(()->{
            throw new ModelNotFoundException("ID : "+uuid+" not found");
        });
    }

    @Override
    public void createEstoqueSaida(EstoqueSaidaRequest estoqueSaidaRequest) {
    estoqueSaidaRepository.save(toEntidade(estoqueSaidaRequest));
    }

    @Override
    public void updateEstoqueSaida(UUID uuid, EstoqueSaidaRequest estoqueSaidaRequest) {
    var findEstoqueId=estoqueSaidaRepository
            .findById(uuid)
            .orElseThrow(()-> new ModelNotFoundException("ID : "+uuid+" not found"));
    findEstoqueId.setProduto(estoqueSaidaRequest.produtos());
    findEstoqueId.setQuantidade(estoqueSaidaRequest.quantidade());
    findEstoqueId.setValorSaida(estoqueSaidaRequest.valorSaida());
    findEstoqueId.setTransporteValor(estoqueSaidaRequest.transporteValor());
    findEstoqueId.setImposto(estoqueSaidaRequest.imposto());
    findEstoqueId.setDataSaida(estoqueSaidaRequest.dataSaida());
    findEstoqueId.setMotivoSaida(estoqueSaidaRequest.motivoSaida());
    findEstoqueId.setCliente(estoqueSaidaRequest.cliente());
    }

    @Override
    public void deleteEstoqueSaida(UUID uuid) {
    try {
        var findEstoqueId=estoqueSaidaRepository
                .findById(uuid)
                .orElseThrow(()-> new ModelNotFoundException("ID: "+uuid+" not found!"));
        estoqueSaidaRepository.delete(findEstoqueId);
    }catch (RuntimeException e){
        log.error("Error:{} inside delete estoque saida!",e.getMessage());
        throw e;
    }
    }
}

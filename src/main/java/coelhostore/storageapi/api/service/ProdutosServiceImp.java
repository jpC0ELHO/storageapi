package coelhostore.storageapi.api.service;

import coelhostore.storageapi.api.dtos.ProdutosRequest;
import coelhostore.storageapi.api.dtos.ProdutosResponse;
import coelhostore.storageapi.domain.exceptions.ModelNotFoundException;
import coelhostore.storageapi.domain.repositories.ProdutosRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static coelhostore.storageapi.api.dtos.ProdutosRequest.toEntidade;

@Service
@AllArgsConstructor
@Log4j2
public class ProdutosServiceImp implements ProdutosService{

    private final ProdutosRepository produtosRepository;

    @Override
    public List<ProdutosResponse> findProdutosList() {
        try {
            var findProdutosList=produtosRepository.findAll();
            if (findProdutosList.isEmpty()){
                throw new  ModelNotFoundException("List not found!!");
            }
            return findProdutosList.stream().map(ProdutosResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error inside search list: {}",e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<ProdutosResponse> findProdutosId(UUID uuid) {
        return produtosRepository
                .findById(uuid)
                .map(ProdutosResponse::toResponse)
                .or(()-> {
                    log.error("ID not found!");
                    throw new ModelNotFoundException("Id: " + uuid + " not found!");});
    }

    @Override
    public void createProdutos(ProdutosRequest produtosRequest) {
        produtosRepository.save(toEntidade(produtosRequest));
    }

    @Override
    public void updateProdutos(UUID uuid, ProdutosRequest produtosRequest) {
    var findProdutosId=produtosRepository
            .findById(uuid)
            .orElseThrow(()->new ModelNotFoundException("ID "+uuid+"not found!"));
    findProdutosId.setSku(produtosRequest.sku());
    findProdutosId.setNomeProduto(produtosRequest.nomeProduto());
    findProdutosId.setUnidadeMedida(produtosRequest.unidadeMedida());
    produtosRepository.save(findProdutosId);
    }

    @Override
    public void deleteProdutos(UUID uuid) {
        try {
            var findProdutoId=produtosRepository.findById(uuid).orElseThrow(()-> new ModelNotFoundException("ID : "+uuid+" not found"));
            produtosRepository.delete(findProdutoId);
        }catch (RuntimeException e){
            log.error("Error inside delete produtos:{}",e.getMessage());
            throw e;
        }
    }
}


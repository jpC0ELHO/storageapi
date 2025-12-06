package coelhostore.storageapi.api.service;

import coelhostore.storageapi.api.dtos.ProdutosRequest;
import coelhostore.storageapi.api.dtos.ProdutosResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutosService {
    List<ProdutosResponse>findProdutosList();
    Optional<ProdutosResponse> findProdutosId(UUID uuid);
    void createProdutos(ProdutosRequest produtosRequest);
    void updateProdutos(UUID uuid,ProdutosRequest produtosRequest);
    void deleteProdutos(UUID uuid);
}

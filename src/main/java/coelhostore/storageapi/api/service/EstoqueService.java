package coelhostore.storageapi.api.service;

import coelhostore.storageapi.api.dtos.EstoqueRequest;
import coelhostore.storageapi.api.dtos.EstoqueResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstoqueService {
    List<EstoqueResponse>findEstoqueList();
    Optional<EstoqueResponse>findEstoqueId(UUID uuid);
    void createEstoque(EstoqueRequest estoqueRequest);
    void updateEstoque(UUID uuid,EstoqueRequest estoqueRequest);
    void deleteEstoque(UUID uuid);
}

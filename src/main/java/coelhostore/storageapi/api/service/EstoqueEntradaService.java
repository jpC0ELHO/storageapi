package coelhostore.storageapi.api.service;

import coelhostore.storageapi.api.dtos.EstoqueEntradaRequest;
import coelhostore.storageapi.api.dtos.EstoqueEntradaResponse;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstoqueEntradaService {
    List<EstoqueEntradaResponse>findEstoqueEntradaList();
    Optional<EstoqueEntradaResponse> findEstoqueEntradaId(UUID uuid);
    void createEstoqueEntrada(EstoqueEntradaRequest estoqueEntradaRequest);
    void updateEstoqueEntrada(UUID uuid, EstoqueEntradaRequest estoqueEntradaRequest);
    void deleteEstoqueEntrada(UUID uuid);
}

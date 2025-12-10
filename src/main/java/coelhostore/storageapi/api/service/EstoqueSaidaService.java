package coelhostore.storageapi.api.service;

import coelhostore.storageapi.api.dtos.EstoqueSaidaRequest;
import coelhostore.storageapi.api.dtos.EstoqueSaidaResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstoqueSaidaService {
    List<EstoqueSaidaResponse>findEstoqueSaidaList();
    Optional<EstoqueSaidaResponse> findEstoqueSaidaId(UUID uuid);
    void createEstoqueSaida(EstoqueSaidaRequest estoqueSaidaRequest);
    void updateEstoqueSaida(UUID uuid,EstoqueSaidaRequest estoqueSaidaRequest);
    void deleteEstoqueSaida(UUID uuid);
}

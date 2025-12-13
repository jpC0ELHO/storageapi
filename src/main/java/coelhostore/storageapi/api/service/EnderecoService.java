package coelhostore.storageapi.api.service;

import coelhostore.storageapi.api.dtos.EnderecoRequest;
import coelhostore.storageapi.api.dtos.EnderecoResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EnderecoService {
    List<EnderecoResponse>findEnderecoList();
    Optional<EnderecoResponse>findEnderecoId(UUID uuid);
    void createEndereco(EnderecoRequest enderecoRequest);
    void updateEndereco(UUID uuid,EnderecoRequest enderecoRequest);
    void deleteEndereco(UUID uuid);
}

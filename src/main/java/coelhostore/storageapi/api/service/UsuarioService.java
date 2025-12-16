package coelhostore.storageapi.api.service;

import coelhostore.storageapi.api.dtos.UsuarioRequest;
import coelhostore.storageapi.api.dtos.UsuarioResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioService {
    List<UsuarioResponse>findUserList();
    Optional<UsuarioResponse>findUserId(UUID uuid);
    void createUser(UsuarioRequest usuarioRequest);
    void updateUser(UUID uuid,UsuarioRequest usuarioRequest);
    void deleteUser(UUID uuid);
}

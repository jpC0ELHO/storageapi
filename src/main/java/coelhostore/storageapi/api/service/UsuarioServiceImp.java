package coelhostore.storageapi.api.service;

import coelhostore.storageapi.api.dtos.UsuarioRequest;
import coelhostore.storageapi.api.dtos.UsuarioResponse;
import coelhostore.storageapi.domain.exceptions.ModelNotFoundException;
import coelhostore.storageapi.domain.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static coelhostore.storageapi.api.dtos.UsuarioRequest.toEntidade;

@Service
@AllArgsConstructor
@Log4j2
public class UsuarioServiceImp implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponse> findUserList() {
        try {
            var findUserList=usuarioRepository.findAll();
            if (findUserList.isEmpty()){
                throw new ModelNotFoundException("List of users not found!");
            }
            return findUserList.stream().map(UsuarioResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error:{} inside find user list!",e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<UsuarioResponse> findUserId(UUID uuid) {
        return usuarioRepository
                .findById(uuid)
                .map(UsuarioResponse::toResponse)
                .or(()->{
            throw new ModelNotFoundException("User ID: "+uuid+" not found!");
        });
    }

    @Override
    public void createUser(UsuarioRequest usuarioRequest) {
        usuarioRepository.save(toEntidade(usuarioRequest));
    }

    @Override
    public void updateUser(UUID uuid, UsuarioRequest usuarioRequest) {
        var findUserId=usuarioRepository
                .findById(uuid)
                .orElseThrow(()-> new ModelNotFoundException("User ID: "+uuid+" not found!"));
        findUserId.setUsername(usuarioRequest.username());
        findUserId.setPassword(usuarioRequest.password());
        findUserId.setEmail(usuarioRequest.email());
        findUserId.setRole(usuarioRequest.role());
        findUserId.setUserLogado(usuarioRequest.userLogado());
        usuarioRepository.save(findUserId);
        log.info("User updated sucessfuly");
    }

    @Override
    public void deleteUser(UUID uuid) {
    try {
        var findUserId=usuarioRepository
                .findById(uuid)
                .orElseThrow(()-> new ModelNotFoundException("User ID: "+uuid+" not found!"));
        usuarioRepository.delete(findUserId);
    }catch (RuntimeException e){
        log.error("Error: {}",e.getMessage());
        throw e;
    }
    }
}

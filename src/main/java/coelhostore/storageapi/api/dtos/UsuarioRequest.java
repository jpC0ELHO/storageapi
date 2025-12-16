package coelhostore.storageapi.api.dtos;

import coelhostore.storageapi.domain.Usuario;
import coelhostore.storageapi.domain.enums.Role;

public record UsuarioRequest (
        String username,
        String password,
        String email,
        Role role,
        Boolean userLogado
){
    public static Usuario toEntidade(UsuarioRequest usuarioRequest){
        if (usuarioRequest==null){
            return null;
        }
        return new Usuario(
                usuarioRequest.username,
                usuarioRequest.password,
                usuarioRequest.email,
                usuarioRequest.role,
                usuarioRequest.userLogado
        );
    }
}

package coelhostore.storageapi.api.dtos;


import coelhostore.storageapi.domain.Usuario;
import coelhostore.storageapi.domain.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.format.annotation.DateTimeFormat;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ext.javatime.deser.LocalDateTimeDeserializer;
import tools.jackson.databind.ext.javatime.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.UUID;
@JsonPropertyOrder({"uuid","createdBy","lastModifiedBy","createdAt","updatedAt"
        ,})
public record UsuarioResponse (
        UUID uuid,
        String createdBy,
        String lastModifiedBy,
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
        LocalDateTime createdAt,
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
        LocalDateTime updatedAt,
        String username,
        String password,
        String email,
        Role role,
        Boolean userLogado
){
    public static UsuarioResponse toResponse(Usuario usuario){
        if (usuario==null){
            return null;
        }
        return new UsuarioResponse(
                usuario.getUuid(),
                usuario.getCreatedBy(),
                usuario.getLastModifiedBy(),
                usuario.getCreatedAt(),
                usuario.getUpdateAt(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getEmail(),
                usuario.getRole(),
                usuario.getUserLogado()
        );
    }
}

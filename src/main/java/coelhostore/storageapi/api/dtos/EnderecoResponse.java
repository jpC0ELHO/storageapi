package coelhostore.storageapi.api.dtos;

import coelhostore.storageapi.domain.Endereco;
import coelhostore.storageapi.domain.enums.EstadoBr;
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
        ,"logradouro","numero","complemento","bairro","cidade","estado","cep"})
public record EnderecoResponse(
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
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        EstadoBr estadoBr,
        String cep
){
    public static EnderecoResponse toResponse(Endereco endereco){
        if (endereco==null){
            return null;
        }
        return new EnderecoResponse(
                endereco.getUuid(),
                endereco.getCreatedBy(),
                endereco.getLastModifiedBy(),
                endereco.getCreatedAt(),
                endereco.getCreatedAt(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep()
        );
    }
}

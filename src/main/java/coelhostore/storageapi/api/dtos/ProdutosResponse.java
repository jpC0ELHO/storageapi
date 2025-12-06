package coelhostore.storageapi.api.dtos;

import coelhostore.storageapi.domain.Produtos;
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
        ,"sku","nomeProduto","unidadeMedida"})
public record ProdutosResponse(
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
        String sku,
        String nomeProduto,
        String unidadeMedida
) {
    public static ProdutosResponse toResponse(Produtos produtos){
        if (produtos==null){
            return null;
        }
        return new ProdutosResponse(
                produtos.getUuid(),
                produtos.getCreatedBy(),
                produtos.getLastModifiedBy(),
                produtos.getCreatedAt(),
                produtos.getUpdateAt(),
                produtos.getSku(),
                produtos.getNomeProduto(),
                produtos.getUnidadeMedida()
        );
    }

}

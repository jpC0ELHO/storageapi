package coelhostore.storageapi.api.dtos;

import coelhostore.storageapi.domain.Estoque;
import coelhostore.storageapi.domain.Produtos;
import coelhostore.storageapi.domain.enums.EstoqueTipo;
import coelhostore.storageapi.domain.enums.TipologiaEstoque;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.format.annotation.DateTimeFormat;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ext.javatime.deser.LocalDateTimeDeserializer;
import tools.jackson.databind.ext.javatime.ser.LocalDateTimeSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonPropertyOrder({"uuid","createdBy","lastModifiedBy","createdAt","updatedAt"
        ,"produtos","quantidade","valorEmEstoque","quantidadeReservada","estoqueTipo","tipologiaEstoque"})
public record EstoqueResponse(
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
        Produtos produtos,
        BigDecimal quantidade,
        BigDecimal valorEmEstoque,
        BigDecimal quantidadeReservada,
        EstoqueTipo estoqueTipo,
        TipologiaEstoque tipologiaEstoque
) {
    public static EstoqueResponse toResponse(Estoque estoque){
        if (estoque==null){
            return null;
        }
        return new EstoqueResponse(
                estoque.getUuid(),
                estoque.getCreatedBy(),
                estoque.getLastModifiedBy(),
                estoque.getCreatedAt(),
                estoque.getCreatedAt(),
                estoque.getProduto(),
                estoque.getQuantidade(),
                estoque.getValorEmEstoque(),
                estoque.getQuantidadeReservada(),
                estoque.getEstoqueTipo(),
                estoque.getTipologiaEstoque()
        );
    }
}

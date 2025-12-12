package coelhostore.storageapi.api.dtos;

import coelhostore.storageapi.domain.Estoque;
import coelhostore.storageapi.domain.EstoqueEntrada;
import coelhostore.storageapi.domain.Fornecedor;
import coelhostore.storageapi.domain.Produtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.format.annotation.DateTimeFormat;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ext.javatime.deser.LocalDateTimeDeserializer;
import tools.jackson.databind.ext.javatime.ser.LocalDateTimeSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonPropertyOrder({"uuid","createdBy","lastModifiedBy","createdAt","updatedAt",
"produto","fornecedor","quantidade","valorUnidade"
        ,"impostos","dataEntrada","valorTotalBruto","valorTotalLiquido"})
public record EstoqueEntradaResponse(
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
        Fornecedor fornecedor,
        BigDecimal quantidade,
        BigDecimal valorUnidade,
        BigDecimal impostos,
        LocalDate dataEntrada,
        BigDecimal valorTotalBruto,
        BigDecimal valorTotalLiquido
) {
    public static EstoqueEntradaResponse toResponse(EstoqueEntrada estoqueEntrada){
        if (estoqueEntrada==null){
            return null;
        }
        return new EstoqueEntradaResponse(
                estoqueEntrada.getUuid(),
                estoqueEntrada.getCreatedBy(),
                estoqueEntrada.getLastModifiedBy(),
                estoqueEntrada.getCreatedAt(),
                estoqueEntrada.getCreatedAt(),
                estoqueEntrada.getProduto(),
                estoqueEntrada.getFornecedor(),
                estoqueEntrada.getQuantidade(),
                estoqueEntrada.getValorUnidade(),
                estoqueEntrada.getImpostos(),
                estoqueEntrada.getDataEntrada(),
                estoqueEntrada.getValorTotalBruto(),
                estoqueEntrada.getValorTotalLiquido()
        );
    }
}

package coelhostore.storageapi.api.dtos;

import coelhostore.storageapi.domain.Cliente;
import coelhostore.storageapi.domain.EstoqueSaida;
import coelhostore.storageapi.domain.Produtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.format.annotation.DateTimeFormat;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ext.javatime.deser.LocalDateDeserializer;
import tools.jackson.databind.ext.javatime.deser.LocalDateTimeDeserializer;
import tools.jackson.databind.ext.javatime.ser.LocalDateSerializer;
import tools.jackson.databind.ext.javatime.ser.LocalDateTimeSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@JsonPropertyOrder({"uuid","createdBy","lastModifiedBy","createdAt","updatedAt"
        ,"produtos","quantidade","valorSaida","dataSaida","motivoSaida","cliente"})
public record EstoqueSaidaResponse (
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
        BigDecimal valorSaida,
        BigDecimal transporteValor,
        BigDecimal imposto,
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        @JsonSerialize(using = LocalDateSerializer.class)
        @JsonDeserialize(using = LocalDateDeserializer.class)
        @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
        LocalDate dataSaida,
        String motivoSaida,
        Cliente cliente

){
    public static EstoqueSaidaResponse toResponse(EstoqueSaida estoqueSaida){
        if (estoqueSaida==null){
            return null;
        }
        return new EstoqueSaidaResponse(
                estoqueSaida.getUuid(),
                estoqueSaida.getCreatedBy(),
                estoqueSaida.getLastModifiedBy(),
                estoqueSaida.getCreatedAt(),
                estoqueSaida.getCreatedAt(),
                estoqueSaida.getProduto(),
                estoqueSaida.getQuantidade(),
                estoqueSaida.getValorSaida(),
                estoqueSaida.getTransporteValor(),
                estoqueSaida.getImposto(),
                estoqueSaida.getDataSaida(),
                estoqueSaida.getMotivoSaida(),
                estoqueSaida.getCliente()
        );
    }
}

package coelhostore.storageapi.api.dtos;

import coelhostore.storageapi.domain.Cliente;
import coelhostore.storageapi.domain.EstoqueSaida;
import coelhostore.storageapi.domain.Produtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ext.javatime.deser.LocalDateDeserializer;
import tools.jackson.databind.ext.javatime.ser.LocalDateSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EstoqueSaidaRequest (
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
    public static EstoqueSaida toEntidade(EstoqueSaidaRequest estoqueSaidaRequest){
        if (estoqueSaidaRequest==null){
            return null;
        }
        return new EstoqueSaida(
                estoqueSaidaRequest.produtos,
                estoqueSaidaRequest.quantidade,
                estoqueSaidaRequest.valorSaida,
                estoqueSaidaRequest.transporteValor,
                estoqueSaidaRequest.imposto,
                estoqueSaidaRequest.dataSaida,
                estoqueSaidaRequest.motivoSaida,
                estoqueSaidaRequest.cliente
        );
    }
}

package coelhostore.storageapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_estoque_saida")
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EstoqueSaida extends Entidade{
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produtos produto;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantidade;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorSaida;
    @Column(nullable = false)
    private LocalDate dataSaida;
    @Column(nullable = false)
    private String motivoSaida; // VENDA, CONSUMO, PERDA, AJUSTE, RESERVA
}

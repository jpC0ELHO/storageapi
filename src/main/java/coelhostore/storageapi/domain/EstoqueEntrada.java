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
@Table(name = "tb_estoque_entrada")
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EstoqueEntrada extends Entidade{
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produtos produto;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantidade;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorUnidade;
    @Column(precision = 5, scale = 2)
    private BigDecimal impostoImportacao;
    @Column(nullable = false)
    private LocalDate dataEntrada;
}

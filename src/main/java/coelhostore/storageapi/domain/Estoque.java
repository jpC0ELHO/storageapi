package coelhostore.storageapi.domain;

import coelhostore.storageapi.domain.enums.EstoqueTipo;
import coelhostore.storageapi.domain.enums.TipologiaEstoque;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@Data
@Table(name = "tb_estoque")
@Entity
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Estoque extends Entidade{
    @ManyToOne
    @JoinColumn(name = "produto_id",nullable = false)
    private Produtos produto;
    @Column(length = 10, nullable = false, precision = 5, scale = 2)
    private BigDecimal quantidade;
    @Column(name = "valor_em_estoque",nullable = false,scale = 2,precision = 12)
    private BigDecimal valorEmEstoque;
    //fornecer o tipo de estoque em que esta armazenado
    @Enumerated(EnumType.STRING)
    private EstoqueTipo estoqueTipo;
    //Quantidade definida em unidades de medida
    @Enumerated(EnumType.STRING)
    private TipologiaEstoque tipologiaEstoque;
    @Column(nullable = false)
    private BigDecimal quantidadeReservada;
}

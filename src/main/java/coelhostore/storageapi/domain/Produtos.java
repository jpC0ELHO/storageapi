package coelhostore.storageapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_produtos")
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Produtos extends Entidade{
    @Column(name = "sku",unique = true,nullable = false)
    private String sku;
    @Column(name = "nome_produto", nullable = false)
    private String nomeProduto;
    @Column(nullable = false)
    private String unidadeMedida;
}

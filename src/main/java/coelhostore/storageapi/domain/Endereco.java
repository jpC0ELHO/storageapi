package coelhostore.storageapi.domain;

import coelhostore.storageapi.domain.enums.EstadoBr;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@Table(name = "tb_endereco")
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Endereco {
    @Column(nullable = false, unique = false, length = 100)
    private String logradouro;
    @Column(nullable = false, unique = false, length = 10)
    private String numero;
    @Column(nullable = false, unique = false, length = 100)
    private String complemento;
    @Column(nullable = false, unique = false, length = 100)
    private String bairro;
    @Column(nullable = false, unique = false, length = 100)
    private String cidade;
    @Column(nullable = false, unique = false, length = 20)
    private EstadoBr estado;
    @NotNull
    @NotBlank
    @Column(nullable = false, unique = false, length = 10)
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O campo 'cep' deve ter o formato '12345-678'")
    private String cep;
}
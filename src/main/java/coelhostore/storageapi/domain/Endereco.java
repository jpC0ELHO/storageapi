package coelhostore.storageapi.domain;

import coelhostore.storageapi.domain.enums.EstadoBr;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@Table(name = "tb_endereco")
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Endereco extends Entidade{
    @Column(nullable = false, unique = false, length = 100)
    private String logradouro;
    @Column(nullable = false, unique = false, length = 10)
    private String numero;
    @Column(unique = false, length = 100)
    private String complemento;
    @Column(nullable = false, unique = false, length = 100)
    private String bairro;
    @Column(nullable = false, unique = false, length = 100)
    private String cidade;
    @Enumerated
    private EstadoBr estado;
    @NotBlank
    @Column(nullable = false, unique = false, length = 9)
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O campo 'cep' deve ter o formato '12345-678'")
    private String cep;
}
package coelhostore.storageapi.domain;

import coelhostore.storageapi.domain.enums.TelefoneTipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;


@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Table(name = "tb_contato")
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Contato {
    @Column(name = "numero",unique = true,length = 18)
    private String number;

    @Enumerated
    @Column(name = "tipo_telefone")
    private TelefoneTipo telefoneTipo;
}

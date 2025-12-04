package coelhostore.storageapi.domain;

import coelhostore.storageapi.domain.enums.TelefoneTipo;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Embeddable
public class Contato {
    @Column(name = "numero",unique = true,length = 18)
    private String number;
    @Enumerated
    @Column(name = "tipo_telefone")
    private TelefoneTipo telefoneTipo;
}

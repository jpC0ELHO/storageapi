package coelhostore.storageapi.domain;

import coelhostore.storageapi.domain.enums.DocumentoTipo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class Cliente extends Entidade{
    private String nome;
    @Enumerated(EnumType.STRING)
    private DocumentoTipo documentoTipo;
    @Embedded
    private Contato contato;
    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;
}

package coelhostore.storageapi.domain;

import coelhostore.storageapi.domain.enums.DocumentoTipo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class Fornecedor {
    @Column(nullable = false)
    private String nome;
    @Enumerated(EnumType.STRING)
    private DocumentoTipo documentoTipo;
    private Integer numeroDocumento;
    @Embedded
    private Contato contato;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}

package coelhostore.storageapi.domain.enums;

public enum Role {
    ADMIN("ADM"),
    COORDENADOR("COD"),
    SUPERVISOR("SUP"),
    GERENCIAMENTO("GEREN"),
    PADRAO("PADRAO");

    private final String descricao;

    Role(String descricao){
        this.descricao=descricao;
    }
}


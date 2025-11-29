package coelhostore.storageapi.domain.enums;

public enum TelefoneTipo {
    PESSOAL("PESSOAL"),
    RESIDENCIAL("RESIDENCIAL"),
    OUTROS("OUTROS");

    private String name;

    TelefoneTipo(String name){
        this.name=name;
    }
}

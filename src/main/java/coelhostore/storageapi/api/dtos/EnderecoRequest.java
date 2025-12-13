package coelhostore.storageapi.api.dtos;

import coelhostore.storageapi.domain.Endereco;
import coelhostore.storageapi.domain.enums.EstadoBr;

public record EnderecoRequest(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        EstadoBr estadoBr,
        String cep
){
    public static Endereco toEntidade(EnderecoRequest enderecoRequest){
        if (enderecoRequest==null){
            return null;
        }
        return new Endereco(
                enderecoRequest.logradouro,
                enderecoRequest.numero,
                enderecoRequest.complemento,
                enderecoRequest.bairro,
                enderecoRequest.cidade,
                enderecoRequest.estadoBr,
                enderecoRequest.cep
        );
    }
}

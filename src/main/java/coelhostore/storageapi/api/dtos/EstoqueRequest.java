package coelhostore.storageapi.api.dtos;

import coelhostore.storageapi.domain.Estoque;
import coelhostore.storageapi.domain.Produtos;
import coelhostore.storageapi.domain.enums.EstoqueTipo;
import coelhostore.storageapi.domain.enums.TipologiaEstoque;

import java.math.BigDecimal;

public record EstoqueRequest (
    Produtos produtos,
    BigDecimal quantidade,
    BigDecimal valorEmEstoque,
    BigDecimal quantidadeReservada,
    EstoqueTipo estoqueTipo,
    TipologiaEstoque tipologiaEstoque

){
    public static Estoque toEntidade(EstoqueRequest estoqueRequest){
        if (estoqueRequest==null){
            return null;
        }
        return new Estoque(
                estoqueRequest.produtos,
                estoqueRequest.quantidade,
                estoqueRequest.valorEmEstoque,
                estoqueRequest.quantidadeReservada,
                estoqueRequest.estoqueTipo,
                estoqueRequest.tipologiaEstoque
        );
    }
}

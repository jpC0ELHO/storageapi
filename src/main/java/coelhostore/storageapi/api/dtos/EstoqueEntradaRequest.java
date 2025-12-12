package coelhostore.storageapi.api.dtos;

import coelhostore.storageapi.domain.EstoqueEntrada;
import coelhostore.storageapi.domain.Fornecedor;
import coelhostore.storageapi.domain.Produtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EstoqueEntradaRequest(
        Produtos produtos,
        Fornecedor fornecedor,
        BigDecimal quantidade,
        BigDecimal valorUnidade,
        BigDecimal impostos,
        LocalDate  dataEntrada,
        BigDecimal valorTotalBruto,
        BigDecimal valorTotalLiquido
) {
    public static EstoqueEntrada toEntidade(EstoqueEntradaRequest estoqueEntradaRequest){
        if (estoqueEntradaRequest==null){
            return null;
        }
        return new EstoqueEntrada(
                estoqueEntradaRequest.produtos,
                estoqueEntradaRequest.fornecedor,
                estoqueEntradaRequest.quantidade,
                estoqueEntradaRequest.valorUnidade,
                estoqueEntradaRequest.impostos,
                estoqueEntradaRequest.dataEntrada,
                estoqueEntradaRequest.valorTotalBruto,
                estoqueEntradaRequest.valorTotalLiquido
        );
    }
}

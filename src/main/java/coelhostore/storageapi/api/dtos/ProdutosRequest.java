package coelhostore.storageapi.api.dtos;

import coelhostore.storageapi.domain.Produtos;

public record ProdutosRequest(
        String sku,
        String nomeProduto,
        String unidadeMedida
) {
    public static Produtos toEntidade(ProdutosRequest produtosRequest){
        if (produtosRequest==null){
            return null;
        }
        return new Produtos(
                produtosRequest.sku,
                produtosRequest.nomeProduto(),
                produtosRequest.unidadeMedida
        );
    }
}

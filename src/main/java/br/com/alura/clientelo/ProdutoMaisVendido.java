package br.com.alura.clientelo;

public class ProdutoMaisVendido {
    String produto;
    Integer quantidade;

    public ProdutoMaisVendido(String produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}

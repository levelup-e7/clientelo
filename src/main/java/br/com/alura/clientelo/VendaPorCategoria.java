package br.com.alura.clientelo;

import java.math.BigDecimal;

public class VendaPorCategoria {
    String categoria;
    BigDecimal quantidade;
    BigDecimal montante;

    public VendaPorCategoria(String categoria, BigDecimal quantidade, BigDecimal montante) {
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.montante = montante;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public BigDecimal getMontante() {
        return montante;
    }
}

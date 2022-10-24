package br.com.alura.clientelo.test;

import br.com.alura.clientelo.Pedido;
import br.com.alura.clientelo.ProdutoMaisVendido;
import br.com.alura.clientelo.Relatorios;
import br.com.alura.clientelo.VendaPorCategoria;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RelatoriosTest {

    static List<Pedido> pedidos = new ArrayList<Pedido>();

    @BeforeAll
    static void setup() {
        pedidos.add(new Pedido("binoculo", "lesma", null, new BigDecimal(10), 3, null));
        pedidos.add(new Pedido("seila", "xexelento", null, new BigDecimal(20), 2, null));
        pedidos.add(new Pedido("qualquer", "cria", null, new BigDecimal(30), 9, null));
        pedidos.add(new Pedido("naosei", "xarizardo", null, new BigDecimal(40), 5, null));
        pedidos.add(new Pedido("xablau", "iPud", null, new BigDecimal(50), 7, null));
        pedidos.add(new Pedido("xablonso", "batata", null, new BigDecimal(60), 15, null));
    }

    @Test
    public void deveRetornarProdutoMaisVendido() {
        List<ProdutoMaisVendido> produtoMaisVendidos = Relatorios.gerarRelatorioProdutosMaisVendidos(pedidos);

        assertEquals(produtoMaisVendidos.stream().findFirst().get().getProduto(), "batata");
        assertEquals(produtoMaisVendidos.stream().findFirst().get().getQuantidade(), 15);
    }

    @Test
    public void deveRetornarRelatorioDeVendasPorCategoria() {
        List<VendaPorCategoria> vendaPorCategoria = Relatorios.gerarRelatorioVendasPorCategoria(pedidos);

        assertEquals(vendaPorCategoria.stream().findFirst().get().getCategoria(), "binoculo");
        assertEquals(vendaPorCategoria.stream().findFirst().get().getQuantidade(), new BigDecimal(3));
        assertEquals(vendaPorCategoria.stream().findFirst().get().getMontante(),  new BigDecimal(30));
    }
}
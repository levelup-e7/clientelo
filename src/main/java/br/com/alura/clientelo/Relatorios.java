package br.com.alura.clientelo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

public abstract class Relatorios {

    private static final Logger logger = LoggerFactory.getLogger(Relatorios.class);

        //listar 3 produtos (em ordem decrescente pela quantidade) com a maior quantidade vendida
    public static List<ProdutoMaisVendido> gerarRelatorioProdutosMaisVendidos(List<Pedido> pedidos) {
        List<ProdutoMaisVendido> produtosMaisVendidos = new ArrayList<>();

        pedidos.sort(Comparator.comparing(Pedido::getQuantidade).reversed());
        pedidos.forEach(pedido -> {
            produtosMaisVendidos.add(new ProdutoMaisVendido(pedido.getProduto(), pedido.getQuantidade()));

            logger.info("PRODUTO: {}", pedido.getProduto());
            logger.info("QUANTIDADE: {} \n", pedido.getQuantidade());
        });

        return produtosMaisVendidos;
    }

    // em ordem alfabetica, listar o nome da categoria, a quantidade de produtos dela que foi vendido e o montante vendido
        public static List<VendaPorCategoria> gerarRelatorioVendasPorCategoria(List<Pedido> pedidos) {
            List<VendaPorCategoria> vendaPorCategoria = new ArrayList<>();

            List<String> categorias = pedidos.stream()
                    .map(Pedido::getCategoria)
                    .distinct()
                    .sorted().toList();

            for (String categoria : categorias) {

                BigDecimal montante = BigDecimal.ZERO;
                BigDecimal quantidade = BigDecimal.ZERO;

                montante = pedidos.stream()
                        .filter(p -> p.getCategoria().equals(categoria))
                        .map(Pedido::getTotalPedido)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                quantidade = pedidos.stream()
                        .filter(p -> p.getCategoria().equals(categoria))
                        .map(p -> new BigDecimal(p.getQuantidade()))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                logger.info("CATEGORIA: {}", categoria);
                logger.info("QUANTIDADE VENDIDA: {}", quantidade);
                logger.info("QUANTIDADE MONTANTE: {} \n", montante);

                vendaPorCategoria.add(new VendaPorCategoria(categoria, quantidade, montante));
            };
            return vendaPorCategoria;
        }


    /* em ordem alfabetica, listar o produto mais caro vendido de cada categoria, categoria/produto/preco
    CATEGORIA: AUTOMOTIVA
    PRODUTO: Jogo de pneus
    PREÇO: R$ 1.276,79 */
}

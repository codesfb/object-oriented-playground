package DeclarativaVsImperativa;

import java.util.*;

public class ExercicioDeclarativo {


    public static class Produto {
        private String nome;
        private String categoria;
        private double preco;
        private int estoque;

        public Produto(String nome, String categoria, double preco, int estoque) {
            this.nome = nome;
            this.categoria = categoria;
            this.preco = preco;
            this.estoque = estoque;
        }

        public String getNome() {
            return nome;
        }

        public String getCategoria() {
            return categoria;
        }

        public double getPreco() {
            return preco;
        }

        public int getEstoque() {
            return estoque;
        }

        @Override
        public String toString() {
            return nome + " - " + categoria +
                    " - R$" + preco +
                    " - estoque: " + estoque;
        }
    }

    // 1) Retorne os nomes dos produtos em estoque
    public static List<String> nomesDisponiveis(List<Produto> produtos) {
        List<String> nomes = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getEstoque() > 0) {
                nomes.add(produto.getNome());
            }
        }

        return nomes;
    }

    public static List<String> nomesDisponiveisDeclaativo(List<Produto> produtos) {
        return produtos.stream()
                .filter(e -> e.getEstoque() > 0)
                .map(Produto::getNome)
                .toList();

    }

    // 2) Retorne os produtos mais caros que um valor informado
    public static List<Produto> produtosCaros(List<Produto> produtos, double valor) {
        List<Produto> resultado = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getPreco() > valor) {
                resultado.add(produto);
            }
        }

        return resultado;
    }

    public static List<Produto> produtosCarosDec(List<Produto> produtos, double valor) {
        return produtos.stream()
                .filter(e -> e.getPreco() > valor)
                .toList();


    }

    // 3) Calcule o valor total do estoque
    public static double valorTotalEstoque(List<Produto> produtos) {
        double total = 0;

        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getEstoque();
        }

        return total;
    }

    public static double valorTotalEstoqueDec(List<Produto> produtos) {
        return produtos.stream()
                .mapToDouble(e -> e.getPreco() * e.getEstoque())
                .sum();


    }


    // 4) Verifique se existe algum produto sem estoque
    public static boolean existeProdutoSemEstoque(List<Produto> produtos) {
        for (Produto produto : produtos) {
            if (produto.getEstoque() == 0) {
                return true;
            }
        }

        return false;
    }


    public static boolean existeProdutoSemEstoqueDec(List<Produto> produtos) {
        return produtos.stream()
                .anyMatch(e -> e.getEstoque() == 0);
    }


    // 5) Conte quantos produtos pertencem a uma categoria
    public static int quantidadePorCategoria(List<Produto> produtos, String categoria) {
        int contador = 0;

        for (Produto produto : produtos) {
            if (produto.getCategoria().equals(categoria)) {
                contador++;
            }
        }

        return contador;
    }

    public static long quantidadePorCategoriaDec(List<Produto> produtos, String categoria) {
        return produtos.stream()
                .filter(e -> e.getCategoria().equals(categoria))
                .count();
    }


    // 6) Retorne o produto mais caro
    public static Produto produtoMaisCaro(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            return null;
        }

        Produto maisCaro = produtos.get(0);

        for (Produto produto : produtos) {
            if (produto.getPreco() > maisCaro.getPreco()) {
                maisCaro = produto;
            }
        }

        return maisCaro;
    }

    public static Produto produtoMaisCaroDec(List<Produto> produtos) {

        return produtos.stream()
                .max(Comparator.comparing(Produto::getPreco))
                .orElse(null);
    }


    // 7) Retorne os produtos ordenados pelo preço
    public static List<Produto> ordenarPorPreco(List<Produto> produtos) {
        List<Produto> copia = new ArrayList<>(produtos);

        Collections.sort(copia, new Comparator<Produto>() {
            @Override
            public int compare(Produto p1, Produto p2) {
                return Double.compare(p1.getPreco(), p2.getPreco());
            }
        });

        return copia;
    }

    public static List<Produto> ordenarPorPrecoDec(List<Produto> produtos) {
        return produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco))
                .toList();

    }


    // 8) Retorne apenas os nomes em maiúsculo
    public static List<String> nomesMaiusculos(List<Produto> produtos) {
        List<String> nomes = new ArrayList<>();

        for (Produto produto : produtos) {
            nomes.add(produto.getNome().toUpperCase());
        }

        return nomes;
    }

    public static List<String> nomesMaiusculosDec(List<Produto> produtos) {

        return produtos.stream()
                .map(e -> e.getNome().toUpperCase())
                .toList();
    }


    // 9) Busque um produto pelo nome
    public static Produto buscarPorNome(List<Produto> produtos, String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }

        return null;
    }

    public static Produto buscarPorNomeDec(List<Produto> produtos, String nome) {
        return produtos.stream()
                .filter(e-> nome.equals(e.getNome()))
                .findFirst()
                .orElse(null);

    }

    // 10) Verifique se todos os produtos possuem estoque
    public static boolean todosTemEstoque(List<Produto> produtos) {
        for (Produto produto : produtos) {
            if (produto.getEstoque() <= 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean todosTemEstoqueDec(List<Produto> produtos) {
        return produtos.stream()
                .allMatch(e -> e.getEstoque()>0);

    }


}
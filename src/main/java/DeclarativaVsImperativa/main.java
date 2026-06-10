import DeclarativaVsImperativa.ExercicioDeclarativo;
import DeclarativaVsImperativa.ExercicioDeclarativo.Produto;


import static DeclarativaVsImperativa.ExercicioDeclarativo.*;

void main() {
    List<Produto> produtos = List.of(
            new Produto("Notebook", "Eletrônicos", 3500, 5),
            new Produto("Mouse", "Eletrônicos", 120, 10),
            new Produto("Cadeira", "Móveis", 800, 0),
            new Produto("Mesa", "Móveis", 1200, 2),
            new Produto("Monitor", "Eletrônicos", 950, 3)
    );

    System.out.println(nomesDisponiveis(produtos));
    System.out.println(nomesDisponiveisDeclaativo(produtos));
    System.out.println(produtosCaros(produtos, 1000));
    System.out.println(produtosCarosDec(produtos, 1000));
    System.out.println(valorTotalEstoque(produtos));
    System.out.println(valorTotalEstoqueDec(produtos));
    System.out.println(existeProdutoSemEstoque(produtos));
    System.out.println(existeProdutoSemEstoqueDec(produtos));
    System.out.println(quantidadePorCategoria(produtos, "Eletrônicos"));
    System.out.println(quantidadePorCategoriaDec(produtos, "Eletrônicos"));
    System.out.println(produtoMaisCaro(produtos));
    System.out.println(produtoMaisCaroDec(produtos));
    System.out.println(ordenarPorPreco(produtos));
    System.out.println(ordenarPorPrecoDec(produtos));
    System.out.println(nomesMaiusculos(produtos));
    System.out.println(nomesMaiusculosDec(produtos));
    System.out.println(buscarPorNome(produtos, "Mesa"));
    System.out.println(buscarPorNomeDec(produtos, "Mesa"));
    System.out.println(buscarPorNomeDec(produtos, "Notebook"));
    System.out.println(todosTemEstoque(produtos));
    System.out.println(todosTemEstoqueDec(produtos));
}
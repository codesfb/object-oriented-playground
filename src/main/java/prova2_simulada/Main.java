package prova2_simulada;


import prova2_simulada.application.*;
import prova2_simulada.domain.FakeDeclaracaoRepository;

public class Main {
    void main(){
        DeclaracaoRepository repo = new FakeDeclaracaoRepository();

        final AdicionarGastoTributavelService addGastoService = new AdicionarGastoTributavelService(repo);
        final CriarDeclaracoesService criarDeclaracaoService = new CriarDeclaracoesService(repo);
        final CriaRelatorioDeclaracoesServices relatorioService = new CriaRelatorioDeclaracoesServices(repo);

        criarDeclaracaoService.criarDeclaracoes(50_000.0, 5_000.0);

        addGastoService.adicionarGasto(1, "Corote", "123", 3.59, TipoGasto.EDUCACAO, "IFSP");
        addGastoService.adicionarGasto(2, "Unimed", "312", 1_000.0, TipoGasto.SAUDE, "31231RDN");

        System.out.println(relatorioService.criarRelatorio());
    }
}

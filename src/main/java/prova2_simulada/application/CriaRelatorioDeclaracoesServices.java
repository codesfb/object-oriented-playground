package prova2_simulada.application;

import prova2_simulada.domain.Declaracao;

public class CriaRelatorioDeclaracoesServices {
    private final DeclaracaoRepository repo;

    public CriaRelatorioDeclaracoesServices(DeclaracaoRepository repo) {
        this.repo = repo;
    }

    public String criarRelatorio (){
        final Declaracao completa = repo.buscarPorId(1L).orElseThrow(IllegalStateException::new);
        final Declaracao simplificada = repo.buscarPorId(2L).orElseThrow(IllegalStateException::new);

        return simplificada + "\n\n" + completa;
    }
}

package prova2_simulada.application;

import prova2_simulada.domain.DeclaracaoCompleta;
import prova2_simulada.domain.DeclaracaoSimplificada;

public class CriarDeclaracoesService {
    private final DeclaracaoRepository repo;

    public CriarDeclaracoesService(DeclaracaoRepository repo) {
        this.repo = repo;
    }

    public void criarDeclaracoes(double ganhoTributavel, double valorPago){
        if(ganhoTributavel < 0) throw new IllegalArgumentException("Ganho tributável inválido: " + ganhoTributavel);
        if(valorPago < 0) throw new IllegalArgumentException("Valor pago inválido: " + valorPago);

        final DeclaracaoCompleta declaracaoCompleta = new DeclaracaoCompleta(1, ganhoTributavel, valorPago);
        final DeclaracaoSimplificada declaracaoSimplificada = new DeclaracaoSimplificada(2, ganhoTributavel, valorPago);

        repo.salvar(declaracaoCompleta);
        repo.salvar(declaracaoSimplificada);
    }
}

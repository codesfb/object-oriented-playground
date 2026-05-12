package prova2_simulada.application;

import prova2_simulada.domain.DeclaracaoCompleta;
import prova2_simulada.domain.Gasto;
import prova2_simulada.domain.GastoEducacao;
import prova2_simulada.domain.GastoSaude;

public class AdicionarGastoTributavelService {
    private final DeclaracaoRepository repo;

    public AdicionarGastoTributavelService(DeclaracaoRepository repo) {
        this.repo = repo;
    }

    public void adicionarGasto(long id, String descricao, String cnpj, double valor, TipoGasto tipo, String adicional){
        if(id < 0) throw new IllegalArgumentException("Id não pode ser negativo"); // vale a mesma ideia para todos

        final DeclaracaoCompleta declaracao = (DeclaracaoCompleta) repo.buscarPorId(1).orElseThrow(IllegalStateException::new);

        Gasto gasto = switch (tipo){
            case EDUCACAO -> new GastoEducacao(id, cnpj, descricao, valor, adicional);
            case SAUDE -> new GastoSaude(id, cnpj, descricao, valor, adicional);
        };

        declaracao.addGasto(gasto);
        repo.atualizar(declaracao);
    }
}

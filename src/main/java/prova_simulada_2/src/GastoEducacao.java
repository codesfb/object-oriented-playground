package prova_simulada_2.src;

import java.util.Objects;

public final class GastoEducacao extends Gasto {
    private final String nomeInstituicao;
    public static double DEDUCAO_MAX_EDUCA = 2000;
    public GastoEducacao(long id, String descricao, double valor, String cnpj, String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public static double getDeducaoMaxEduca() {
        return DEDUCAO_MAX_EDUCA;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GastoEducacao that = (GastoEducacao) o;
        return Objects.equals(nomeInstituicao, that.nomeInstituicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nomeInstituicao);
    }
}

package prova_simulada_2.src;
import java.util.Objects;

public final class GastoSaude extends Gasto{
    private final String registroConselho;
    public static double DEDUCAO_MAX_SAUDE = 1500;
    public GastoSaude(long id, String descricao, double valor, String cnpj, String registroConselho) {
        super(id, descricao, valor, cnpj);
        this.registroConselho = registroConselho;
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    public static double getDeducaoMaxSaude() {
        return DEDUCAO_MAX_SAUDE;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GastoSaude that = (GastoSaude) o;
        return Objects.equals(registroConselho, that.registroConselho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), registroConselho);
    }
}

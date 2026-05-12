package prova2_simulada.domain;

public final class GastoSaude extends Gasto {
    public static final double MAX_GASTO_SAUDE = 1_500.0;
    private String registroConselho;

    public GastoSaude(long id, String cnpj, String descricao, double valor, String registroConselho) {
        super(id, cnpj, descricao, valor);
        this.registroConselho = registroConselho;
    }

    @Override
    public String toString() {
        return "Gasto com Saúde | " + " registro = " + registroConselho + " " + super.toString();
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    public void setRegistroConselho(String registroConselho) {
        this.registroConselho = registroConselho;
    }
}

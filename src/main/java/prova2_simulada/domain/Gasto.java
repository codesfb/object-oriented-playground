package prova2_simulada.domain;

public abstract sealed class Gasto permits GastoEducacao, GastoSaude  {
    private final long id;
    private String cnpj;
    private String descricao;
    private double valor;


    public Gasto(long id, String cnpj, String descricao, double valor) {
        this.id = id;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Gasto gasto = (Gasto) o;
        return id == gasto.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("| id = %d | cnpj = %s  descricao = %s | valor = R$%.2f| ",
                id, cnpj, descricao, valor);
    }

    public long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

package prova2_simulada.domain;

import prova2_simulada.persistence.Entidade;

public abstract sealed class Declaracao implements Entidade<Long> permits DeclaracaoCompleta, DeclaracaoSimplificada{
    private final long id;
    private double ganhoTributavel;
    private double valorPago;

    public Declaracao(long id, double ganhoTributavel, double valorPago) {
        this.id = id;
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
    }

    public final double getValorAPagar(){
        return getValorImposto() - valorPago - getGastosDedutiveis();
    }

    public abstract double getValorImposto();

    public double getGastosDedutiveis(){
        return 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Declaracao that = (Declaracao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("| id = %d | Ganho tributável = R$%.2f | Valor já pago = R$%.2f | Valor do imposto = R$%.2f | Valor a pagar = R$%.2f",
                id, ganhoTributavel, valorPago, getValorImposto(), getValorAPagar());
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public void setGanhoTributavel(double ganhoTributavel) {
        this.ganhoTributavel = ganhoTributavel;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    @Override
    public Long getId() {
        return id;
    }
}

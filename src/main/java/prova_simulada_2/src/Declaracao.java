package prova_simulada_2.src;


import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public abstract sealed class Declaracao permits DeclaracaoCompleta, DeclaracaoSimplificada {
    private final double ganhoTributavel;
    private final double valorPago;

    public Declaracao(double ganhoTributavel, double valorPago) {
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
    }


    public  double getValorAPagar(){
        return this.getValorImposto() - this.valorPago - getDespesaDedutivel();
    };
    public double getDespesaDedutivel(){
        return 0;
    };

    public abstract double getValorImposto();


    @Override
    public String toString() {
        return "Declaracao{" +
                "ganhoTributavel=" + ganhoTributavel +
                ", valorPago=" + valorPago +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return Double.compare(ganhoTributavel, that.ganhoTributavel) == 0 && Double.compare(valorPago, that.valorPago) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ganhoTributavel, valorPago);
    }

    public double getGanhoTributavel() {

        return ganhoTributavel;
    }

    public double getValorPago() {
        return valorPago;
    }
}

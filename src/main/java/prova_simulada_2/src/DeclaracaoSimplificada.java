import java.util.OptionalDouble;

public non-sealed class DeclaracaoSimplificada extends Declaracao {
    public DeclaracaoSimplificada(double ganhoTributavel, double valorPago) {
        super(ganhoTributavel, valorPago);
    }

    @Override
    public double getValorImposto() {
        double excesso = super.getDespesaDedutivel() - 22847.88;
        return excesso > 0? excesso* 0.20:0;
    }


}

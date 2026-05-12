package prova_simulada_2.src;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public non-sealed class DeclaracaoCompleta extends Declaracao {

    List<Gasto> gastos = new ArrayList<>();

    public DeclaracaoCompleta(double ganhoTributavel, double valorPago) {
        super(ganhoTributavel, valorPago);
    }

    @Override
    public double getDespesaDedutivel(){

        return gastos.stream().mapToDouble(e ->
        {
            if(e instanceof GastoSaude){
                return Math.min(e.getValor(), GastoSaude.DEDUCAO_MAX_SAUDE);
            }else if(e instanceof GastoEducacao){
                return Math.min(e.getValor(), GastoEducacao.DEDUCAO_MAX_EDUCA);
            }
            return 0;
        }).sum();
    };

    @Override
    public double getValorImposto() {
        double ganho = super.getGanhoTributavel();
        double imposto = 0;

        if(ganho > 55976.16){
            imposto+=(ganho -  55976.16) * 0.275;
            ganho=55976.16;
        }

        if(ganho > 45012.73){
            imposto+=(ganho -  45012.73) * 0.225;
            ganho=45012.73;
        }
        if(ganho > 33919.93){
            imposto+=(ganho -  33919.93) * 0.15;
            ganho=33919.93;
        }
        if(ganho > 22847.88){
            imposto+=(ganho -  22847.88) * 0.075;

        }
        return imposto;
    }

    public void AddGasto(Gasto gasto){
        gastos.add(gasto);
    }
    public void removeGasto(Gasto gasto){
        gastos.remove(gasto);
    }

}

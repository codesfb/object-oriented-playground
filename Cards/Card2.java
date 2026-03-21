enum Naipe {
    COPAS, ESPADAS, OUROS, PAUS
}
enum Valor {
    AS, DOIS, TRES, QUATRO, CINCO, SEIS, SETE,
    OITO, NOVE, DEZ, VALETE, DAMA, REI
}
public class Card2 {

    private final Naipe naipe;
    private final Valor valor;

    public Card2(Naipe naipe, Valor valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor + " de " + naipe;
    }


    public static void main(String[] args) {
        Card2 carta1 = new Card2(Naipe.COPAS, Valor.AS);

        System.out.println("Minha carta é: " + carta1);
    }
}
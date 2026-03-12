import java.util.ArrayList;

public class materialExtra {
    public static void main(String[] args){

        //uso do var
        var number =  5;
        var nome = "Fabio";

        System.out.println(number +" "+  nome);

        //Conversões e promoções
        //Widening Primitive Conversion
        int i = 100;
        long l = i;     // Automático: int cabe dentro de long
        double d = l;   // Automático: long cabe dentro de double

        System.out.println(d); // Saída: 100.0


        //Narrowing Primitive Conversion
        double valorDouble = 9.78;
        int valorInt = (int) valorDouble; // Cast explícito: corta a parte decimal

        System.out.println(valorInt); // Saída: 9 (perda de precisão)

        int grande = 130;
        byte pequeno = (byte) grande; // O byte só vai até 127.
        System.out.println(pequeno); // Saída: -126 (estouro de bits/overflow)


        //Promoção Numérica Binária

        int a = 5;
        double b = 2.5;

        // O 'a' é promovido a double para a conta ser: 5.0 * 2.5
        Object resultado = a * b;

        System.out.println(resultado.getClass().getSimpleName()); // Saída: Double

        // Boxing e Unboxing
        // Autoboxing: primitivo para objeto
        Integer objetoInt = 10;

        // Unboxing: objeto para primitivo
        int primitivoInt = objetoInt;

        // Exemplo em listas (que só aceitam objetos)
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(5); // O int 5 vira um objeto Integer automaticamente


        class Animal {}
        class Cachorro extends Animal {}

        // Widening Reference (Upcasting): Automático
        Animal meuPet = new Cachorro();

        // Narrowing Reference (Downcasting): Exige Cast
        Cachorro apenasCachorro = (Cachorro) meuPet;



    }

}
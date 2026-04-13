package main.java.ListaNivelamento.src.main.java.br.edu.ifsp.list01;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Ex03 {

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute()
        try (final Scanner scanner = new Scanner(System.in);) {
            if(scanner.hasNextInt()){
                final int ano = scanner.nextInt();
                final Ex03 ex03 = new Ex03();
                System.out.println(ex03.compute(ano));
            }else {
                System.out.println("Erro");
            }
        }catch (InputMismatchException e) {
            System.out.println("Erro");
        }

    }
    String compute(int input) {
//        String output = null;
//        //put your logic here
//        if (input <=0) return "Erro";
//        if((input % 400==0) )  return "Ano bissexto";
//        if(input % 4 == 0 && (input %100 == 1))  return "Ano bissexto";
//        if(input % 2 != 0) return "Ano nao bissexto";

        if(input <=0) return "Erro";
        if(input % 400==0)  return "Ano bissexto";
        if(input % 4 == 0 && input %100 !=0)  return "Ano bissexto";

        return "Ano nao bissexto";



    }


}




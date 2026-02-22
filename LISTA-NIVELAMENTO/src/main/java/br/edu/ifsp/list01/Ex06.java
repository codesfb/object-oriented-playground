package br.edu.ifsp.list01;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Sabe-se que uma lata de tinta tem um custo C e é capaz de pintar uma área de M metros quadrados.
    Faça um programa que leia a largura L, a altura A de uma parede, o valor C de uma lata de tinta e
    o rendimento M desta lata. Após isso, imprima quantas latas de tintas são necessárias e o custo
    total (com duas casas decimais). Assuma que não é possível comprar lata de tinta fracionada.

    Exemplos de entrada e saída:
    Entrada   	Saída
   4           4 20.00
   3
   5
    3

    Entrada	    Saída
    10.0        3 15.00
    2.0
    5.0
    7
*/
public class Ex06 {

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui

    final Scanner scanner = new Scanner(System.in);
    final double L = scanner.nextDouble();
    final double a = scanner.nextDouble();
    final double  c = scanner.nextDouble();
    final double m = scanner.nextDouble();
    final Ex06 ex06 = new Ex06();
    System.out.println(ex06.compute(L,a,c,m));
    scanner.close();





    }

    String compute(double L, double a, double c, double m) {
        int qtdLatas, areaTotal ; double custoTotal;
        areaTotal =(int)  (L* a);


        qtdLatas =(int) (areaTotal/m);        
        custoTotal= qtdLatas*c;


        return String.format(" %d %.2f",qtdLatas, custoTotal  );
    }
}

package br.edu.ifsp.list02;

/*
    Faça um programa que leia dados inteiros da temperatura diária durante uma semana,
    armazenando em um vetor. Na sequência, escreva quantos dias dessa semana a temperatura
    esteve acima da média. As sete temperaturas devem ser lidas na mesma linha, separada
    por espaço.

    Exemplos de entrada e saída esperada:

    Exemplo 1: Entrada = 2 2 2 2 2 2 3 | Saída = 1
    Exemplo 2: Entrada = 21 10 13 34 30 21 34 | Saída = 3
    Exemplo 3: Entrada = 2 2 2 2 2 2 1| Saída = 6
    Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".
*/

import java.util.Scanner;

public class Ex01 {

    public static final int DAYS_IN_WEEK = 7;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int[] temperaturas = new int[DAYS_IN_WEEK];
        for(int i =0; i < DAYS_IN_WEEK; i++) temperaturas[i]= scanner.nextInt();
        scanner.close();
        final Ex01 ex01 = new Ex01();
        System.out.println(ex01.compute(temperaturas));
    }

    int compute(int[] temperaturas) {
       int acimaDaMedia =0;
       int acc=0;
       for(int i =0; i < DAYS_IN_WEEK; i++) acc+=temperaturas[i];

       float media = acc/DAYS_IN_WEEK;

       for(int i =0; i < DAYS_IN_WEEK; i++) if(temperaturas[i] > media ) acimaDaMedia++;

        return acimaDaMedia;
    }
}

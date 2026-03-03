package br.edu.ifsp.list03;

import java.util.Scanner;

/*
Faça um programa que, dada uma String, encontra a primeira e a última substrings de tamanho K de acordo com a ordem
alfabética. Por exemplo, para a String “welcometojava” e K = 3; A substring “ava” é a primeira substring de tamanho
3 e “wel” é a última, considerando a ordem alfabética (saída: "ava wel"). Para dados de entrada inválidos, o programa
deverá imprimir uma String vazia.
 */
public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int number = scanner.nextInt();
        scanner.close();
        final Ex02 ex02 = new Ex02();
        System.out.println(ex02.compute(word, number));
    }

    String compute(String word, int number) {
        // if (word == null ||
        //         number <= 0 ||
        //         word.length() == 0 ||
        //         word == "" ||
        //         number < word.length())
        //     return "";

        if(word.length() < number || number == 0) return null;//null não ""(String vazia)



        String primeiraSubstring = word.substring(0, number);
        String substringMenor = primeiraSubstring;
        String substringMaior = primeiraSubstring;

        for (int i = 1; i <= word.length() - number; i++) {
            String atualSubstring = word.substring(i, i + number);
            
            //para não ter que comparar a tabela unicode achei esse metodo compareTo
            //mas pasicamente ava é menor que well por a < w 97 < 119 considerando que todas são minuscolas
            if (atualSubstring.compareTo(substringMenor) < 0)
                substringMenor = atualSubstring;

            if (atualSubstring.compareTo(substringMaior) > 0)
                substringMaior = atualSubstring;

        }

        return substringMenor + " " + substringMaior;
    }
}

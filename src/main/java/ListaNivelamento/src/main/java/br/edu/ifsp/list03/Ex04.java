package main.java.ListaNivelamento.src.main.java.br.edu.ifsp.list03;

import java.util.Scanner;

/*
Dada duas Strings A e B, faça um programa que imprima “Sim” se A e B são anagramas e “Nao”, caso contrário.
Um anagrama é a transposição de letras de palavra ou frase para formar outra palavra ou frase diferente.
Por exemplo, as palavras “roma” e “amor” são anagramas. Considere como entrada apenas palavras com letras minúsculas.
 */
public class Ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordA = scanner.nextLine();
        String wordB = scanner.nextLine();
        scanner.close();
        final Ex04 ex04 = new Ex04();
        System.out.println(ex04.compute(wordA, wordB));

    }

    String compute(String wordA, String wordB) {
        //boolean anagrama = true;
        if (wordA.length() != wordB.length())
            return "Nao";
        for (int i = 0; i < wordA.length(); i++) {
            int c1 = 0;
            for (int j = 0; j < wordA.length(); j++) {
                if (wordA.charAt(j) == wordA.charAt(i))
                    c1 += 1;
            }

            int c2 = 0;

            for (int k = 0; k < wordB.length(); k++) {
                if (wordB.charAt(k) == wordA.charAt(i))
                    c2 += 1;
            }

            
            if(c1 != c2)return "Nao";
        }

        return "Sim";

    }
}

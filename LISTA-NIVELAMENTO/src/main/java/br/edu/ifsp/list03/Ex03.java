package br.edu.ifsp.list03;

import java.util.Scanner;

/*
Dada uma String arbitrária, faça um programa que imprima “Sim” se essa for palíndromo e “Nao”, caso contrário.
Palíndromo é uma frase ou palavra que pode ser lida, indiferentemente, da esquerda para a direita ou vice-versa.
Por exemplo, “arara” é um palíndromo. Considere como entrada apenas palavras com letras minúsculas.
 */
public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        final Ex03 ex03 = new Ex03();
        System.out.println(ex03.compute(input));
    }

    String compute(String input) {
 
        // if(input==null) return "Sim";
        // String invertido = new StringBuilder(input).reverse().toString();
        // return input.equals(invertido) ? "Sim" : "Nao";

        if(input==null) return "Sim";
        int inicio =0;
        int fim = input.length()-1;
        while(inicio < fim ){
            if(input.charAt(inicio) != input.charAt(fim) ){
                return "Nao";
            }else{
                inicio++;
                fim--;
            }
        };

        
        return "Sim";

    }
        
        
    
    
}

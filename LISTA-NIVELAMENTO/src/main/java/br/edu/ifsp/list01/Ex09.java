package br.edu.ifsp.list01;

import java.util.Locale;
import java.util.Scanner;

/*
    Faça um programa que leia um conjunto de valores que correspondem as idades de pessoas de uma comunidade. Quando
    o valor fornecido for um número negativo, significa que não existem mais idades para serem lidas. Após a leitura,
    o programa deve informar:

    A média das idades das pessoas (com duas casas decimais)
    A quantidade de pessoas maiores de idade
    A porcentagem de pessoas idosas (considere quem uma pessoa idosa tem mais de 75 anos) (com duas casas decimais)

    Exemplos de entrada e saída:
    | Entrada             | Saída          |
    | -------             | ------         |
    | 10 20 30 80 -1      | 35.00 3 25.00% |
    | 25 30 45 -1         | 33.33 3 0.00%  |
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi (IFSP/SCL) e Adenilso Simão (ICMC/USP)
*/
public class Ex09 {

    public static void main(String[] args) {
        // Leia o input
        // Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        // Escreva o resultado da chamada do método compute() aqui

        final Scanner scanner = new Scanner(System.in);
        // int tamanho = scanner.nextInt(); ???
        final int[] input = new int[1000];// tamanho fixo
        int i = 0;
        while (true) {
            int idade = scanner.nextInt();
            
            if (idade <0){
               input[i] = -1;


                break;}
            input[i] = idade;

            i++;

           
        }
        final Ex09 ex09 = new Ex09();
        System.out.println(ex09.compute(input));
        scanner.close();
    }

    String compute(int[] input) {
        // criar variaveis
        int somaIdades = 0;
        double mediaDasIdades = 0.0;
        int maioresDeIdade = 0;
        int qtdIdosos = 0;
        double porcentagemIdosos = 0.0;
        int contador = 0;

        // percorrer o array
        int i = 0;
        while (true) {

            if(input[i] < 0) break;

            somaIdades += input[i];
            if (input[i] >= 18) {
                maioresDeIdade++;
            }
            if (input[i] > 75) {
                qtdIdosos++;

            }



            contador++;
            i++;
        }
        
        if (contador == 0) return "0.00 0 0.00%";

        mediaDasIdades =(double) somaIdades / contador;

        porcentagemIdosos = ((double) qtdIdosos / contador) * 100;

         return String.format("%.2f %d %.2f%%", mediaDasIdades, maioresDeIdade,
         porcentagemIdosos );
    

    }
}

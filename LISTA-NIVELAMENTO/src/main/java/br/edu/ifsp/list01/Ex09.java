package br.edu.ifsp.list01;

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
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui

    final Scanner scanner = new Scanner(System.in);
    final int[] input = scanner.nextInt();

    final Ex09 ex09 = new Ex09();
    System.out.println(ex09.compute(int[] input));
    scanner.close();

    }

    String compute(int[] input) {
       //criar variaveis 
    int somaIdades = 0;
    double mediaDasIdades=0.0;
    int maioresDeIdade=0;
    int qtdIdosos=0;
    double porcentagemIdosos= 0.0;
    int contador= 0;

    //percorrer o array 
    int i =0;
    while(input[i] != -1 ){

        
        somaIdades += input[i];
        if(input[i] >= 18 ){maioresDeIdade++;}
        if(input[i]>= 75){
            qtdIdosos++;

        }

        contador++;    
        i++;
    }

    mediaDasIdades= somaIdades/ contador;

    porcentagemIdosos = qtdIdosos/ contador;


    // retornar os 3 valores 
    return mediaDasIdades, maioresDeIdade, porcentagemIdosos;



    }
}

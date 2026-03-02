package br.edu.ifsp.list02;

import java.util.Scanner;

/*
    Todos os Natais o Papai Noel se prepara para embarcar em seu trenó todos os N presentes a serem entregues.
    A área em que os presentes ficam no trenó pode ser dividida em dois lados: o lado A e o lado B. Para que o trenó
    fique equilibrado, a diferença da soma dos pesos dos presentes que estão no lado A e no lado B não pode ser maior
    que 5kg.

    Você recebeu a tarefa de ajudar o Papai Noel este ano. Dados N presentes, você deve descobrir se existe uma
    maneira de dividi-los nos lados A e B, de tal forma que o trenó nunca fique desequilibrado.

    Faça um programa que leia o número de presentes N que o Papai Noel deve entregar. Após isso, leia N números
    inteiros P, representando o peso de cada presente. Os presentes devem ser alocados um por vez, na ordem em que
    são lidos, e em nenhum momento o trenó deve ficar desequilibrado. Seu programa deve imprimir "S" se for possível
    equilibrar todos os presentes no trenó e "N" caso contrário.

    Exemplos de entrada e saída:

    | Entrada      | Saída  |
    | -------      | ------ |
    | 3            | S      |
    | 4 6 2        | S      |
    | -------      | ------ |
    | 2            | N      |
    | 6 6          |        |


    Fonte: Adaptado de https://neps.academy/problem/436
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi e Adenilso Simão (ICMC/USP)
 */
public class Ex08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] giftsWeights = new int[N];

        for (int i = 0; i < N; i++) {
            giftsWeights[i] = scanner.nextInt();

        }

        scanner.close();

        final Ex08 ex08 = new Ex08();//
        System.out.println(ex08.compute(giftsWeights));

    }

    String compute(int[] giftsWeights) {
        int le = 0;
        int ld = 0;
       for (int i = 0; i < giftsWeights.length; i++) {
            int pesoAtual = giftsWeights[i];
            if (calculaDiferenca(le + pesoAtual, ld) <= 5) {
                le += pesoAtual;
            } 
            else if (calculaDiferenca(le, ld + pesoAtual) <= 5) {
                ld += pesoAtual;
            } 
            else {
                return "N";//alguem vai fica sem presente 
            }
        }
        return "S";
    }

    public static int calculaDiferenca(int x, int y) {
        int d = x - y;
        return (d<0) ?-d:d;

    }
}

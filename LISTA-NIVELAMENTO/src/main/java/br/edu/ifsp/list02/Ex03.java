package br.edu.ifsp.list02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/*
    Leia um conjunto de cinco números inteiros não repetidos em uma única linha e os armazene em um vetor de 10 posições.
    A partir daí, leia um número por vez. Se o número ainda não estiver no conjunto, faça a inclusão após o último número.
    Caso ele esteja no conjunto, remova o número e libere espaço no array. A cada iteração imprima o vetor. O programa
    acaba quando o array ficar totalmente cheio ou vazio. Veja o exemplo na imagem anexa.

    Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".
 */
public class Ex03 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] firstFive = new int[5];
        
        try {
            for(int i = 0; i < 5; i++) {
                if (scanner.hasNextInt()) {
                    firstFive[i] = scanner.nextInt();
                } else {
                    System.out.println("Erro");
                    return;
                }
            }
            
            List<Integer> otherIntsList = new ArrayList<>();
            while(scanner.hasNextInt()){
                otherIntsList.add(scanner.nextInt());
            }
            
            int[] otherInts = new int[otherIntsList.size()];
            for(int i=0; i<otherIntsList.size(); i++) otherInts[i] = otherIntsList.get(i);
            
            final Ex03 ex03 = new Ex03();
            System.out.println(ex03.compute(firstFive, otherInts));
        } catch (Exception e) {
            System.out.println("Erro");
        } finally {
            scanner.close();
        }
    }

    String compute(int[] firstFive, int[] otherInts) {
        int[] vetor = new int[10];
        int count = 0;
        
        for (int val : firstFive) {
            vetor[count++] = val;
        }

        StringBuilder output = new StringBuilder();
        
        for (int val : otherInts) {
            int foundIndex = -1;
            for (int i = 0; i < count; i++) {
                if (vetor[i] == val) {
                    foundIndex = i;
                    break;
                }
            }

            if (foundIndex != -1) {
                for (int k = foundIndex; k < count - 1; k++) {
                    vetor[k] = vetor[k + 1];
                }
                count--;
            } else {
                if (count < 10) {
                    vetor[count++] = val;
                }
            }

            if (output.length() > 0) output.append("\n");
            output.append(formatArray(vetor, count));

            if (count == 0 || count == 10) {
                break;
            }
        }
        
        return output.toString();
    }

    private String formatArray(int[] v, int n) {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < n; i++) {
            sj.add(String.valueOf(v[i]));
        }
        return sj.toString();
    }
}

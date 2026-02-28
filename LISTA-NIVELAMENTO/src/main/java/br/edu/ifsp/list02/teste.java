package br.edu.ifsp.list02;
import java.util.Arrays;
public class teste {

    public static void main(String[] args) {

        int[] firstFive = { 1, 2, 3, 4, 5 };
        int[] otherInts = { 1, 20, 30 };
        int[] novoArray = new int[firstFive.length - 1];

        for (int i = 0; i <= firstFive.length; i++) {
            if (existeNoArray(otherInts, firstFive[i])) {
                continue;

            } else {
                novoArray[i] = firstFive[i];

            }
            Arrays.stream(novoArray).forEach(n -> System.out.print(n + " "));
        }

    }

    public static boolean existeNoArray(int[] array, int valorProcurado) {
        for (int num : array) {
            if (num == valorProcurado)
                return true;
        }
        return false;
    }

}

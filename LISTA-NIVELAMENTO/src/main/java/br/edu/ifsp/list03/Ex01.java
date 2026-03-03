package br.edu.ifsp.list03;

import java.util.Scanner;

/*
Implemente um programa que gere senhas provisórias a partir do nome do usuário, seguindo o mesmo
padrão dos exemplos a seguir:

EXEMPLO 1 Entrada: Java | Saída: J*Ja*Jav*Jav*Ja* J
EXEMPLO 2 Entrada: POOS3 | Saída: P*PO*POO*POOS*POOS*POO*PO*P
EXEMPLO 3 Entrada: KO | Saída: K*K
EXEMPLO 4 Entrada: O | Saída: Invalido
EXEMPLO 5 Entrada: | Saída: Invalido
*/
public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        final Ex01 ex01 = new Ex01();
        System.out.println(ex01.compute(input));
    
    }
    

    String compute(String palavra) {
        String senha = "";
        if(palavra == null) return "Invalido";
        if(palavra == "" || palavra.length() == 1 ) return "Invalido";
        for (int i = 0; i < palavra.length(); i++) {
            senha += palavra.substring(0, i) + "*";
        }

        for (int i = palavra.length() - 1; i >= 0; i--) {
            senha += palavra.substring(0, i) + "*";
        }

        if (senha.startsWith("*")) {
            senha = senha.substring(1, senha.length());

        }

        if (senha.endsWith("**")) {
            senha = senha.substring(0, senha.length() - 2);
        }

    
        return senha;

    }
}

O Desafio: Calculadora de Média "BES"
Crie um arquivo chamado CalculadoraMedia.java no seu IntelliJ e tente replicar o código abaixo.

O Código
Java

import java.util.Scanner; // Import necessário para ler o teclado

public class CalculadoraMedia {
public static void main(String[] args) {
// 1. Criar o objeto Scanner para ler a entrada
Scanner leitor = new Scanner(System.in);

        // 2. Declaração de variáveis (Tipos: String para texto, double para números decimais)
        String nomeAluno;
        double nota1, nota2, media;

        // 3. Entrada de Dados
        System.out.print("Digite o nome do aluno: ");
        nomeAluno = leitor.nextLine(); // Lê uma linha de texto

        System.out.print("Digite a primeira nota: ");
        nota1 = leitor.nextDouble(); // Lê um número decimal

        System.out.print("Digite a segunda nota: ");
        nota2 = leitor.nextDouble();

        // 4. Processamento (Cálculo da média)
        media = (nota1 + nota2) / 2;

        // 5. Saída de Dados (Usando concatenação com +)
        System.out.println("\n--- Resultado Final ---");
        System.out.println("Aluno: " + nomeAluno);
        System.out.println("Média Final: " + media);

        // 6. Lógica Simples (Estrutura condicional)
        if (media >= 6.0) {
            System.out.println("Status: Aprovado! Parabéns.");
        } else {
            System.out.println("Status: Reprovado. Precisa estudar mais!");
        }

        // Fechar o leitor (boa prática)
        leitor.close();
    }
}
O que você vai praticar aqui:
import java.util.Scanner;: Você aprende que o Java precisa "trazer" ferramentas externas para funções específicas.

String vs double: Diferença entre texto e números com vírgula.

System.out.print vs println: O primeiro escreve e mantém o cursor na mesma linha; o segundo pula para a próxima.

leitor.nextDouble(): Captura o que você digita no terminal.

if / else: A base da lógica de programação.

Dicas para rodar no seu setup:
No IntelliJ: Clique no botão verde (Play) ao lado da linha public class CalculadoraMedia.

No Terminal (Kitty): Se quiser rodar "na mão" para sentir o poder do Arch:

Bash

javac CalculadoraMedia.java
java CalculadoraMedia
Sugestão de "Upgrade" para o exercício:
Quando conseguir rodar esse, tente modificar o código para:

Pedir 3 notas em vez de 2.

Calcular uma Média Ponderada (ex: Nota 1 vale peso 4 e Nota 2 vale peso 6).

Verificar se o aluno tirou nota 10 e imprimir uma mensagem especial: "Nota máxima! Você é um gênio!".

Conseguiu rodar e ver o resultado no console do IntelliJ? Se der erro de "Scanner", lembre-se de conferir se o import está lá no topo!
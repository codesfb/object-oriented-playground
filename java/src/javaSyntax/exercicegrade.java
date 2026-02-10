import java.util.Scanner;
public class exercicegrade {
    static void main() {
    String nomeAluno;
    double nota1, nota2, media ;
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nome do aluno:");
    nomeAluno = scanner.nextLine();

    System.out.print("nota 1:");
    nota1 = scanner.nextDouble();System.out.println("nota 2:");
    nota2 = scanner.nextDouble();

    media = (nota1 + nota2) / 2;
        System.out.println("a media é " + media);

        if (media > 6) {
            System.out.println("O aluno passou");
        }else if(media < 6){
            System.out.println("aluno reprovado");

        }
    scanner.close();


    }

}

package main.java.ListaNivelamento.src.main.java.br.edu.ifsp.list02;

import java.util.Scanner;

/*
    Um robô possui um sensor de infravermelho para navegação e mapeamento que emite 181 feixes com um intervalo de um
    grau entre cada um deles (-90° na extrema-esquerda (feixe 0), 0° no centro (feixe 90) e 90° na extrema direita
    (feixe 180)). O sensor está perfeitamente alinhado ao robô, sendo que o feixe 90 aponta para a frente. Cada feixe
    possui alcance máximo de oito metros e uma medida inferior a isso indica que há um obstáculo mais próximo no ambiente.
    Considerando-se que o robô possui um GPS sem erro, é possível obter sua posição exata (x1, y1) em um plano cartesiano.
    Utilize coordenadas polares para calcular a posição de um ponto de colisão no ambiente a partir das coordenadas "x1" e
    "y1" da posição do robô, do ângulo "a" de orientação do robô no plano (em graus), de um número "f" indicando feixe
    escolhido e da distância "d" medida pelo feixe d >=0). Por questão de simplificação, utilize valores inteiros para as
    coordenadas do robô e do obstáculo (saída esperada), bem como para o ângulo do robô e a distância medida pelo feixe.
    O valor da saída esperada deverá ser arredondado para inteiro, não truncado. Dica: os métodos Math.sin(a) e Math.con(a)
    utilizam valores em radianos e não graus.

    Os números devem lidos na mesma linha, sendo os formatos de entrada e saída descritos a seguir:

    Modelo de entrada: x1 y1 a f d | Modelo de saída: (x2, y2)

     Exemplos de entrada e saída:

    | Entrada                | Saída    |
    | -------                | ------   |
    | 0 0 45 45 5            | (0,5)    |
    | 10 10 45 45 10         | (10,20)  |
    | -4 4 45 135 4          | (0,4)    |
    | 0 0 0 135 4            | (3,-3)   |

    Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".
 */
public class Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a = scanner.nextInt();
        int f = scanner.nextInt();
        int d = scanner.nextInt();

        scanner.close();
        final Ex10 ex10 = new Ex10();
        System.out.println(ex10.compute(x, y, a, f, d));
    }

    String compute(int x, int y, int a, int f, int d) {
        if(d < 0) return "Erro";//distancia n pode ser negativa eu acho 
        int anguloGraus = a - (f - 90);
        double anguloRadianos = anguloGraus * Math.PI / 180.0;

        double deslocamentoX = d * Math.cos(anguloRadianos);
        double deslocamentoY = d * Math.sin(anguloRadianos);
        int xObstaculo = (int) Math.round(x + deslocamentoX);
        int yObstaculo = (int) Math.round(y + deslocamentoY);
        return String.format("(%d,%d)", xObstaculo, yObstaculo);
    }
}


//package main.java.Figure;

public class MainFigure {
    static void main() {
        Circle circle = new Circle(0, 0, 1.0);
        System.out.println(circle.area()); // 3.141592653589793
        Rectangle rectangle = new Rectangle(0, 0, 1.0, 5);
        System.out.println(rectangle.area());

        //TODO não entendi bem o que essa Figure é uma posição um endereço da forma ? >> Figure é a definição abstrata do que é uma figura geométrica, que está no plano x,y e tem uma área (que só é possível calcular em Figuras concretas, como Circle)
        Triangle triangle = new Triangle(0, 0,2, 3, 4 );
        //TODO coloca toString() nas figuras, para que você possa imprimir as características, mais a área. Fica melhor de visualizar.
        //TODO o resto está ok.
        System.out.println(triangle.area());
    }
}

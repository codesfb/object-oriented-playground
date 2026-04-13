
//package main.java.Figure;

public class MainFigure {
    static void main() {
        Circle circle = new Circle(0, 0, 1.0);
        System.out.println(circle.area()); // 3.141592653589793
        Rectangle rectangle = new Rectangle(0, 0, 1.0, 5);
        System.out.println(rectangle.area());

        //TODO não entendi bem o que essa Figure é uma posição um endereço da forma ?
        Triangle triangle = new Triangle(0, 0,2, 3, 4 );
        System.out.println(triangle.area());
    }
}

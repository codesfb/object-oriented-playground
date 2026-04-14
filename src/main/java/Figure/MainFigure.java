
//package main.java.Figure;

public class MainFigure {
    static void main() {
        Circle circle = new Circle(1, 2, 1.0);
        System.out.println(circle.area()); // 3.141592653589793
        Rectangle rectangle = new Rectangle(1, 2, 1.0, 5);
        System.out.println(rectangle.area());
        Triangle triangle = new Triangle(0, 0,2, 3, 4 );
        System.out.println(triangle.area());


        Figure[] figuras = new Figure[150];

        for (int i = 0; i < 150; i++) {

        }


    }
}

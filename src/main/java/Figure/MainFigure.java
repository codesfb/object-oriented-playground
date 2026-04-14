
//package main.java.Figure;

import java.util.Arrays;

public class MainFigure {
    static void main() {
        Circle circle = new Circle(1, 2, 1.0);
        System.out.println(circle.area()); // 3.141592653589793
        Rectangle rectangle = new Rectangle(1, 2, 1.0, 5);
        System.out.println(rectangle.area());
        Triangle triangle = new Triangle(0, 0,2, 3, 4 );
        System.out.println(triangle.area());


        Figure[] figuras = new Figure[150];

        for (int i = 0; i < 50; i++) {
            double valor = i + 1;
            figuras[i] = new Circle(i+1, i+1, valor);
            figuras[i + 50] = new Rectangle(i+1, i+1, valor, valor);
            figuras[i + 100] = new Triangle(i+1, i+1, valor, valor, valor);

        }
        double allAreas=0.0;
        for(Figure figure : figuras){
            allAreas+=figure.area();
                System.out.println(figure );
        }
        System.out.printf("Soma de todas as areas %.2f", allAreas);



    }
}

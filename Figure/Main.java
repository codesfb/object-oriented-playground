public class Main {
    static void main() {
        Circle circle = new Circle(2.3, 3.2, 1.0);
        System.out.println(circle.area()); // 3.141592653589793
        Rectangle  rectangle = new Rectangle(2.3, 3.2, 1.0, 5);
        System.out.println(rectangle.area());
    }
}

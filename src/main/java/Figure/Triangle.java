
//package main.java.Figure;

public class Triangle extends Figure{
    private double a;
    private double b;
    private double c;

    public Triangle(double y, double x, double a, double b, double c) {
        super(y, x);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double s = (a + b + c) / 2;  // semiperímetro
        return  Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}

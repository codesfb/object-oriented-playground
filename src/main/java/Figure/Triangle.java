
//package main.java.Figure;

import java.util.Objects;

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
    public String toString() {
        return String.format("Posição: (%.2f, %.2f), A: %.2f, B: %.2f, C:%.2f Área: %.2f",
                getX(), getY(), a, b, c, area());
    }

    @Override
    public double area() {
        double s = (a + b + c) / 2;  // semiperímetro
        return  Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(a, triangle.a) == 0 &&
                Double.compare(b, triangle.b) == 0 &&
                Double.compare(c, triangle.c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), a, b, c);
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

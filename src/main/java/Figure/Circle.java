
//package main.java.Figure;

import java.util.Objects;

public class Circle extends Figure{
    private double radius;

    public Circle(double y, double x, double radius) {
        super(y, x);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return String.format("Posição: (%.2f, %.2f), radius:%.2f, area :%.2f",super.getY(), super.getX(), radius, area());

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }

    public double getRadius() {
        return radius;
    }
}

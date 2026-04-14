//package main.java.Figure;

import java.util.Objects;

public class Rectangle extends Figure{
    private double width;
    private double length;

    public Rectangle(double y, double x, double width, double length) {
        super(y, x);
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return width * length;
    }

    @Override
    public String toString() {
        return String.format("Posição: (%.2f, %.2f), Largura: %.2f, Comprimento: %.2f, Área: %.2f",
                getX(), getY(), width, length, area());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) == 0 &&
                Double.compare(length, rectangle.length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, length);
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
}

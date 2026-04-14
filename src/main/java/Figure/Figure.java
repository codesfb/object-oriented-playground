import java.util.Objects;

//package main.java.Figure;
public abstract class Figure {
    private double y;
    private double x;

    public Figure(double y, double x) {
        this.y = y;
        this.x = x;
    }


    public abstract double area();

    @Override
    public String toString() {
        return String.format("%.2f, %.2f", x, y);

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Double.compare(y, figure.y) == 0 && Double.compare(x, figure.x) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}


//package main.java.Figure;
public abstract class Figure {
    private double y;
    private double x;

    public Figure(double y, double x) {
        this.y = y;
        this.x = x;
    }


    public abstract double area();

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}

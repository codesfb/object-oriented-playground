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
}

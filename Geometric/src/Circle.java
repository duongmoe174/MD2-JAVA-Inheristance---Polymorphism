public class Circle extends Geometric{
    private double radius;

    public Circle() {
    }

    public Circle(String color, String filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        double result = radius * radius * Math.PI;
        return result;
    }

    public double getPerimeter() {
        double result = 2 * radius * Math.PI;
        return result;
    }

    public double getDiameter () {
        double result = 2 * radius;
        return result;
    }

    public void printCircle () {
        System.out.println("The " + getColor() + " circle is created with the radius is " + radius);
    }
}

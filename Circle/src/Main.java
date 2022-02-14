public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2, "weight");
        Cylinder cylinder = new Cylinder(3, "red", 2);
        System.out.println(cylinder.V());
    }
}

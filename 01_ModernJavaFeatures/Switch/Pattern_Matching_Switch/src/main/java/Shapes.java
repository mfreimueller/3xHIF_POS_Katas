public class Shapes {

    sealed interface Shape permits Circle, Rectangle, Triangle {}

    record Circle(double radius) implements Shape {}
    record Rectangle(double width, double height) implements Shape {}
    record Triangle(double base, double height) implements Shape {}

    public static double area(Shape shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.radius() * circle.radius();
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.width() * rectangle.height();
        } else if (shape instanceof Triangle) {
            Triangle triangle = (Triangle) shape;
            return 0.5 * triangle.base() * triangle.height();
        } else {
            throw new IllegalArgumentException("Unknown shape: " + shape);
        }
    }

    public static String describe(Shape shape) {
        String kind;
        if (shape instanceof Circle) {
            kind = "circle";
        } else if (shape instanceof Rectangle) {
            kind = "rectangle";
        } else if (shape instanceof Triangle) {
            kind = "triangle";
        } else {
            kind = "unknown";
        }
        return kind + " with area " + area(shape);
    }

    public static void main(String[] args) {
        Shape[] shapes = { new Circle(2.0), new Rectangle(3.0, 4.0), new Triangle(5.0, 6.0) };
        for (Shape shape : shapes) {
            System.out.println(describe(shape));
        }
    }
}

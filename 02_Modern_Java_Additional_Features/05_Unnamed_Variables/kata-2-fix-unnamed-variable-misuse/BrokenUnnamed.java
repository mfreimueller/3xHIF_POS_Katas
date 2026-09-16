import java.util.List;

public class BrokenUnnamed {

    record Point(int x, int y) {}

    // Does not compile: `_` is a placeholder, not a real variable name — it
    // cannot be read back afterwards.
    static int sumIgnoringY(List<Point> points) {
        int sum = 0;
        for (Point point : points) {
            if (point instanceof Point(int x, int _)) {
                sum += x;
                sum += _;
            }
        }
        return sum;
    }

    // Does not compile: two unrelated `_` declarations in the very same
    // scope are fine on their own, but this method also tries to use one
    // of them afterwards, which is illegal for the same reason as above.
    static void reportShape(Object shape) {
        if (shape instanceof Point(int _, int _)) {
            System.out.println("Got a point");
        } else if (shape instanceof String _) {
            System.out.println("Got: " + _);
        }
    }

    public static void main(String[] args) {
        List<Point> points = List.of(new Point(1, 10), new Point(2, 20), new Point(3, 30));
        System.out.println("Sum of x: " + sumIgnoringY(points));
        reportShape(new Point(5, 5));
        reportShape("a label");
    }
}

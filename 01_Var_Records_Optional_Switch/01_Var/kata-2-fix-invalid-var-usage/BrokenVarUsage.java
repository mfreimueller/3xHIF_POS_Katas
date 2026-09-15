import java.util.List;

public class BrokenVarUsage {

    // var is not allowed for fields
    private var name = "Default";

    public static void main(String[] args) {
        // var must be initialized at declaration
        var count;
        count = 10;

        // var cannot infer a type from null
        var description = null;

        var numbers = List.of(1, 2, 3);
        for (var i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        printLabel("Report");
        var label = createLabel("Summary");
        System.out.println(label);
        System.out.println("Count: " + count);
        System.out.println("Description: " + description);
    }

    // var is not allowed as a method parameter type
    private static void printLabel(var text) {
        System.out.println("Label: " + text);
    }

    // var is not allowed as a method return type
    private static var createLabel(String base) {
        return base + "-label";
    }
}

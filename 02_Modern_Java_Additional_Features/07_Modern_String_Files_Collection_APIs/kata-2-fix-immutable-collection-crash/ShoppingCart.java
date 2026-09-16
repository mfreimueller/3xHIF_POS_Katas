import java.util.List;
import java.util.Map;

public class ShoppingCart {

    // Compiles fine, but crashes at runtime: List.of(...) returns an
    // immutable list, and addItem tries to add() to it.
    static List<String> items = List.of("Bread", "Milk");

    static void addItem(String item) {
        items.add(item);
    }

    static Map<String, Double> prices = Map.of("Bread", 2.5, "Milk", 1.2);

    public static void main(String[] args) {
        addItem("Eggs");
        for (String item : items) {
            double price = prices.getOrDefault(item, 0.0);
            System.out.println(item + ": EUR " + price);
        }
    }
}

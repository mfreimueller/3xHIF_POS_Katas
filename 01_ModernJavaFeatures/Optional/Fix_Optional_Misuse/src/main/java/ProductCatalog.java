import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductCatalog {

    // Misuse: Optional should not be used as a field type
    private Optional<String> catalogOwner;

    private final Map<String, Double> pricesByProductId = new HashMap<>();

    public ProductCatalog(String catalogOwner) {
        this.catalogOwner = Optional.ofNullable(catalogOwner);
        pricesByProductId.put("P100", 19.99);
        pricesByProductId.put("P200", 49.50);
    }

    // Misuse: Optional should not be used as a method parameter type
    public void applyDiscount(String productId, Optional<Double> discountPercentage) {
        if (discountPercentage.isPresent()) {
            double currentPrice = pricesByProductId.get(productId);
            double discounted = currentPrice - (currentPrice * discountPercentage.get() / 100);
            pricesByProductId.put(productId, discounted);
        }
    }

    public Optional<Double> findPrice(String productId) {
        return Optional.ofNullable(pricesByProductId.get(productId));
    }

    public String describePrice(String productId) {
        Optional<Double> price = findPrice(productId);
        // Misuse: isPresent() + get() instead of the proper Optional API
        if (price.isPresent()) {
            return "Price: " + price.get();
        } else {
            return "Price not available";
        }
    }

    public String getCatalogOwner() {
        // Misuse: calling get() without checking presence first
        return catalogOwner.get();
    }
}

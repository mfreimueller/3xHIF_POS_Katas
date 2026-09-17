import java.util.Optional;

public class ProductCatalogDemo {

    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog("Spenger Supplies");

        System.out.println("Owner: " + catalog.getCatalogOwner());
        System.out.println(catalog.describePrice("P100"));
        System.out.println(catalog.describePrice("P999"));

        catalog.applyDiscount("P100", Optional.of(10.0));
        System.out.println(catalog.describePrice("P100"));
    }
}

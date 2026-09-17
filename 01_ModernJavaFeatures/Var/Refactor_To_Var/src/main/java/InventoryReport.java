import java.util.ArrayList;
import java.util.List;

public class InventoryReport {

    public static void main(String[] args) {
        String warehouseName = "North Distribution Center";
        List<String> items = new ArrayList<>();
        items.add("Wrench");
        items.add("Hammer");
        items.add("Screwdriver");

        int itemCount = items.size();
        long totalUnitsInStock = 0L;
        double averagePricePerUnit = 12.5;

        for (int i = 0; i < items.size(); i++) {
            String itemName = items.get(i);
            int unitsForItem = countUnits(itemName);
            totalUnitsInStock += unitsForItem;
        }

        byte reorderThreshold = 5;

        double totalValue = totalUnitsInStock * averagePricePerUnit;

        String report = buildReport(warehouseName, itemCount, totalUnitsInStock, totalValue, reorderThreshold);
        System.out.println(report);
    }

    private static int countUnits(String itemName) {
        return itemName.length() * 3;
    }

    private static String buildReport(String warehouseName, int itemCount, long totalUnits, double totalValue, byte reorderThreshold) {
        StringBuilder builder = new StringBuilder();
        builder.append("Warehouse: ").append(warehouseName).append("\n");
        builder.append("Items: ").append(itemCount).append("\n");
        builder.append("Total units: ").append(totalUnits).append("\n");
        builder.append("Total value: ").append(totalValue).append("\n");
        builder.append("Reorder threshold: ").append(reorderThreshold).append("\n");
        return builder.toString();
    }
}

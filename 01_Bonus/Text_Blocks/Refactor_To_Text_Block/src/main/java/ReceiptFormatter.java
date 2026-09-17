public class ReceiptFormatter {

    static String buildReceipt(String customer, String itemLines, double total) {
        String receipt = "Receipt for: " + customer + "\n" +
                "------------------------\n" +
                itemLines +
                "------------------------\n" +
                "Total: EUR " + String.format("%.2f", total) + "\n";
        return receipt;
    }

    public static void main(String[] args) {
        String itemLines = "1x Coffee    EUR 3.50\n2x Bagel     EUR 5.00\n";
        System.out.print(buildReceipt("Alice", itemLines, 8.50));
    }
}

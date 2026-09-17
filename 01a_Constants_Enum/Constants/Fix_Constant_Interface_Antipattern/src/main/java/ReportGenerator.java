public class ReportGenerator {

    interface ReportDefaults {
        int MAX_ROWS = 500;
        String DEFAULT_TITLE = "Untitled Report";
    }

    static class SalesReport implements ReportDefaults {
        private final String title;
        private final int rowCount;

        SalesReport(String title, int rowCount) {
            this.title = title.isBlank() ? DEFAULT_TITLE : title;
            this.rowCount = Math.min(rowCount, MAX_ROWS);
        }

        void print() {
            System.out.println(title + ": " + rowCount + " rows");
        }
    }

    static class InvoiceReport implements ReportDefaults {
        private final String title;
        private final int rowCount;

        InvoiceReport(String title, int rowCount) {
            this.title = title.isBlank() ? DEFAULT_TITLE : title;
            this.rowCount = Math.min(rowCount, MAX_ROWS);
        }

        void print() {
            System.out.println(title + ": " + rowCount + " rows");
        }
    }

    public static void main(String[] args) {
        new SalesReport("", 900).print();
        new SalesReport("Sales Q3", 120).print();
        new InvoiceReport("Invoices September", 42).print();
    }
}

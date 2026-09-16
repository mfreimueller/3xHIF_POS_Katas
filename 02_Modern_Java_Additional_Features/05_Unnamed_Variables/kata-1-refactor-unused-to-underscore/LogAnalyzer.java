import java.util.List;

public class LogAnalyzer {

    record LogEntry(String level, String message, int lineNumber) {}

    static int countEntries(List<LogEntry> entries) {
        int count = 0;
        for (LogEntry entry : entries) {
            count++;
        }
        return count;
    }

    static int countErrorEntries(List<Object> events) {
        int errors = 0;
        for (Object event : events) {
            if (event instanceof LogEntry(String level, String message, int lineNumber)) {
                if (level.equals("ERROR")) {
                    errors++;
                }
            }
        }
        return errors;
    }

    static String safeParse(String input) {
        try {
            return String.valueOf(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            return "invalid";
        }
    }

    public static void main(String[] args) {
        List<LogEntry> entries = List.of(
                new LogEntry("INFO", "Started", 1),
                new LogEntry("ERROR", "Disk full", 2),
                new LogEntry("ERROR", "Timeout", 3)
        );
        List<Object> events = List.of(
                new LogEntry("INFO", "Started", 1),
                new LogEntry("ERROR", "Disk full", 2),
                new LogEntry("ERROR", "Timeout", 3),
                "not a log entry"
        );

        System.out.println("Total entries: " + countEntries(entries));
        System.out.println("Error entries: " + countErrorEntries(events));
        System.out.println(safeParse("abc"));
        System.out.println(safeParse("42"));
    }
}

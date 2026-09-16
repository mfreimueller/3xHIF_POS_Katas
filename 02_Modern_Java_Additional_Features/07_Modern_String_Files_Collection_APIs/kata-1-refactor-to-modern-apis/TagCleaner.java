import java.util.ArrayList;
import java.util.List;

public class TagCleaner {

    static List<String> cleanTags(List<String> rawTags) {
        List<String> result = new ArrayList<>();
        for (String tag : rawTags) {
            String trimmed = tag.trim();
            if (trimmed.length() == 0) {
                continue;
            }
            result.add(trimmed.toUpperCase());
        }
        return result;
    }

    static boolean isBlankLine(String line) {
        return line.trim().length() == 0;
    }

    static String separatorLine(int width) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    static long countNonBlankLines(String text) {
        String[] lines = text.split("\n");
        long count = 0;
        for (String line : lines) {
            if (!isBlankLine(line)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> rawTags = new ArrayList<>();
        rawTags.add("  java  ");
        rawTags.add("");
        rawTags.add("  ");
        rawTags.add("spring");

        List<String> tags = cleanTags(rawTags);
        System.out.println(tags);
        System.out.println(separatorLine(10));

        String report = "Line one\n\nLine two\n   \nLine three";
        System.out.println("Non-blank lines: " + countNonBlankLines(report));
    }
}

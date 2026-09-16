import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ValidatedList<T> extends ArrayList<T> {

    public ValidatedList(Collection<? extends T> source) {
        super(requireNonEmpty(source));
    }

    private static <T> Collection<? extends T> requireNonEmpty(Collection<? extends T> source) {
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException("source must not be null or empty");
        }
        return source;
    }

    public static void main(String[] args) {
        ValidatedList<String> list = new ValidatedList<>(List.of("a", "b", "c"));
        System.out.println("Size: " + list.size());

        try {
            new ValidatedList<String>(List.of());
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}

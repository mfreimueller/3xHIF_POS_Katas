import java.util.HashMap;
import java.util.Map;

public class UserDirectory {

    private final Map<String, String> emailsByUsername = new HashMap<>();

    public UserDirectory() {
        emailsByUsername.put("ajohnson", "alice.johnson@example.com");
        emailsByUsername.put("bsmith", "bob.smith@example.com");
    }

    public String findEmailByUsername(String username) {
        return emailsByUsername.get(username);
    }
}

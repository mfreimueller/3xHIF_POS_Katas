public class UserDirectoryDemo {

    public static void main(String[] args) {
        UserDirectory directory = new UserDirectory();

        String email = directory.findEmailByUsername("ajohnson");
        if (email != null) {
            System.out.println("Found: " + email.toUpperCase());
        } else {
            System.out.println("No email found");
        }

        String missingEmail = directory.findEmailByUsername("unknown");
        String displayEmail;
        if (missingEmail != null) {
            displayEmail = missingEmail;
        } else {
            displayEmail = "no-reply@example.com";
        }
        System.out.println("Display email: " + displayEmail);

        String requiredEmail = directory.findEmailByUsername("bsmith");
        if (requiredEmail == null) {
            throw new IllegalStateException("Email is required for bsmith");
        }
        System.out.println("Required email: " + requiredEmail);
    }
}

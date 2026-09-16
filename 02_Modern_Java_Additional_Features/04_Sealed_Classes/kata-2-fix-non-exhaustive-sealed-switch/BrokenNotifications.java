public class BrokenNotifications {

    sealed interface Notification permits EmailNotification, SmsNotification, PushNotification {}

    record EmailNotification(String address, String subject) implements Notification {}

    record SmsNotification(String phoneNumber, String text) implements Notification {}

    // Does not compile: PushNotification is listed in `permits` above, but it
    // is missing the required "final"/"sealed"/"non-sealed" modifier.
    static class PushNotification implements Notification {
        String deviceToken;
        String text;

        PushNotification(String deviceToken, String text) {
            this.deviceToken = deviceToken;
            this.text = text;
        }
    }

    // Does not compile: the switch below does not cover PushNotification,
    // and Notification is sealed, so the compiler refuses to guess.
    static String render(Notification notification) {
        return switch (notification) {
            case EmailNotification email -> "Email to " + email.address() + ": " + email.subject();
            case SmsNotification sms -> "SMS to " + sms.phoneNumber() + ": " + sms.text();
        };
    }

    public static void main(String[] args) {
        Notification[] notifications = {
                new EmailNotification("user@example.com", "Welcome"),
                new SmsNotification("+43123456789", "Your code is 1234"),
                new PushNotification("device-abc", "New message")
        };
        for (Notification notification : notifications) {
            System.out.println(render(notification));
        }
    }
}

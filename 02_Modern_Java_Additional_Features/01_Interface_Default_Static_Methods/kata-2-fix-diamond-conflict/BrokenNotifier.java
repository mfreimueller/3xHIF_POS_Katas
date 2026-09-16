public class BrokenNotifier {

    interface EmailChannel {
        default void notify(String message) {
            System.out.println("[Email] " + message);
        }
    }

    interface SmsChannel {
        default void notify(String message) {
            System.out.println("[SMS] " + message);
        }
    }

    // Does not compile: DualChannel inherits two conflicting `notify` defaults
    // and never resolves the conflict.
    static class DualChannel implements EmailChannel, SmsChannel {
    }

    public static void main(String[] args) {
        DualChannel channel = new DualChannel();
        channel.notify("Order #1042 shipped");
    }
}

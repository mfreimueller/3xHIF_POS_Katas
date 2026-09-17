public class TicketSystem {

    static class Ticket {
        static final int OPEN = 0;
        static final int IN_PROGRESS = 1;
        static final int CLOSED = 2;

        private int status = OPEN;

        void advance() {
            status++;
        }

        String describe() {
            switch (status) {
                case OPEN:
                    return "waiting for triage";
                case IN_PROGRESS:
                    return "being worked on";
                case CLOSED:
                    return "resolved";
                default:
                    return "unknown status: " + status;
            }
        }
    }

    public static void main(String[] args) {
        Ticket t = new Ticket();
        System.out.println(t.describe());
        t.advance();
        System.out.println(t.describe());
        t.advance();
        System.out.println(t.describe());
        t.advance(); // bug: pushes status to 3, an invalid value
        System.out.println(t.describe());
    }
}

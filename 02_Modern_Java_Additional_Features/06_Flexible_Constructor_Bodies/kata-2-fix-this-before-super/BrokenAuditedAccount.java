public class BrokenAuditedAccount {

    static class Account {
        double balance;

        Account(double balance) {
            this.balance = balance;
        }
    }

    // Does not compile: even with flexible constructor bodies, statements
    // before super() may not call an instance method, because an instance
    // method call implicitly reads `this`, and the object is not
    // constructed yet.
    static class AuditedAccount extends Account {
        String owner;

        AuditedAccount(String owner, double initialDeposit) {
            if (initialDeposit < 0) {
                throw new IllegalArgumentException("initialDeposit must not be negative");
            }
            logCreation(owner);
            super(initialDeposit);
            this.owner = owner;
        }

        void logCreation(String owner) {
            System.out.println("Creating account for " + owner);
        }
    }

    public static void main(String[] args) {
        AuditedAccount account = new AuditedAccount("Alice", 100.0);
        System.out.println(account.owner + ": " + account.balance);
    }
}

public class RecipientPrinter {

    record Address(String street, String city) {}

    record Person(String name, Address address) {}

    record Company(String companyName, Address address, String vatId) {}

    static void printRecipient(Object recipient) {
        if (recipient instanceof Person) {
            Person person = (Person) recipient;
            Address address = person.address();
            System.out.println(person.name() + ", " + address.street() + ", " + address.city());
        } else if (recipient instanceof Company) {
            Company company = (Company) recipient;
            Address address = company.address();
            System.out.println(company.companyName() + " (VAT " + company.vatId() + "), "
                    + address.street() + ", " + address.city());
        } else {
            System.out.println("Unknown recipient: " + recipient);
        }
    }

    public static void main(String[] args) {
        Object[] recipients = {
                new Person("Alice Smith", new Address("Main St 1", "Vienna")),
                new Company("Acme GmbH", new Address("Ring 10", "Graz"), "ATU12345678"),
                "not a recipient"
        };
        for (Object recipient : recipients) {
            printRecipient(recipient);
        }
    }
}

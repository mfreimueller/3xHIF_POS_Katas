import java.util.Objects;

public final class Money {

    private final long amountInCents;
    private final String currency;

    public Money(long amountInCents, String currency) {
        if (amountInCents < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency must not be blank");
        }
        this.amountInCents = amountInCents;
        this.currency = currency;
    }

    public long getAmountInCents() {
        return amountInCents;
    }

    public String getCurrency() {
        return currency;
    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot add different currencies");
        }
        return new Money(this.amountInCents + other.amountInCents, this.currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return amountInCents == money.amountInCents && currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountInCents, currency);
    }

    @Override
    public String toString() {
        return "Money{amountInCents=" + amountInCents + ", currency='" + currency + "'}";
    }
}

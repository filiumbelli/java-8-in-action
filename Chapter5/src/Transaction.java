public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    private final Trader.Currency currency;


    public Transaction(Trader trader, int year, int value, Trader.Currency currency) {
        this.trader = trader;
        this.year = year;
        this.value = value;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                ", currency=" + currency +
                '}';
    }

    public Trader.Currency getCurrency() {
        return currency;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }
}

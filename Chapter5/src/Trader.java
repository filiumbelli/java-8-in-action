import java.util.*;

public class Trader {
    private final String name;
    private final String city;
    private static final List<Transaction> transactions;
    private static final List<Trader> traders;

    static {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader konichiva = new Trader("Konichiva", "Hong Kongo");
        traders = Arrays.asList(raoul, mario, alan, brian, konichiva);
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300, Currency.DLR),
                new Transaction(raoul, 2012, 1000, Currency.TRL),
                new Transaction(raoul, 2011, 400, Currency.DLR),
                new Transaction(mario, 2012, 710, Currency.EUR),
                new Transaction(mario, 2012, 700, Currency.EUR),
                new Transaction(alan, 2012, 950, Currency.DLR),
                new Transaction(konichiva, 2015, 52000, Currency.YEN));

    }

    enum Currency {
        DLR,
        EUR,
        TRL,
        YEN
    }

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public static List<Trader> getTraders() {
        return traders;
    }

    public static List<Transaction> getTransactions() {
        return transactions;
    }


    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }


}

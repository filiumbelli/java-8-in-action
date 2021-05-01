import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Challenges {

    public static void main(String[] args) {
        List<Transaction> transactions = Trader.getTransactions();
        List<Trader> traders = Trader.getTraders();


        // Transactions at 2011
        List<Transaction> transactionsAt2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(transactionsAt2011);


        // All unique cities
        List<String> allCities = traders.stream()
                .map(Trader::getCity)
                .distinct().collect(Collectors.toList());
        System.out.println(allCities);

        // Traders work in cambridge
        List<Trader> workInCambridge = traders.stream()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        System.out.println(workInCambridge);


        // Traders name in one string ordered
        String allInOneStringTraderNames = traders.stream()
                .map(Trader::getName)
                .sorted(Comparator.comparing(String::toString))
                .reduce("", (t1, t2) -> t1 + t2);
        System.out.println(allInOneStringTraderNames);


        // Traders from milan

        List<Trader> milanTraders = traders.stream()
                .filter(t -> t.getCity().equals("Milan"))
                .collect(Collectors.toList());
        System.out.println(milanTraders);


        // Transaction values from Cambridge
        List<Integer> transactionsFromCambridge = traders.stream()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .map(Trader::getName)
                .map(trader -> transactions.stream()
                        .filter(transaction -> transaction.getTrader().getName().equals(trader))
                        .map(Transaction::getValue)
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(transactionsFromCambridge);


        //Min Value
        Optional<Integer> maxValue = transactions.stream().map(Transaction::getValue).reduce((Integer::max));
        System.out.println(maxValue);

        //Max Value
        Optional<Integer> minValue = transactions.stream().map(Transaction::getValue).reduce((i, j) -> i < j ? i : j);
        System.out.println(minValue);


    }
}

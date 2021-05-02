import java.util.*;
import java.util.stream.Collectors;

public class CollectReduction1 {
    public static void main(String[] args) {
        final Map<Trader.Currency, List<Transaction>> collect = Trader.getTransactions()
                .stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency));

        final List<Dish> menu = Dish.getMenu();

        Long itemsInMenu = menu.stream().collect(Collectors.counting());

        Comparator<Dish> calorieComparator = Comparator.comparingInt(Dish::getCalorie);

        Optional<Dish> getMaxValue
                = menu.stream().collect(Collectors.maxBy(calorieComparator));
        Optional<Dish> getMinValue
                = menu.stream().collect(Collectors.minBy(calorieComparator));

        System.out.println("Max: " + getMaxValue + "\n" + "Min: " + getMinValue);

        Double averageCalorie = menu.stream().collect(Collectors.averagingInt(d -> d.getCalorie()));

        Integer sumOfTheCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalorie));

        System.out.println("Avg: " + averageCalorie + "\n" + "Sum: " + sumOfTheCalories);


        IntSummaryStatistics allInOne = menu.stream().collect(Collectors.summarizingInt(Dish::getCalorie));

        System.out.println("All properties: " + allInOne);
    }
}

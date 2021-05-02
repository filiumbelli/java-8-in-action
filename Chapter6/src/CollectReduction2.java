import java.util.List;
import java.util.stream.Collectors;

public class CollectReduction2 {

    public static void main(String[] args) {

        List<Dish> menu = Dish.getMenu();


        String dishNames = menu.stream().map(Dish::getName).collect(Collectors.joining(" "));

        System.out.println(dishNames);


        Integer totalCalories = menu.stream().collect(Collectors.reducing(0, Dish::getCalorie, (i, j) -> i + j));
        System.out.println("Total : " + totalCalories);

        Integer sumOf = menu.stream().collect(Collectors.reducing(0, Dish::getCalorie, Integer::sum));
        System.out.println("Total : " + sumOf);

        int total = menu.stream().mapToInt(Dish::getCalorie).sum();
        System.out.println("Total : " + total);



    }
}

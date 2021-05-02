import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partitioning {

    public static void main(String[] args) {

        List<Dish> menu = Dish.getMenu();


        Map<Boolean, List<Dish>> collect = menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(collect);


    }







}

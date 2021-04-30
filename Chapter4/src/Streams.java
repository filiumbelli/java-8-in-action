import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Streams {

    public static void main(String[] args) {

        List<Dish> menu = Dish.getMenu();
        Map<Dish.Type, List<Dish>> typeGroupedList =
                menu.stream().collect(groupingBy(Dish::getType));

        List<String> filteredByCalorieAndReturnNames = menu.stream()
                .filter(d -> d.getCalorie() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(filteredByCalorieAndReturnNames);


    }

}


import java.util.*;
import java.util.stream.Collectors;

public class Grouping {

    public static void main(String[] args) {

        List<Dish> menu = Dish.getMenu();

        Map<Dish.Type, List<Dish>> dishGroup = menu.stream().collect(Collectors.groupingBy(Dish::getType));

//        System.out.println("Group: " + dishGroup);

        Map<Dish.CaloricLeve, List<Dish>> groupByCalory = menu.stream().collect(Collectors.groupingBy(d -> {
            if (d.getCalorie() < 400) return Dish.CaloricLeve.DIET;
            else if (d.getCalorie() > 400 && d.getCalorie() < 700) return Dish.CaloricLeve.NORMAL;
            else return Dish.CaloricLeve.FAT;

        }));

        Map<String, List<Dish>> groupByPrice = menu.stream()
                .collect(Collectors.groupingBy(dish ->
                {
                    if (dish.getPrice() < 11) return "Cheap";
                    else if (dish.getPrice() > 11 && dish.getPrice() < 15) return "Normal";
                    else return "Expensive";
                }));


        Map<Dish.Type, Map<Dish.CaloricLeve, Map<String, List<Dish>>>> multiGrouping = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.groupingBy(d -> {
                            if (d.getCalorie() > 300) {
                                return Dish.CaloricLeve.DIET;
                            } else if (d.getCalorie() < 600) {
                                return Dish.CaloricLeve.NORMAL;
                            } else return Dish.CaloricLeve.FAT;
                        }, Collectors.groupingBy(d -> {
                            if (d.getPrice() <= 10) return "Cheap";
                            else if (d.getPrice() > 10 && d.getPrice() < 16) return "Normal";
                            else return "Expensive";
                        }, Collectors.toList())
                )));

//        System.out.println(multiGrouping);


//        Sub Grouping

        Map<Dish.Type, Long> dishTypesCount = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));

        System.out.println(dishTypesCount);


        Map<Dish.Type, Optional<Dish>> maxCalorieTypeGroup = menu.stream()
                .collect(Collectors
                        .groupingBy(Dish::getType, Collectors
                                .maxBy(Comparator.comparingInt(Dish::getCalorie))));

        System.out.println(maxCalorieTypeGroup);


        Map<Dish.Type, Dish> dishWithMaxCalories = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.collectingAndThen(
                        Collectors.maxBy(
                                Comparator.comparingInt(Dish::getCalorie)),
                        Optional::get)));
        System.out.println(dishWithMaxCalories);


        Map<Dish.Type, Integer> collect = menu.stream().collect(Collectors
                .groupingBy(Dish::getType, Collectors
                        .summingInt(Dish::getCalorie)));

        System.out.println(collect);

        Map<Dish.Type, List<String>> collect1 = menu.stream().collect(Collectors
                .groupingBy(Dish::getType, Collectors
                        .mapping(dish -> {
                            if (dish.getCalorie() <= 400) return "DIET";
                            else return "NORMAL";
                        }, Collectors.toList())));

        System.out.println(collect1);


        Map<Dish.Type, Set<String>> collect2 = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.mapping(dish -> {
                    if (dish.getPrice() < 10) {
                        return dish.getName() + " " + "$" + dish.getPrice();
                    }
                    return "";
                }, Collectors.toSet())));
        System.out.println(collect2);


    }
}

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams2 {

    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();

//        if (menu.stream().anyMatch(Dish::isVegetarian)) {
//            System.out.println("There are vegetarian stuffs");
//        }
//
//        System.out.println(menu.stream().filter(Dish::isVegetarian)
//                .anyMatch(d -> d.getCalorie() < 500));

        menu.stream().filter(Dish::isVegetarian)
                .findFirst()
                .ifPresent(d -> System.out.println(d.getName()));


        // Boxing Cost
        System.out.println(menu.stream().map(Dish::getCalorie)
                .reduce(0, Integer::sum));
        // Ideal
        System.out.println(menu.stream()
                .mapToInt(Dish::getCalorie)
                .sum());

        // Max Value
        System.out.println(menu.stream()
                .mapToInt(Dish::getCalorie)
                .min()
                .orElse(0));

        System.out.println(menu.stream()
                .map(Dish::getCalorie)
                .reduce(Integer::max));
        System.out.println(menu.stream()
                .map(Dish::getCalorie)
                .reduce((x, y) -> x < y ? y : x));


        // map-reduce pattern
        System.out.println(menu.stream().map(d -> 1)
                .reduce((i1, i2) -> i1 + i2));


        try (Stream<String> lines =
                     Files.lines(Paths.get("data.txt"),
                             Charset.defaultCharset())) {
            final Stream<String> stringStream = lines
                    .flatMap(l -> Arrays.stream(l.split(" ")));
            final long distinctWordCount = stringStream
                    .distinct()
                    .count();
            System.out.println(distinctWordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (final Stream<String> lines = Files.lines(Paths.get("data.txt"))) {
            System.out.println(lines
                    .map(i -> i.split(" "))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .count());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

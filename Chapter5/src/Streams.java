import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {
    public static void main(String[] args) {

        List<Dish> menu = Dish.getMenu();

        List<Dish> vegetarianMenu = menu.stream()
                .filter((e) -> e.isVegetarian())
                .collect(Collectors.toList());
        List<Integer> integers = Arrays.asList(1, 3, 4, 25, 2, 6, 2, 6, 2, 6, 2);
        List<String> strings = Arrays.asList("heelo", "its", "gonig", "to", "be", "so", "crazy");
//
//        System.out.println(menu.stream()
//                .filter(d -> d.getCalorie() > 300)
//                .map(Dish::getType)
//                .skip(2)
//                .limit(3)
//                .collect(Collectors.toList()));
//
//        System.out.println(menu.stream()
//                .filter(d -> d.getType() == Dish.Type.MEAT)
//                .map(Dish::getName)
//                .limit(2)
//                .collect(Collectors.toList()));

//        System.out.println(strings.stream()
//                .map(s -> {
//                    StringBuilder val = new StringBuilder();
//                    for (int i = 0; i < s.length(); i++) {
//                        if (!val.toString().contains(s.charAt(i) + "")) {
//                            val.append(s.charAt(i));
//                        }
//                    }
//                    return val.toString();
//                }).collect(Collectors.toList()));
//
//        System.out.println(strings.stream()
//                .map(s -> s.split(""))
//                .map(s -> Arrays.stream(s).collect(Collectors.toList()))
//                .flatMap(Collection::stream)
//                .distinct()
//                .collect(Collectors.toList()));

        // map takes string as argument
        // --> generates Stream<String[]>
        // flatmap takes List<String> as argument
        // --> generates Stream<String> from each List<String>

//        System.out.println(strings.stream()
//                .map(s -> s.split(""))
//                .flatMap(Arrays::stream)
//                .collect(Collectors.toList()));


//        System.out.println(integers.stream()
//                .map(i -> i * i)
//                .collect(Collectors.toList()));

        List<Integer> pairs = Arrays.asList(1, 5, 2);

        //map -> stream<int[]{i,j}>
        //flatmap -> stream<int>
        List<int[]> collect = pairs.stream()
                .map(i -> integers.stream().map(j -> new int[]{i, j})
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());

//        collect.forEach(i -> System.out.println(Arrays.toString(i)));


        List<int[]> dividedBy3 = collect.stream()//Stream<Int[]>
                //int[]

                .filter(ints -> IntStream.of(ints).sum() % 3 == 0)
                //convert to int by summing  and validate
                .collect(Collectors.toList());
        dividedBy3.forEach(ints -> System.out.println(Arrays.toString(ints)));
//                [1,3],[2,5],[6,4]
//                1->3 = 4

    }


}

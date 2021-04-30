import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambdas {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 5, 6, 7, 2, 5, 525, 252, 15, 15, 6);

        Comparator<Integer> byval = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        // Other way;

        Comparator<Integer> asc = Integer::compareTo;
        integers.sort(asc);
//        System.out.println(integers);

        List<Integer> even = filter(integers, (i -> {
            return i % 2 == 0;
        }));

        Integer[] even2 = integers.stream()
                .filter((i) -> {
                    return i % 2 == 0;
                }).toArray(Integer[]::new);

//        System.out.println(Arrays.toString(even2));
//        System.out.println(even);




        // Functional Interface

        threeShadesOfFunctionalInterfaces();

    }
    String hey = "Hey";

    public static <T> List<T> filter(List<T> list, FilterInterface<T> filterInterface) {
        List<T> filteredList = new ArrayList<T>();
        for (T t : list) {
            if (filterInterface.filter(t)) {
                filteredList.add(t);
            }
        }
        return filteredList;
    }

    public static void threeShadesOfFunctionalInterfaces() {
        Runnable runnable1 = () -> {
            System.out.println("Hello World!1");
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!2");
            }
        };

        process(runnable1);
        process(runnable2);
        process(() -> System.out.println("Hello World!3"));

    }

    public static void process(Runnable r) {
        r.run();
    }
}

interface FilterInterface<T> {
    public boolean filter(T t);
}

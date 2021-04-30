import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {


    public static String processFile(BufferedReaderProcessor brp) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            return brp.process(bufferedReader);
        }
    }


    public static void main(String[] args) throws IOException {
        System.out.println(processFile(BufferedReader::readLine));
        System.out.println(processFile(br -> {
            return br.readLine() + " " + br.readLine();
        }));
        ArrayList<String> filteredList = new ArrayList<>();
        processFile(br -> {
            while (br.readLine() != null) {
                String s = br.readLine().toUpperCase();
                filteredList.add(s);
            }
            return filteredList.toString();
        });
        System.out.println(filteredList);


        List<Integer> integers = Arrays.asList(1, 4, 2, 5, 2, 3, 15, 6, 7, 8, 5, 3, 2, 1);

        Consumer<Integer> consumer = (integer) -> {
            integer += 3;
        };
        Predicate<Integer> predicate = (integer) -> {
            return integer > 3;
        };
        consumerHelper((integer -> {
//            System.out.println(integer + 3);
        }), integers);

        List<Integer> greaterThan5 = predicateHelper(integer -> {
            return integer > 5;
        }, integers);
//        System.out.println(greaterThan5);

        List<String> strings = Arrays.asList("hello", "amazing", "isnt", "it");
        List<Integer> longerThan3Letter = functionHelper((s) -> {
            return (s.length() > 3) ? s.length() : 0;
        }, strings);
        System.out.println(longerThan3Letter.toString());

        List<Integer> greaterThan6 = intPredicateHelper(i -> {
            return i > 6;
        }, integers);

        System.out.println(greaterThan6);


        integers.sort(Comparator.comparing(Integer::valueOf));
        strings.sort(Comparator.comparing(String::length));
        strings.sort(String::compareToIgnoreCase);


        /// Constructor type Functionals
        Supplier supplier = String::new;
        supplier.get();
        Function<Integer,ArrayList> stringFunction = ArrayList::new;
        ArrayList apply = stringFunction.apply(10);
    }


    // For performance issues, It helps the JIT. Autoboxing is not required.
    public static List<Integer> intPredicateHelper(IntPredicate intPredicate, List<Integer> integers) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : integers) {
            if (intPredicate.test(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static <T, R> List<R> functionHelper(Function<T, R> function, List<T> list) {
        ArrayList<R> results = new ArrayList<>();
        for (T s : list) {
            results.add(function.apply(s));
        }
        return results;
    }

    public static void consumerHelper(Consumer<Integer> c, List<Integer> integers) {
        for (int i : integers) {
            c.accept(i);
        }
    }

    public static List<Integer> predicateHelper(Predicate<Integer> p, List<Integer> integers) {
        ArrayList<Integer> filteredList = new ArrayList<>();
        for (int i : integers) {
            if (p.test(i)) {
                filteredList.add(i);
            }
        }
        return filteredList;
    }
}

@FunctionalInterface
interface BufferedReaderProcessor {
// I have an interface to solve the abstraction problem
// This interface will held the business logic with lambda expression
// I will have another function to handle the supply for the lambda expression
// In this case we supplied BufferedReader with pre-read file('data.txt')
// With the static supply method we used lambda method to override process method

    String process(BufferedReader br) throws IOException;
}



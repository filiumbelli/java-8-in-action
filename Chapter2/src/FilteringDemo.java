import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringDemo {

    public static void main(String[] args) {

        Apple red3 = new Apple(125, "red");
        Apple green1 = new Apple(100, "green");
        Apple red2 = new Apple(120, "red");
        Apple green = new Apple(255, "green");
        Apple red1 = new Apple(250, "red");
        Apple red = new Apple(220, "red");

        List<Apple> apples = new ArrayList<>();
        apples.add(green);
        apples.add(green1);
        apples.add(red);
        apples.add(red1);
        apples.add(red2);
        apples.add(red3);
        ApplePredicate heavyWeightPredicate = new HeavyWeightPredicate();
        ApplePredicate greenColorPredicate = new GreenColorPredicate();

        List<Apple> heavyWeightFilter = FilterApples.filter(apples, greenColorPredicate);
        PrintApples.printApples(heavyWeightFilter, new FancyAppleFormatter());

        List<Apple> redApples = FilterApples.filter(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("red");
            }
        });

        List<Apple> greenApples = GenericFilter.filter(apples, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("green");
            }
        });

        List<Integer> ints = Arrays.asList(1, 2, 5, 6, 2, 7, 27, 2);
        List<Integer> evenValues = GenericFilter.filter(ints, (i) -> {
            return i % 2 == 0;
        });
//        System.out.println(redApples);
//        System.out.println(greenApples);
//        System.out.println(evenValues);

        System.out.println(apples);
        apples.sort((Apple o1, Apple o2) -> {
            return Math.max(o1.getWeight(), o2.getWeight());
        });
        System.out.println(apples);
    }

    public static <T> List<T> filt(List<T> list, Predicate<T> pred) {
        List<T> ts = new ArrayList<>();
        for (T t : list) {
            if (pred.test(t)) {
                ts.add(t);
            }
        }
        return ts;
    }
}


class Apple {
    private int weight;
    private String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

interface ApplePredicate {
    boolean test(Apple apple);
}


class HeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

class GreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("green");
    }
}

class FilterApples {
    public static List<Apple> filter(List<Apple> list, ApplePredicate applePredicates) {
        List<Apple> filteredList = new ArrayList<>();
        for (Apple a : list) {
            if (applePredicates.test(a)) {
                filteredList.add(a);
            }
        }
        return filteredList;
    }

}

class PrintApples {

    public static void printApples(List<Apple> apples, AppleFormatter formatter) {
        for (Apple a : apples) {
            System.out.println(formatter.format(a));
        }
    }
}

interface AppleFormatter {
    String format(Apple apple);
}

class FancyAppleFormatter implements AppleFormatter {
    @Override
    public String format(Apple apple) {
        return "A " + apple.getColor()
                + " , "
                + (apple.getWeight() > 150 ? "heavy " : " light ")
                + " apple!";
    }
}


interface Predicate<T> {
    boolean test(T t);
}

class GenericFilter {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}


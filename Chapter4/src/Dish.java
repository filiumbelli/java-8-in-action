import java.util.Arrays;
import java.util.List;

public class Dish {
    private String name;
    private final boolean vegetarian;
    private int calorie;
    private Type type;

    public Dish(String name, boolean vegetarian, int calorie, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calorie = calorie;
        this.type = type;
    }

    public enum Type {
        MEAT,
        OTHER,
        FISH,

    }
    public static List<Dish> getMenu() {
        List<Dish> menu =
                Arrays.asList(
                        new Dish("chicken", false, 400, Dish.Type.MEAT),
                        new Dish("beef", false, 700, Dish.Type.MEAT),
                        new Dish("pork", false, 800, Dish.Type.MEAT),
                        new Dish("frenchfries", true, 530, Dish.Type.OTHER),
                        new Dish("rice", true, 350, Dish.Type.OTHER),
                        new Dish("seasonfruit", true, 120, Dish.Type.OTHER),
                        new Dish("pizza", true, 550, Dish.Type.OTHER),
                        new Dish("prawns", false, 300, Dish.Type.FISH),
                        new Dish("salmon", false, 450, Dish.Type.FISH)
                );

        return menu;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "calorie=" + calorie +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }
}


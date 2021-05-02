import java.util.Arrays;
import java.util.List;

public class Dish {
    private String name;
    private final boolean vegetarian;
    private int calorie;
    private Type type;
    private int price;

    public Dish(String name, boolean vegetarian, int calorie, Type type, int price) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calorie = calorie;
        this.type = type;
        this.price = price;
    }

    public enum CaloricLeve {
        DIET, NORMAL, FAT
    }

    public enum Type {
        MEAT,
        OTHER,
        FISH,

    }

    public static List<Dish> getMenu() {
        List<Dish> menu =
                Arrays.asList(
                        new Dish("chicken", false, 400, Dish.Type.MEAT, 10),
                        new Dish("beef", false, 700, Dish.Type.MEAT, 12),
                        new Dish("pork", false, 800, Dish.Type.MEAT, 8),
                        new Dish("frenchfries", true, 530, Dish.Type.OTHER, 5),
                        new Dish("rice", true, 350, Dish.Type.OTHER, 6),
                        new Dish("seasonfruit", true, 120, Dish.Type.OTHER, 12),
                        new Dish("pizza", true, 550, Dish.Type.OTHER, 20),
                        new Dish("prawns", false, 300, Dish.Type.FISH, 25),
                        new Dish("salmon", false, 450, Dish.Type.FISH, 20)
                );

        return menu;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calorie=" + calorie +
                ", type=" + type +
                ", price=" + price +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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


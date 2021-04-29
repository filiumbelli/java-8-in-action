import java.util.ArrayList;
import java.util.List;

public class Codes {
    public static void main(String[] args) {
        Item book = new Item("Book", 150);
        Item heavyBook = new Item("Book", 325);
        Item brocoli = new Item("Brocoli", 500);
        Item cakeBakery = new Item("Cake Bakery", 230);
        Inventory inv = new Inventory();
        inv.addItem(cakeBakery);
        inv.addItem(brocoli);
        inv.addItem(book);
        inv.addItem(heavyBook);


        inv.getItems().stream()
                .filter(item -> {
                    return item.getName().equals("Book") && item.getWeight() > 150;
                }).forEach(System.out::println);
    }
}

class Inventory {

    List<Item> items = new ArrayList<Item>();

    public List<Item> getItems() {
        return items;
    }

    void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "items=" + items +
                '}';
    }
}

class Item {
    private String name;
    private double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}

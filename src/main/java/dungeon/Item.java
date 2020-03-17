package dungeon;

public class Item {

    private String item;
    private double value;

    public Item(String item, double value) {
        this.item = item;
        this.value = value;
    }

    public String getItem() {
        return item;
    }

    public double getValue() {
        return value;
    }
}

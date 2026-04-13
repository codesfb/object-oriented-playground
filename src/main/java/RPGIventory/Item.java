package main.java.RPGIventory;

public class Item {
    private String name;
    private double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}'+ "\n";
    }

    public double getWeight() {
        return weight;
    }
}

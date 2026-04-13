package main.java.RPGIventory;

import java.util.Arrays;

public class Chest {
    private Item[] chest;

    public Chest(Item[] chest) {
        this.chest = chest;
    }

    @Override
    public String toString() {
        return "Chest{" +
                "items=" + Arrays.toString(chest) +
                '}';
    }




    public Item[] getChest() {
        return chest;
    }
}

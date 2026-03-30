import java.util.Arrays;

public class Character {
    private Item[] items;
    private Chest availableChest;

    public void setAvailableChests(Chest availableChest) {
        this.availableChest = availableChest;
    }

    private int availableSpace;
    private int itemsIndex;

    public Character(int availableSpace) {
        this.availableSpace = availableSpace;
        this.items = new Item[availableSpace];

    }
    //pega um item do final
    public void takeItems(Item[] findedItems){
          if(availableSpace != 0 && !isFull()){
                items[itemsIndex++] = findedItems[findedItems.length-1];
                findedItems[findedItems.length-1]= null;
                availableSpace--;

          }
    }

    public void takeSpecificItem( int itemIndex){
            if(availableSpace != 0 && !isFull() && availableChest != null){
                items[itemsIndex++]=availableChest.getChest()[itemIndex];
                availableSpace--;
            }
    }


    @Override
    public String toString() {
        return "Character{" +
                "items=" + Arrays.toString(items) +
                ", availableSpace=" + availableSpace +
                ", itemsIndex=" + itemsIndex +
                '}';
    }

    public boolean isFull(){
        return items.length == 3 && availableSpace == 0;
    }

    public Item[] getItems() {
        return items;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }
}

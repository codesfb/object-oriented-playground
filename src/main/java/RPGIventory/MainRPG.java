package main.java.RPGIventory;

public class MainRPG {
    static void main() {
        Character character = new Character(3);
        Item[] items = {
                new Item("Ouro", 5),
                new Item("pedra", 4),
                new Item("espada", 3),
                new Item("terra", 2),
                new Item("diamante", 7)
        };

        Chest chest = new Chest(items);

        System.out.println(chest.toString());
        System.out.println(character.toString());

        character.takeItems(items);

        System.out.println(chest.toString());
        System.out.println(character.toString());

        Item[] items2 = {
                new Item("Ouro", 5),
                new Item("pedra", 4),
                new Item("espada", 3),
                new Item("terra", 2),
                new Item("diamante", 7)
        };
        //agora quero que ele tenha os baus e possa escolher qualquer item
        //para seu inventario
        Chest chest2 = new Chest(items2);
        character.setAvailableChests(chest2);
        character.takeSpecificItem(2);

        System.out.println(chest2.toString());
        System.out.println(character.toString());









    }
}

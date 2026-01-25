public class GameState {
    public static void main(String[] args) {
        // Create a new player
        Player newPlayer = new Player();
        ItemCrafter newItemCrafter = new ItemCrafter();

        // Test that ItemCrafter works
        Item newItem = newItemCrafter.createNewItem();
        newItem.showItemInfo();

        // Test reroll capabilities
        newPlayer.setCoins(500000000);
        newItemCrafter.reroll(newPlayer);

        // Game continues happening while player health is greater than 0
//        while (newPlayer.getHealth() > 0) {
//
//        }
    }
}

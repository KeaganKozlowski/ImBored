public class GameState {
    public static void main(String[] args) {
        // Create a new player
        Player newPlayer = new Player();
        ItemCrafter newItemCrafter = new ItemCrafter();

        // Test that ItemCrafter works
        Item newItem = newItemCrafter.createNewItem();
        newItem.showItemInfo();
    }
}

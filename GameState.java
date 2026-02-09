import java.util.*;
import java.util.Scanner;

public class GameState {
    private final String[] monsterOptions = new String[]{"Zombie", "Skeleton", "Spider"};
    private int currentFloor = 0;
    private ArrayList<Monster> enemies = new ArrayList<>();
    private Monster currentMonster = null;
    private Scanner playerInput = new Scanner(System.in);
    // Initalize objects
    private Player newPlayer;
    private ItemCrafter newItemCrafter;
    // Bool for actual gamestate
    private boolean isRunning;
    public void GameState() {
        // Create a new player
        newPlayer = new Player();
        newItemCrafter = new ItemCrafter();

        // Test that ItemCrafter works
        // Item newItem = newItemCrafter.createNewItem();
        // newItem.showItemInfo();

        // Test reroll capabilities
        //newPlayer.setCoins(500000000);
        //newItemCrafter.reroll(newPlayer);

        // gamestate
        this.isRunning = true;

        // Game continues happening while player health is greater than 0
        while (newPlayer.getHealth() > 0) {
            // Generate enemies
            enemies = generateMonsters(currentFloor);
            while (!enemies.isEmpty() && newPlayer.getHealth() > 0) {
                currentMonster = enemies.get(currentFloor);
                while (currentMonster.getHealth() > 0) {
                    // Player attacks
                    if (attackHit(true)){
                        currentMonster.takeDamage(newPlayer.getCurrentDamage());
                    }
                    // Monster attacks
                    if (attackHit(false)){
                        newPlayer.setHealth(currentMonster.attack());
                    }
                }
                enemies.remove(currentMonster);
            }
            currentFloor++;
            // Create an item for the player
            newPlayer.setAddItemtoInventory(newItemCrafter.createNewItem());
            // Show player inventory beforehand
            System.out.println("Here is your inventory to help you:");
            newPlayer.showPlayerInventory();
            // Let the player reroll if they choose to
            System.out.println("Would you like a new item: y(es)|n(o): ");
            if (playerInput.nextLine().equalsIgnoreCase("y")) {
                newPlayer.setAddItemtoInventory(newItemCrafter.reroll(newPlayer));
            }
            System.out.println("What would you like to do next: \n" +
                                "1. Select new weapon from inventory \n" +
                                "2. Continue fight: ");
            if (playerInput.nextLine().equalsIgnoreCase("1")) {
                newPlayer.showPlayerInventory();
                System.out.println("Which one would you like to select, give from 0->x");
                newPlayer.setEquippedItem(playerInput.nextInt());
            } else {
                break;
            }
        }
        System.out.println("You reach floor " + currentFloor);

    }
    public void update(){
        if (newPlayer.getHealth() <= 0) {
            endGame("You died game over");
        }
    }
    public void endGame(String message) {
        System.out.println(message);
        this.isRunning = false;
    }
    public boolean isRunning(){
        return isRunning;
    }
    private ArrayList<Monster> generateMonsters(int floor) {
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < floor + 1; i++) {
            String monsterType = monsterOptions[(int) (Math.random() * monsterOptions.length)];
            switch (monsterType) {
                case "Zombie":
                    monsters.add(new Zombie());
                case "Spider":
                    monsters.add(new Spider());
                default:
                    monsters.add(new Skeleton());
            }
        }
        return monsters;
    }
    private boolean attackHit(boolean isPlayer){
        int number = (int) (Math.random() * 100);
        if (isPlayer){
            return number > 49;
        } else {
            return number <= 20;
        }
    }
}




import java.util.*;
import java.util.Scanner;

public class GameState {
    private static final String[] monsterOptions = new String[]{"Zombie", "Skeleton", "Spider"};
    private static int currentFloor = 0;
    private static ArrayList<Monster> enemies = new ArrayList<>();
    private static Monster currentMonster = null;
    Scanner playerInput = new Scanner(System.in);
    public static void main(String[] args) {
        // Create a new player
        Player newPlayer = new Player();
        ItemCrafter newItemCrafter = new ItemCrafter();

        // Test that ItemCrafter works
        Item newItem = newItemCrafter.createNewItem();
        newItem.showItemInfo();

        // Test reroll capabilities
        //newPlayer.setCoins(500000000);
        //newItemCrafter.reroll(newPlayer);

//         Game continues happening while player health is greater than 0
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
            // Create an item for the player
            
            // Let the player reroll if they choose to
        }
    }
    private static ArrayList<Monster> generateMonsters(int floor) {
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
    private static boolean attackHit(boolean isPlayer){
        int number = (int) (Math.random() * 100);
        if (isPlayer){
            return number > 49;
        } else {
            return number <= 20;
        }
    }
}




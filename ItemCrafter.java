import java.util.Scanner;

public class ItemCrafter {
    private Item item;
    private final String[] typeOptions;
    private boolean canUse;
    private Scanner scan;
    public ItemCrafter(){
        this.typeOptions = new String[]{"Sword","Axe","Spear","Bow"};
        this.canUse = true;
    }
    public Item createNewItem(){
        this.item = new Item(setType(), setRarity());
        return this.item;
    }
    private String setType(){
        return this.typeOptions[(int)(Math.random()*this.typeOptions.length)];
    }
    private String setRarity(){
        double roll = Math.random() * 100;
        if (roll < 70){
            return "Common";
        } else if (roll < 90){
            return "Epic";
        } else if (roll < 98){
            return "Legendary";
        } else {
            return "Mythic";
        }
    }
    public void setCanUse(){
        this.canUse = !this.canUse;
    }
    private int calculateCoinsForReroll(int currentRoll){
        return (int)(50 * Math.pow(1.5,currentRoll));
    }
    public Item reroll(Player player){
        int currentRoll = 0;
        int currentCoins = player.getCoins();
        Item currentItem = this.item;
        while (this.canUse && calculateCoinsForReroll(currentRoll) <= currentCoins){
            currentItem = createNewItem();
            System.out.println("------");
            currentItem.showItemInfo();
            System.out.println("------");
            currentCoins -= calculateCoinsForReroll(currentRoll);
            currentRoll++;
            if (currentItem.getRarity().equals("Mythic")) {
                System.out.println("Well done you pulled a Mythic item");
                setCanUse();
            }
        }
        player.setCoins(currentCoins);
        return currentItem;
    }
}

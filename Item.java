import java.util.Random;

public class Item {
    private Random random = new Random();
    private String type;
    private String rarity;
    private int damage;
    private int durability;
    private int sellPrice;
     public Item(String type, String rarity){
        this.type = type;
        this.rarity = rarity;
        damage = setDamage(rarity);
        durability = setDurability(rarity);
        sellPrice = setSellPrice(rarity, type);
     }
    private int setDamage(String rarity){
        return switch (rarity) {
            case "Common" -> random.nextInt(1, 10);
            case "Uncommon" -> random.nextInt(10, 15);
            case "Rare" -> random.nextInt(15, 20);
            default -> random.nextInt(20, 50);
        };
    }
    private int setDurability(String rarity){
        return switch (rarity ) {
            case "Common" -> 5;
            case "Epic" -> 10;
            case "Legendary" -> 15;
            default -> 30;
        };
    }
    private int setSellPrice(String rarity, String type){
        int baseValue = switch (type) {
            case "Axe" -> 100;
            case "Sword" -> 75;
            case "Bow" -> 40;
            case "Spear" -> 25;
            default -> 0;
        };
        return switch (rarity) {
            case "Common" -> baseValue;
            case "Epic" -> (int) (baseValue * 2.5);
            case "Legendary" -> baseValue * 6;
            case "Mythic" -> (int) (baseValue * 15.0);
            default -> baseValue;
        };
    }
    public int getDamage(){
        return this.damage;
    }
    public int getDurability(){
        return this.durability;
    }
    public int getSellPrice(){
        return this.sellPrice;
    }
    public void setDurabilityAfterUse(){
         this.durability -= 1;
    }

}

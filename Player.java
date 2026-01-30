import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory;
    private int health;
    private int level;
    private int experience;
    private int coins;
    private Item equippedItem;
    private int currentDamage;
    public Player(){
        this.inventory = new ArrayList<>(5);
        this.health = 100;
        this.level = 1;
        this.experience = 0;
        this.coins = 0;
        this.equippedItem = null;
        this.currentDamage = 1;
    }
    public void setHealth(int damageTaken){
        this.health -= damageTaken;
    }
    public void setLevel(){
        if (this.experience >= 100){
            this.level += 1;
        }
    }
    public void setExperience(int experienceGained){
        if (this.experience + experienceGained >= 100){
            setLevel();
            this.experience = (this.experience + experienceGained) - 100;
        } else {
            this.experience += experienceGained;
        }
    }
    public void setCoins(int coins){
        this.coins = coins;
    }
    public void setEquippedItem(int choice){
        this.equippedItem = this.inventory.get(choice);
        setCurrentDamage();
    }
    public void setCurrentDamage(){
        this.currentDamage = equippedItem.getDamage();
    }
    public void setAddItemtoInventory(Item newItem){
        this.inventory.add(newItem);
    }
    public void setRemoveItemfromInventory(Item oldItem){
        this.inventory.remove(oldItem);
    }
    public int getHealth(){
        return this.health;
    }
    public int getLevel(){
        return this.level;
    }
    public int getExperience(){
        return this.experience;
    }
    public int getCoins(){
        return this.coins;
    }
    public Item getEquippedItem(){
        return this.equippedItem;
    }
    public int getCurrentDamage(){
        return this.currentDamage;
    }
    public void showPlayerInventory(){
        //System.out.println(this.inventory);
        for (Item item: this.inventory){
            System.out.println(this.inventory.indexOf(item)+":");
            item.showItemInfo();
        }
        System.out.println("----------------");
    }
    public void showPlayerInfo(){
        showPlayerInventory();
        System.out.println(getHealth());
        System.out.println(getLevel());
        System.out.println(getExperience());
        System.out.println(getCoins());
        System.out.println(getEquippedItem());
        System.out.println(getCurrentDamage());
    }
}

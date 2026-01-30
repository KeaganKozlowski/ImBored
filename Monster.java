public abstract class Monster {
    protected String name;
    protected int health;
    protected int damage;
    public Monster(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    public void takeDamage(int damage) {
        this.health -= damage;
    }
    public int getHealth() {
        return this.health;
    }
    public abstract int attack();
}

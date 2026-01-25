public class Zombie extends Monster{
    public Zombie(){
        super("Zombie", 10, 5);
    }
    @Override
    public int attack(){
        if (Math.random() < 0.5){
            return this.damage;
        } else {
            return 0;
        }
    }
}

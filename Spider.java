public class Spider extends Monster{
    public Spider(){
        super("Spider", 20, 8);
    }
    @Override
    public int attack(){
        if (Math.random() < 0.08){
            return this.damage;
        } else {
            return 0;
        }
    }
}

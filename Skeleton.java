public class Skeleton extends Monster{
    public Skeleton(){
        super("Skeleton", 20, 8);
    }
    @Override
    public int attack(){
        if (Math.random() < 0.3){
            return this.damage;
        } else {
            return 0;
        }
    }
}

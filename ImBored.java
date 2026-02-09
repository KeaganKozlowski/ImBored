public class ImBored {
    public static void main(String[] args) {
        // Create new game
        GameState state = new GameState();
        while (state.isRunning()){
            state.update();
        }
        System.out.println("Thanks for playing");
        // Add logic here to display leaderboard and save their score, if in top 10
    }
}

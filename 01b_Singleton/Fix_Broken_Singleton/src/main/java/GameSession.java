public class GameSession {

    private static GameSession instance;

    public GameSession() {
    }

    public static GameSession getInstance() {
        return new GameSession(); // bug: never caches, always creates a new instance
    }

    private int score = 0;

    public void addPoints(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public static void main(String[] args) {
        GameSession.getInstance().addPoints(10);
        GameSession.getInstance().addPoints(5);
        System.out.println(GameSession.getInstance().getScore());
        System.out.println(GameSession.getInstance() == GameSession.getInstance());
    }
}

public class Player {
    int health;
    int x;
    int y;

    public Player(int health, int x, int y) {
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public Player() {
        health = 25;
        x = 0;
        y = 0;
    }
}

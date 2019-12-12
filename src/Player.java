public class Player {
    private int health;
    private int x;
    private int y;

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public void moveX(int move) {
        this.x += move;
    }

    public int getY() {
        return y;
    }

    public void moveY(int move) {
        this.y -= move;
    }
}

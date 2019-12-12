import java.util.List;
import java.util.Random;

public class Model {
    DatabaseHelper helper;
    Character player;
    Character enemy;

    public Model() {
        helper = new DatabaseHelper();
        player = new Character(2, 2);
        enemy = new Character(2, 2);
    }

    public boolean isEnemyHit(int playerX, int playerY, int enemyX, int enemyY) {
        int radius = 55;
        return Math.sqrt( Math.pow((playerX - enemyX), 2) + Math.pow((playerY - enemyY), 2) ) < radius;
    }

    public void insertPlayer(Player player) {
        helper.insertPlayer(player);
    }

    public List<Player> getPlayerList() {
        return helper.getAllPlayersList();
    }

    public void deletePlayerList() {
        helper.deletePlayers();
    }

    public void closeList() {
        helper.closeConnection();
    }

    public void attack() {
        enemy.damage(player.attack);
        enemyAction();
    }

    public void buff() {
        player.buff();
        enemyAction();
    }

    public void heal() {
        player.heal();
        enemyAction();
    }

    public boolean run() {
        enemyAction();
        return new Random().nextInt(2) > 0;
    }

    private void enemyAction() {
        int action = new Random().nextInt(3);
//        if (player.health > enemy.health) { action = 0; } // if enemy health is less than player enemy will attack
        switch (action) {
            case 0:
                // enemy attack
                player.damage(enemy.attack);
                break;
            case 1:
                // enemy buff
                enemy.buff();
                break;
            case 2:
                // enemy heal
                enemy.heal();
                break;
        }
    }
}

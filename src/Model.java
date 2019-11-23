import java.util.Random;

public class Model {
    final int PLAYER_BASE_HEALTH = 25;
    final int ENEMY_BASE_HEALTH = 15;
    int playerHealth  = PLAYER_BASE_HEALTH;
    int enemyHealth  = ENEMY_BASE_HEALTH;
    int playerAttack = 5;
    int enemyAttack = 3;
    int playerShield = 3;
    int enemyShield = 5;
    int heal = 5;
    int chance = 2;

    protected void heal() {
        playerHealth += heal;
    }

    protected boolean run() {
        return new Random().nextInt(chance) == 0;
    }
}

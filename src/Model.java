import java.util.Random;

public class Model {
    Character player;
    Character enemy;

    public Model() {
        player = new Character(5, 2, 2);
        enemy = new Character(3, 1, 1);
    }

    public void attack() {
        System.out.println("=PLAYER=");
        enemy.damage(player.attack);
        System.out.println("=ENEMY=");
        enemyAction();
    }

    public void buff() {
        System.out.println("=PLAYER=");
        player.buff();
        System.out.println("=ENEMY=");
        enemyAction();
    }

    public void heal() {
        System.out.println("=PLAYER=");
        player.heal();
        System.out.println("=ENEMY=");
        enemyAction();
    }

    public void run() {
        System.out.println("=PLAYER=");
        System.out.println("run: " + player.run());
        System.out.println("=ENEMY=");
        enemyAction();
    }

    private void enemyAction() {
        int action = new Random().nextInt(2);
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

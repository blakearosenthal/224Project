import java.util.Random;

public class Character {
    final int BASE_HEALTH = 25;
    int health = BASE_HEALTH;
    int defense = 0;
    int attack;
    int heal;
    int luck;

    public Character(int attack, int heal, int luck) {
        this.attack = attack;
        this.heal = heal;
        this.luck = luck;
    }

    public void damage(int damage) {
        int random = new Random().nextInt(5 - luck);
        int finalDamage = defense - damage - random;
        System.out.println("post calculations damage: " + finalDamage);
        if ((heal + finalDamage) < 0) {
            health = 0;
        } else {
            health += finalDamage;
        }
        System.out.println("health after damage: " + health);
    }

    public void heal() {
        if (health < BASE_HEALTH) {
            health += heal;
            System.out.println("health after healing: " + health);
        }
    }

    public void buff() {
        if (new Random().nextInt() < 0) {
            System.out.println("buffing attack by: 1");
            attack += 1;
        } else {
            System.out.println("buffing defense by: 1");
            defense += 1;
        }
    }

    public boolean run() {
        int random = new Random().nextInt(luck);
        return random > 0;
    }
}

import java.util.Random;

public class Character {
    final int BASE_HEALTH = 25;
    int health = BASE_HEALTH;
    int defense = 0;
    int attack;
    int heal;

    public Character(int attack, int heal) {
        this.attack = attack;
        this.heal = heal;
    }

    public void damage(int damage) {
        int random = new Random().nextInt(3);
        int calculatedDamage = defense - damage - random;
        if ((health + calculatedDamage) < 0) {
            health = 0;
        } else {
            health += calculatedDamage;
        }
    }

    public void heal() {
        if (health < BASE_HEALTH) {
            health += heal;
            if (health > 25) {
                health = 25;
            }
        }
    }

    public void buff() {
        attack += 1;
    }
}

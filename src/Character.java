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
        int calculatedDamage = defense - damage;
        if ((health + calculatedDamage) < 0) {
            health = 0;
        } else {
            health += calculatedDamage;
        }
    }

    public void heal() {
        if (health < BASE_HEALTH) {
            health += heal;
            System.out.println("health after healing: " + health);
        }
    }

    public void buff() {
        System.out.println("buffing attack by: 1");
        attack += 1;
    }
}

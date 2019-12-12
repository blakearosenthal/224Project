import java.util.Random;

public class Character {
    final int BASE_HEALTH = 25;
    int health;
    int defense;
    int attack;
    int heal;
    int x;
    int y;
    double moveWeight;

    public Character(int attack, int heal, int x, int y) {
        this.attack = attack;
        this.heal = heal;
        this.health = BASE_HEALTH;
        this.defense = 0;

        this.x = x;
        this.y = y;
        this.moveWeight = 1.2;
    }

    public Character(int attack, int heal, int x, int y, int health) {
        this.attack = attack;
        this.heal = heal;
        this.health = health;
        this.defense = 0;

        this.x = x;
        this.y = y;
        this.moveWeight = 1.2;
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

    public int getHealth() {
        return health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveX(int move) {
        this.x += move;
    }

    public void moveY(int move) {
        this.y -= move;
    }

    public void randomMove(int width, int height) {
        if(x < 125 || y < 125)
            moveWeight = 0.4;
        if(x > width - 175 || y > height - 175)
            moveWeight = 1.7;
        int direction = (int)(Math.pow(Math.random(),moveWeight) * 4);
        switch(direction) {
            case 0:
                if (x < 75)
                    x += 10;
                else
                    x -= 10;
                break;
            case 1:
                if (y < 75)
                    y += 10;
                else
                    y -= 10;
                break;
            case 2:
                if (x > width - 125)
                    x -= 5;
                else
                    x += 5;
                break;
            case 3:
                if (y > height - 125)
                    y -= 5;
                else
                    y += 5;
                break;
        }
    }
}

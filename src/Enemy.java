import java.awt.event.KeyEvent;

public class Enemy {
    int health;
    int x;
    int y;

    public Enemy(int health, int x, int y) {
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public Enemy() {
        health = 25;
        x = 0;
        y = 0;
    }

    /*switch (keyEvent.getKeyCode()) {
        case KeyEvent.VK_RIGHT:
            if (!(view.overworldPanel.player.x + 69 > view.overworldPanel.width)) {
                view.overworldPanel.player.x += 5;
            }
            break;
        case KeyEvent.VK_LEFT:
            if (!(view.overworldPanel.player.x - 19 < 0)) {
                view.overworldPanel.player.x -= 5;
            }
            break;
        case KeyEvent.VK_UP:
            if (!(view.overworldPanel.player.y - 19 < 0)) {
                view.overworldPanel.player.y -= 5;
            } else {
                view.toggleCombat();
            }
            break;
        case KeyEvent.VK_DOWN:
            if (!(view.overworldPanel.player.y + 64 > view.overworldPanel.height)) {
                view.overworldPanel.player.y += 5;
            }
            break;
    }*/
}

public class Enemy {
    private int health;
    private int x;
    private int y;
    private double moveWeight;

    public Enemy(int health, int x, int y) {
        this.health = health;
        this.x = x;
        this.y = y;
        moveWeight = 1;
    }

    public Enemy() {
        health = 25;
        x = 0;
        y = 0;
        moveWeight = 1;
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

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void randomMove(int width, int height) {
        if(x < 125 || y < 125)
            moveWeight = 0.5;
        if(x > width - 175 || y > height - 175)
            moveWeight = 1.5;
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

import javax.swing.*;
import java.awt.event.*;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
        view.overworldPanel.playerList = model.getPlayerList();
        this.model.deletePlayerList();

        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                model.insertPlayer(view.overworldPanel.player);
                model.closeList();
                System.exit(0);
            }
        });

        view.overworldPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        if (!playerCollidesWithHitBox('E')) {
                            view.overworldPanel.player.moveX(+5);
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (!playerCollidesWithHitBox('W')) {
                            view.overworldPanel.player.moveX(-5);;
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (!playerCollidesWithHitBox('N')) {
                            view.overworldPanel.player.moveY(+5);
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (!playerCollidesWithHitBox('S')) {
                            view.overworldPanel.player.moveY(-5);
                        }
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });

        view.optionsPanel.fightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int previousPlayerHealth = model.player.health;
                int previousEnemyHealth = model.enemy.health;
                model.attack();
                int postPlayerHealth = model.player.health;
                int postEnemyHealth = model.enemy.health;
                view.optionsPanel.statusText.setText("Your Attack did " +
                        (previousEnemyHealth - postEnemyHealth) + " damage point(s)! Enemy attacked for " +
                        (previousPlayerHealth - postPlayerHealth) + " damage point(s)!");
                updateCombat();
            }
        });

        view.optionsPanel.buffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int previousPlayerHealth = model.player.health;
                model.buff();
                int postPlayerHealth = model.player.health;
                view.optionsPanel.statusText.setText("Attack power increased by 1! Enemy attacked for " +
                        (previousPlayerHealth - postPlayerHealth) + " damage point(s)!");
                updateCombat();
            }
        });

        view.optionsPanel.healButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int previousPlayerHealth = model.player.health;
                model.heal();
                int postPlayerHealth = model.player.health;
                view.optionsPanel.statusText.setText("Healed for " +  model.player.heal +
                        " health point(s)! Enemy attacked for " +
                        (previousPlayerHealth - postPlayerHealth) + " damage point(s)!");
                updateCombat();
            }
        });

        view.optionsPanel.runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("RUN");
                if (model.run()) {
                    view.toggleCombat();
                    view.overworldPanel.requestFocusInWindow();
                }
            }
        });
    }

    private boolean playerCollidesWithHitBox(char direction) {
        if (direction == 'E' && view.overworldPanel.player.getX() + 69 > view.overworldPanel.width)
            return true;
        if (direction == 'W' && view.overworldPanel.player.getX() - 18 < 0)
            return true;
        if (direction == 'N' && view.overworldPanel.player.getY() - 18 < 0)
            return true;
        if (direction == 'S' && view.overworldPanel.player.getY() + 64 > view.overworldPanel.height)
            return true;
        if (model.isEnemyHit(   view.overworldPanel.player.getX(), view.overworldPanel.player.getY(),
                                view.overworldPanel.enemy.getX(), view.overworldPanel.enemy.getY()))
        {
            view.toggleCombat();
            if(view.overworldPanel.player.getX() + 175 < view.overworldPanel.width)
                view.overworldPanel.player.moveX(+110);
            else
                view.overworldPanel.player.moveX(-110);
            return true;
        }

        return false;
    }

    private void updateCombat() {
        view.gamePanel.playerHealth = model.player.health;
        view.gamePanel.enemyHealth = model.enemy.health;
        if (model.player.health <= 0) {
            view.optionsPanel.statusText.setText("You died!");
            toggleCombatWithDelay();
        } else if (model.enemy.health <= 0) {
            view.optionsPanel.statusText.setText("The enemy has been defeated!");
            toggleCombatWithDelay();
        }
    }

    private void toggleCombatWithDelay() {
        Timer delay = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                view.toggleCombat();
            }
        });
        delay.setRepeats(false);
        delay.start();
    }
}

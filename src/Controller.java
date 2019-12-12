import javax.swing.*;
import java.awt.event.*;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
        view.overworldPanel.playerList = model.getPlayerList();
        view.gamePanel.playerHealth = view.overworldPanel.player.health;
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

    private void updateCombat() {
        view.gamePanel.playerHealth = model.player.health;
        view.gamePanel.enemyHealth = model.enemy.health;
        view.overworldPanel.player.health = model.player.health;
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

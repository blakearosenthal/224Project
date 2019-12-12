import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);

        if (!view.isCombat) {
            view.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent keyEvent) {

                }

                @Override
                public void keyPressed(KeyEvent keyEvent) {
                    switch (keyEvent.getKeyCode()) {
                        case KeyEvent.VK_RIGHT:
                            if (!(view.overworldPanel.playerX + 64 > view.overworldPanel.width)) {
                                view.overworldPanel.playerX += 5;
                            }
                            break;
                        case KeyEvent.VK_LEFT:
                            if (!(view.overworldPanel.playerX - 14 < 0)) {
                                view.overworldPanel.playerX -= 5;
                            }
                            break;
                        case KeyEvent.VK_UP:
                            if (!(view.overworldPanel.playerY - 14 < 0)) {
                                view.overworldPanel.playerY -= 5;
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            if (!(view.overworldPanel.playerY + 114 > view.overworldPanel.height)) {
                                view.overworldPanel.playerY += 5;
                            }
                            break;
                    }
                }

                @Override
                public void keyReleased(KeyEvent keyEvent) {

                }
            });
        } else {
            view.optionsPanel.fightButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int previousPlayerHealth = model.player.health;
                    int previousEnemyHealth = model.enemy.health;
                    model.attack();
                    int postPlayerHealth = model.player.health;
                    int postEnemyHealth = model.enemy.health;
                    view.optionsPanel.statusText.setText("Your Attack did " +
                            (previousEnemyHealth - postEnemyHealth) + " damage! You also took " +
                            (previousPlayerHealth - postPlayerHealth) + " damage!");
                    updateCombat();
                }
            });

            view.optionsPanel.buffButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    model.buff();
                    view.optionsPanel.statusText.setText("Attack power increased by 1!");
                    updateCombat();
                }
            });

            view.optionsPanel.healButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    model.heal();
                    view.optionsPanel.statusText.setText("Healed for " +  model.player.heal + " health point(s)!");
                    updateCombat();
                }
            });

            view.optionsPanel.runButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("RUN");
                    if (model.run()) {
                        view.isCombat = !view.isCombat;
                    }
                }
            });
        }
    }

    private void updateCombat() {
        view.gamePanel.playerHealth = model.player.health;
        view.gamePanel.enemyHealth = model.enemy.health;
        if (model.player.health <= 0) {
            view.optionsPanel.statusText.setText("You died!");
        } else if (model.enemy.health <= 0) {
            view.optionsPanel.statusText.setText("The enemy has been defeated!");
        }
    }
}

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

        view.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        System.out.println("RIGHT");
                        if (!(view.overworldPanel.playerX + 64 > view.overworldPanel.width)) {
                            view.overworldPanel.playerX += 5;
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("LEFT");
                        if (!(view.overworldPanel.playerX - 14 < 0)) {
                            view.overworldPanel.playerX -= 5;
                        }
                        break;
                    case KeyEvent.VK_UP:
                        System.out.println("UP");
                        if (!(view.overworldPanel.playerY - 14 < 0)) {
                            view.overworldPanel.playerY -= 5;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        System.out.println("DOWN");
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

//        view.fightButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println("FIGHT");
//            }
//        });
//
//        view.shieldButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println("SHIELD");
//            }
//        });
//
//        view.healButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println("HEAL");
//            }
//        });
//
//        view.runButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println("RUN");
//            }
//        });
    }
}

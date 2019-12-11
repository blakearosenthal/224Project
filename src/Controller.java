import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);

//        view.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent keyEvent) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent keyEvent) {
//                switch (keyEvent.getKeyCode()) {
//                    case KeyEvent.VK_RIGHT:
//                        if (!(view.overworldPanel.playerX + 64 > view.overworldPanel.width)) {
//                            view.overworldPanel.playerX += 5;
//                        }
//                        break;
//                    case KeyEvent.VK_LEFT:
//                        if (!(view.overworldPanel.playerX - 14 < 0)) {
//                            view.overworldPanel.playerX -= 5;
//                        }
//                        break;
//                    case KeyEvent.VK_UP:
//                        if (!(view.overworldPanel.playerY - 14 < 0)) {
//                            view.overworldPanel.playerY -= 5;
//                        }
//                        break;
//                    case KeyEvent.VK_DOWN:
//                        if (!(view.overworldPanel.playerY + 114 > view.overworldPanel.height)) {
//                            view.overworldPanel.playerY += 5;
//                        }
//                        break;
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent keyEvent) {
//
//            }
//        });

        view.fightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("FIGHT");
                model.attack();
            }
        });

        view.buffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("BUFF");
                model.buff();
            }
        });

        view.healButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("HEAL");
                model.heal();
            }
        });

        view.runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("RUN");
                model.run();
            }
        });
    }
}

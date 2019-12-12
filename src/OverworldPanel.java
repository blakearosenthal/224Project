import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class OverworldPanel extends JPanel implements PresetColors {
    static final int DELAY = 10;
    protected List<Character> playerList;
    protected Character player;
    protected Character enemy;
    protected int width;
    protected int height;
    private Controller controller;
    private Timer timer;

    public OverworldPanel(Controller c) {
        controller = c;
        player = controller.getPlayerCharacter();
        enemy = controller.getEnemyCharacter();
        playerList = new ArrayList<>();
        setBackground(gray);
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Character aPlayer : playerList) {
            player = aPlayer;
        }

        Graphics2D g2 = (Graphics2D) g;
        Dimension panelDim = this.getSize();
        width = panelDim.width;
        height = panelDim.height;

        g2.setColor(white);
        g2.setStroke(new BasicStroke(25));
        g2.draw(new Rectangle2D.Double(0, 0, width, height));

        g2.setColor(green);
        g2.fill(new Ellipse2D.Double(player.getX(), player.getY(), 50, 50));

        g2.setColor(red);
        g2.fill(new Ellipse2D.Double(enemy.getX(), enemy.getY(), 50, 50));
    }
}

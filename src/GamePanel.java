import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;

public class GamePanel extends JPanel implements PresetColors {
    static final int DELAY = 10;
    Timer timer;
    int playerHealth;
    int enemyHealth = 25;
    public Controller controller;
    public GamePanel(Controller controller) {
        this.controller = controller;
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

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(navy);
        g2.setStroke(new BasicStroke(5));

        // PLAYER UI
        playerHealth = controller.getPlayerHealth();
        playerUI(g2);

        // ENEMY UI
        enemyUI(g2);

        // PLAYER AVATAR
        player(g2);

        // ENEMY AVATAR
        enemy(g2);
    }

    private void playerUI(Graphics2D g2) {
        int width = 350;
        int height = 150;
        int x = 794 - width;
        int y = 585 - height;
        int r = 25;

        // PLAYER UI BOX
        g2.setColor(navy);
        g2.fill(new RoundRectangle2D.Double(x, y, width, height, r, r));
        g2.setColor(white);
        g2.fill(new RoundRectangle2D.Double(x + 5, y + 5, width - 10, height - 10, r, r));

        // HEALTH BAR
        g2.setColor(navy);
        g2.fill(new RoundRectangle2D.Double(x + 25, y + 55, width - 50, height - 100, r, r));
        g2.setColor(green);
        int healthBarWidth = ((width - 60) / 24 ) * (playerHealth - 1);
        g2.fill(new RoundRectangle2D.Double(x + 30, y + 60, healthBarWidth, height - 110, r, r));

        // PLAYER LABEL
        g2.setColor(navy);
        g2.setFont(new Font("Default", Font.BOLD, 25));
        g2.drawString("PLAYER", x + 40, y + 40);

        // HEALTH LABEL
        g2.setFont(new Font("Default", Font.BOLD, 20));
        g2.drawString(playerHealth + " / 25", x + 40, y + 130);
    }

    private void enemyUI(Graphics2D g2) {
        int width = 350;
        int height = 150;
        int x = 0;
        int y = 0;
        int r = 25;

        // PLAYER UI BOX
        g2.setColor(navy);
        g2.fill(new RoundRectangle2D.Double(x, y, width, height, r, r));
        g2.setColor(white);
        g2.fill(new RoundRectangle2D.Double(x + 5, y + 5, width - 10, height - 10, r, r));

        // HEALTH BAR
        g2.setColor(navy);
        g2.fill(new RoundRectangle2D.Double(x + 25, y + 55, width - 50, height - 100, r, r));
        g2.setColor(green);
        int healthBarWidth = ((width - 60) / 24 ) * (enemyHealth - 1);
        g2.fill(new RoundRectangle2D.Double(x + 30, y + 60, healthBarWidth, height - 110, r, r));

        // PLAYER LABEL
        g2.setColor(navy);
        g2.setFont(new Font("Default", Font.BOLD, 25));
        g2.drawString("ENEMY", x + 40, y + 40);

        // HEALTH LABEL
        g2.setFont(new Font("Default", Font.BOLD, 20));
        g2.drawString(enemyHealth + " / 25", x + 40, y + 130);
    }

    private void player(Graphics2D g2) {
        int width = 100;
        int height = 100;
        int x = 100;
        int y = 350;

        g2.setColor(white);
        g2.fill(new Ellipse2D.Double(x, y, width, height));
        g2.setColor(Color.BLACK);
        g2.draw(new Ellipse2D.Double(x, y, width, height)); // head
        g2.draw(new Line2D.Double(x + 40, y + 20, x + 40, y + 50)); // left-eye
        g2.draw(new Line2D.Double(x + 60, y + 20, x + 60, y + 50)); // right-eye
        g2.draw(new Ellipse2D.Double(x + 40, y + 70, 25, 12)); // mouth
        g2.draw(new Line2D.Double(x + 50, y + 100, x + 50, y + 175)); // body
        g2.draw(new Line2D.Double(x + 50, y + 120, x + 75, y + 110)); // right-arm
        g2.draw(new Line2D.Double(x + 50, y + 120, x + 25, y + 110)); // left-arm
        g2.draw(new Line2D.Double(x + 50, y + 175, x + 65, y + 205)); // right-leg
        g2.draw(new Line2D.Double(x + 50, y + 175, x + 35, y + 205)); // leg-leg
    }

    private void enemy(Graphics2D g2) {
        int width = 100;
        int height = 100;
        int x = 500;
        int y = 50;

        g2.setColor(red);
        g2.fill(new Ellipse2D.Double(x, y, width, height));
        g2.setColor(Color.BLACK);
        g2.draw(new Ellipse2D.Double(x, y, width, height)); // head
        g2.draw(new Line2D.Double(x + 40, y + 20, x + 40, y + 50)); // left-eye
        g2.draw(new Line2D.Double(x + 60, y + 20, x + 60, y + 50)); // right-eye
        g2.draw(new Ellipse2D.Double(x + 40, y + 70, 25, 12)); // mouth
        g2.draw(new Line2D.Double(x + 50, y + 100, x + 50, y + 175)); // body
        g2.draw(new Line2D.Double(x + 50, y + 120, x + 75, y + 110)); // right-arm
        g2.draw(new Line2D.Double(x + 50, y + 120, x + 25, y + 110)); // left-arm
        g2.draw(new Line2D.Double(x + 50, y + 175, x + 65, y + 205)); // right-leg
        g2.draw(new Line2D.Double(x + 50, y + 175, x + 35, y + 205)); // leg-leg
    }
}

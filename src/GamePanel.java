import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class GamePanel extends JPanel {
    static final int DELAY = 10;
    Timer timer;

    public GamePanel() {
        setBackground(Color.DARK_GRAY);
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

        g2.setColor(Color.BLACK); // sets Color
        g2.setStroke(new BasicStroke(5)); // set stroke size


        // PLAYER UI
        playerUI(g2);

        // ENEMY UI
        enemyUI(g2);

        // PLAYER AVATAR
        player(g2);

//        g2.fill(new Rectangle2D.Double(200, 200, 400, 200));
//        g2.fill(new Ellipse2D.Double(100, 100, 10, 10));
//        g2.draw(new Line2D.Double(10, 10, 50, 50));
    }

    private void playerUI(Graphics2D g2) {
        Dimension panelDim = this.getSize();
        int width = panelDim.width / 9 * 4;
        int height = panelDim.height / 4;
        int x = panelDim.width - width;
        int y = panelDim.height - height;
        int r = 25;

        g2.setColor(Color.BLACK);
        g2.fill(new RoundRectangle2D.Double(x, y, width, height, r, r));

        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Double(x + 5, y + 5, width - 10, height - 10, r, r));

        g2.setColor(Color.BLACK);
        g2.fill(new RoundRectangle2D.Double(x + 25, y + 75, width - 50, height - 100, r, r));

        g2.setColor(Color.GREEN);
        g2.fill(new RoundRectangle2D.Double(x + 30, y + 80, width - 60, height - 110, r, r));

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Default", Font.BOLD, 36));
        g2.drawString("PLAYER", x + 40, y + 50);

        g2.setFont(new Font("Default", Font.BOLD, 24));
        g2.drawString("25 / 25", x + 100, y + 100);
    }

    private void enemyUI(Graphics2D g2) {
        Dimension panelDim = this.getSize();
        int width = panelDim.width / 9 * 4;
        int height = panelDim.height / 4;
        int x = 0;
        int y = 0;
        int r = 25;

        g2.setColor(Color.BLACK);
        g2.fill(new RoundRectangle2D.Double(x, y, width, height, r, r));

        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Double(x + 5, y + 5, width - 10, height - 10, r, r));
    }

    private void player(Graphics2D g2) {
        Dimension panelDim = this.getSize();
        int width = 100;
        int height = 100;
        int x = panelDim.width / 10;
        int y = panelDim.height / 10  * 8;

        g2.setColor(Color.BLACK);
        g2.draw(new Ellipse2D.Double(x, y, width, height));
    }
}

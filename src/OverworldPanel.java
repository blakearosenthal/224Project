import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class OverworldPanel extends JPanel {
    static final int DELAY = 10;
    static final Color navy = Color.decode("#232931");
    static final Color gray = Color.decode("#393e46");
    static final Color green = Color.decode("#4ecca3");
    static final Color white = Color.decode("#eeeeee");
    protected int playerX = 200;
    protected int playerY = 200;
    protected int width;
    protected int height;
    Timer timer;

    public OverworldPanel() {
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
        Dimension panelDim = this.getSize();
        width = panelDim.width;
        height = panelDim.height;

        g2.setColor(white);
        g2.setStroke(new BasicStroke(25));
        g2.draw(new Rectangle2D.Double(0, 0, width, height));

        g2.setColor(green);
        g2.fill(new Rectangle2D.Double(playerX, playerY, 50, 100));
    }
}

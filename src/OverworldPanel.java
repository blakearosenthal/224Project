import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class OverworldPanel extends JPanel implements PresetColors {
    static final int DELAY = 10;
    protected Player player;
    protected int width;
    protected int height;
    Timer timer;

    public OverworldPanel() {
        player = new Player();
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
        g2.fill(new Rectangle2D.Double(player.x, player.y, 50, 100));
    }
}

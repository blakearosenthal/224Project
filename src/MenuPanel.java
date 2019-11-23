import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    JLabel title;
    JButton start;
    JButton stats;
    JButton quit;
    JButton settings;

    public MenuPanel() {
        setBackground(Color.BLACK);

        title = new JLabel("Dungeon Game");
        title.setFont(new Font("Courier New", Font.PLAIN, 75));
        title.setForeground(Color.white);
        add(title);
    }
}

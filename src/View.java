import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Controller controller;

    public View(Controller controller) {
        super("Dungeon Game");
        this.controller = controller;

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(900, 800));
        getContentPane().add(new MenuPanel());
        pack();
    }
}

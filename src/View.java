import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Controller controller;
    protected boolean isCombat = true;
    protected OverworldPanel overworldPanel;
    protected GamePanel gamePanel;
    protected OptionsPanel optionsPanel;

    public View(Controller controller) {
        super("Dungeon Game");
        this.controller = controller;
        overworldPanel = new OverworldPanel();
        gamePanel = new GamePanel();
        optionsPanel = new OptionsPanel();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 700));
        setResizable(false);
        setupUI();
        pack();
        setLocationRelativeTo(null);
    }

    private void setupUI() {
        if (isCombat) {
            getContentPane().add(gamePanel, BorderLayout.CENTER);
            getContentPane().add(optionsPanel, BorderLayout.SOUTH);
        } else {
            getContentPane().add(overworldPanel, BorderLayout.CENTER);
        }
    }
}

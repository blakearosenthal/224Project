import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class View extends JFrame {
    private Controller controller;
    protected JButton fightButton;
    protected JButton shieldButton;
    protected JButton healButton;
    protected JButton runButton;

    public View(Controller controller) {
        super("Dungeon Game");
        this.controller = controller;

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 700));
        setupUI();
        pack();
        setLocationRelativeTo(null);
    }

    private void setupUI() {
//        getContentPane().add(new MenuPanel(), BorderLayout.CENTER);
        getContentPane().add(new GamePanel(), BorderLayout.CENTER);
        setupBattleUI();
    }

    private void setupBattleUI() {
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setBackground(Color.WHITE);

        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
        optionsPanel.setBorder(compound);

        optionsPanel.add(statusPanel());
        optionsPanel.add(battleOptionsPanel());

        getContentPane().add(optionsPanel, BorderLayout.SOUTH);
    }

    private JPanel battleOptionsPanel() {
        JPanel battleOptionsPanel = new JPanel();
        battleOptionsPanel.setLayout(new GridLayout(0,2));

        fightButton = new JButton("FIGHT");
        fightButton.setBackground(Color.WHITE);
        battleOptionsPanel.add(fightButton);

        shieldButton = new JButton("SHIELD");
        shieldButton.setBackground(Color.WHITE);
        battleOptionsPanel.add(shieldButton);

        healButton = new JButton("HEAL");
        healButton.setBackground(Color.WHITE);
        battleOptionsPanel.add(healButton);

        runButton = new JButton("RUN");
        runButton.setBackground(Color.WHITE);
        battleOptionsPanel.add(runButton);

        return battleOptionsPanel;
    }

    private JPanel statusPanel() {
        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(Color.WHITE);

        JLabel infoText = new JLabel("WHAT WILL YOU DO?");
        statusPanel.add(infoText);

        return statusPanel;
    }
}

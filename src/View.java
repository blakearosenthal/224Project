import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Controller controller;
    private boolean isCombat = false;
    protected OptionsPanel optionsPanel;
    protected GamePanel gamePanel;

    // CardLayout variables
    JPanel cards;
    protected OverworldPanel overworldPanel;
    protected JPanel combatPanel;
    final static String COMBATPANEL = "Card for Combat";
    final static String OVERWORLDPANEL = "Card for Dungeon Crawling";

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

        // replaces setupUI
        addComponentToPane(getContentPane());
        overworldPanel.requestFocusInWindow();

        pack();
        setLocationRelativeTo(null);

    }

    public void addComponentToPane(Container pane) {

        //Create the "cards".
        combatPanel = new JPanel();
        combatPanel.setLayout(new BorderLayout());
        combatPanel.add(gamePanel, BorderLayout.CENTER);
        combatPanel.add(optionsPanel, BorderLayout.SOUTH);

        overworldPanel = new OverworldPanel();

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(overworldPanel, OVERWORLDPANEL);
        cards.add(combatPanel, COMBATPANEL);

        // pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    private void toggleCombatScreen() {
        CardLayout cl = (CardLayout)(cards.getLayout());
        if(isCombat) {
            cl.show(cards, COMBATPANEL);
            combatPanel.requestFocusInWindow();
        } else {
            cl.show(cards, OVERWORLDPANEL);
            overworldPanel.requestFocusInWindow();
        }
    }

    public void toggleCombat() {
        isCombat = !isCombat;
        toggleCombatScreen();
    }
}

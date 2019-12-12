import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class View extends JFrame implements ItemListener {
    private Controller controller;
    JPanel cards; //a panel that uses CardLayout
    protected JPanel combatPanel;
    protected OverworldPanel overworldPanel;
    final static String COMBATPANEL = "Card for Combat";
    final static String OVERWORLDPANEL = "Card for Dungeon Crawling";
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

    public void toggleCombatScreen() {
        CardLayout cl = (CardLayout)(cards.getLayout());
        if(controller.isInCombat()) {
            cl.show(cards, COMBATPANEL);
            combatPanel.requestFocusInWindow();
        } else {
            cl.show(cards, OVERWORLDPANEL);
            overworldPanel.requestFocusInWindow();
        }
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    private void setupUI() {
        // getContentPane().add(new MenuPanel(), BorderLayout.CENTER);
        /*
        if(controller.isInCombat()) {
            getContentPane().add(new GamePanel(), BorderLayout.CENTER);
            setupBattleUI();
        } else {
            overworldPanel = new OverworldPanel();
            getContentPane().add(overworldPanel, BorderLayout.CENTER);
        }
        */
        addComponentToPane(getContentPane());
        overworldPanel.requestFocusInWindow();
    }
    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = {  OVERWORLDPANEL, COMBATPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        //Create the "cards".
        combatPanel = new JPanel();
        combatPanel.setLayout(new BorderLayout());
        combatPanel.add(new GamePanel(), BorderLayout.CENTER);
        setupBattleUI();

        overworldPanel = new OverworldPanel();

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(overworldPanel, OVERWORLDPANEL);
        cards.add(combatPanel, COMBATPANEL);

        // pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
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

        combatPanel.add(optionsPanel, BorderLayout.SOUTH);
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

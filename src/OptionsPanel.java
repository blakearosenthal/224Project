import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OptionsPanel extends JPanel implements presetColors {
    JButton fightButton;
    JButton buffButton;
    JButton healButton;
    JButton runButton;
    JLabel statusText;

    public OptionsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(white);

        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);

        setBorder(compound);
        add(statusPanel());
        add(battleOptionsPanel());
    }

    private JPanel battleOptionsPanel() {
        JPanel battleOptionsPanel = new JPanel();
        battleOptionsPanel.setLayout(new GridLayout(0,2));

        fightButton = new JButton("FIGHT");
        fightButton.setBackground(white);
        battleOptionsPanel.add(fightButton);

        buffButton = new JButton("BUFF");
        buffButton.setBackground(white);
        battleOptionsPanel.add(buffButton);

        healButton = new JButton("HEAL");
        healButton.setBackground(white);
        battleOptionsPanel.add(healButton);

        runButton = new JButton("RUN");
        runButton.setBackground(white);
        battleOptionsPanel.add(runButton);

        return battleOptionsPanel;
    }

    private JPanel statusPanel() {
        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(white);

        statusText = new JLabel("WHAT WILL YOU DO?");
        statusPanel.add(statusText);

        return statusPanel;
    }
}

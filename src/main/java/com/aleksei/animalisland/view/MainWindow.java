package com.aleksei.animalisland.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

    private JLabel infoLabel;
    private JPanel rootPanel;
    private JPanel managementPanel;
    private JPanel creaturePanel;
    private JButton restartButton;
    private JButton stopStartButton;
    private JButton updateButton;
    private ButtonGroup bGroup;
    private JToggleButton femaleBoarLabel;
    private JToggleButton maleBoarLabel;
    private JToggleButton femaleBearLabel;
    private JToggleButton maleBearLabel;
    private FieldVisualizationPanel fieldPanel;

    public MainWindow() throws HeadlessException {
        super("Siberian Forest");
    }

    public void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.PAGE_AXIS));
        rootPanel.setBackground(Color.WHITE);

        managementPanel = new JPanel();
        managementPanel.setBackground(Color.WHITE);
        managementPanel.setLayout(new GridBagLayout());

        stopStartButton = styled(new JButton("Stop/Start"));
        stopStartButton.addActionListener(e -> fieldPanel.stopOrResume());
        updateButton = styled(new JButton("Turn"));
        updateButton.addActionListener(e -> fieldPanel.updateGame());
        restartButton = styled(new JButton("Restart"));
        restartButton.addActionListener(e -> fieldPanel.init());

        managementPanel.add(stopStartButton, gbc(0, 0));
        managementPanel.add(updateButton, gbc(1, 0));
        managementPanel.add(restartButton, gbc(2, 0));

        fieldPanel = new FieldVisualizationPanel();
        fieldPanel.setBackground(Color.WHITE);
        fieldPanel.setInfoConsumer(info -> infoLabel.setText(info));

        fieldPanel.init();
        initMouseListener(fieldPanel);

        creaturePanel = new JPanel();
        creaturePanel.setLayout(new GridBagLayout());
        femaleBoarLabel = styled(new JToggleButton("F", new ImageIcon(BoarDrawer.IMG)));
        maleBoarLabel = styled(new JToggleButton("M", new ImageIcon(BoarDrawer.IMG)));
        femaleBearLabel = styled(new JToggleButton("F", new ImageIcon(BearDrawer.IMG)));
        maleBearLabel = styled(new JToggleButton("M", new ImageIcon(BearDrawer.IMG)));
        bGroup = new ButtonGroup();
        bGroup.add(femaleBoarLabel);
        bGroup.add(maleBoarLabel);
        bGroup.add(femaleBearLabel);
        bGroup.add(maleBearLabel);
        creaturePanel.add(femaleBoarLabel, gbc(0, 0));
        creaturePanel.add(maleBoarLabel, gbc(1, 0));
        creaturePanel.add(femaleBearLabel, gbc(2, 0));
        creaturePanel.add(maleBearLabel, gbc(3, 0));

        infoLabel = new JLabel("Info");
        infoLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        rootPanel.add(managementPanel, BorderLayout.CENTER);
        rootPanel.add(fieldPanel, BorderLayout.CENTER);
        rootPanel.add(creaturePanel, BorderLayout.CENTER);
        rootPanel.add(infoLabel, BorderLayout.EAST);

        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void initMouseListener(FieldVisualizationPanel panel) {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (femaleBoarLabel.isSelected()) {
                        panel.putBoarOn(e.getPoint(), new BoarExample(Boar.ADULT, Sex.FEMALE));
                    } else if (maleBoarLabel.isSelected()) {
                        panel.putBoarOn(e.getPoint(), new BoarExample(Boar.ADULT, Sex.MALE));
                    } else if (femaleBearLabel.isSelected()) {
                        panel.putBearOn(e.getPoint(), new BearExample(Bear.ADULT, Sex.FEMALE));
                    } else if (maleBearLabel.isSelected()) {
                        panel.putBearOn(e.getPoint(), new BearExample(Bear.ADULT, Sex.MALE));
                    }
                    if (!e.isShiftDown()) {
                        bGroup.clearSelection();
                    }
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    panel.showInfoAbout(e.getPoint());
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                fieldPanel.highlightAim(e.getPoint());
            }
        };
        panel.addMouseListener(mouseAdapter);
        panel.addMouseMotionListener(mouseAdapter);
    }

    private GridBagConstraints gbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 2, 2, 2);
        return gbc;
    }

    private <T extends AbstractButton> T styled(T button) {
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        button.setBorder(compound);
        button.setMinimumSize(new Dimension(100, 30));
        return button;
    }
}

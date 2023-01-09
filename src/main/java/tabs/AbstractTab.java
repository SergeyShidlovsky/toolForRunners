package tabs;

import runner.TimerTickListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTab extends JPanel {

    protected KeyListener listener;
    protected JLabel tabStatusLabel;
    protected Map<Integer, JButton> buttonAssignment;

    public AbstractTab(){
        //Add empty Map of buttons assignment
        buttonAssignment = new HashMap<>();
    }

    //Adding method for reset timer with new value
    // after buttons below have been pressed
    protected void timeReset(int seconds, TimerTickListener tm) {
        tm.getTimer().stop();     //Stopping previous timer before execution of current script
        tm.setCountdown(seconds);
        tm.getTimer().start();    //Starting timer after script initiation
    }

    protected void addActionListenerToButton(JButton button, String command, TimerTickListener tm, int delay) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //Button will perform next actions
                if (ae.getSource() == button) {
                    try {
                        Runtime.getRuntime().exec(command);
                        timeReset(delay, tm);
                    } catch (Exception r) {
                        tm.showError();
                    }
                }
            }
        });
    }

    protected void addButtonWithPreferencesToTab(JButton button, String tooltip, Font font, int keyCode) {
        button.setFont(font);
        button.setVisible(true);
        button.setToolTipText(tooltip);
        button.setSize(313, 110);
        add(button);
        buttonAssignment.put(keyCode, button);
    }

    protected KeyListener addKeyListenerToTab() {

        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Integer currentAssignmentCode;
                for (int i = 0; i < buttonAssignment.values().size(); i++) {
                    currentAssignmentCode = (Integer) buttonAssignment.keySet().toArray()[i];
                    if (e.getKeyCode() == currentAssignmentCode) {
                        buttonAssignment.get(currentAssignmentCode).doClick();
                    }
                }
            }
        };
    }
}

package tabs;

import linkenums.LinksExecute;
import runner.TimerTickListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Execute extends AbstractTab {

    final JButton button1;
    final JButton button2;
    final JButton button3;
    final JButton button4;
    final JButton button5;
    final JButton button6;
    final JButton button7;
    final JButton button8;

    public Execute(TimerTickListener tm, Font font, List<JLabel> statusLabelList) {

        //Create list of buttons
        button1 = new JButton(" Application wizard [1] ");
        button2 = new JButton(" Audio Settings [2] ");
        button3 = new JButton(" Device Manager [3] ");
        button4 = new JButton(" Device and Printers [4] ");
        button5 = new JButton(" Device Metadata [5] ");
        button6 = new JButton(" Remote Desktop [6] ");
        button7 = new JButton(" Task Manager [7] ");
        button8 = new JButton(" Update Server [8] ");

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1, "Open Application wizard", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2, "Open Audio Settings", font, KeyEvent.VK_2);
        addButtonWithPreferencesToTab(button3, "Open Device Manager", font, KeyEvent.VK_3);
        addButtonWithPreferencesToTab(button4, "Open Device and Printers", font, KeyEvent.VK_4);
        addButtonWithPreferencesToTab(button5, "Open Device Metadata", font, KeyEvent.VK_5);
        addButtonWithPreferencesToTab(button6, "Open RDP Connections", font, KeyEvent.VK_6);
        addButtonWithPreferencesToTab(button7, "Open Device Manager", font, KeyEvent.VK_7);
        addButtonWithPreferencesToTab(button8, "Open Update server", font, KeyEvent.VK_8);

        //Add ActionListener to all buttons
        addActionListenerToButton(button1, LinksExecute.OPEN_APPLICATION_WIZARD.getValue(), tm, 2);
        addActionListenerToButton(button2, LinksExecute.OPEN_AUDIO_SETTINGS.getValue(), tm, 2);
        addActionListenerToButton(button3, LinksExecute.OPEN_DEVICE_MANAGER.getValue(), tm, 2);
        addActionListenerToButton(button4, LinksExecute.OPEN_DEVICE_AND_PRINTERS.getValue(), tm, 2);
        addActionListenerToButton(button5, LinksExecute.OPEN_DEVICE_METADATA.getValue(), tm, 2);
        addActionListenerToButton(button6, LinksExecute.OPEN_DPR_CONNECTION.getValue(), tm, 2);
        addActionListenerToButton(button7, LinksExecute.OPEN_TASK_MANAGER.getValue(), tm, 2);
        addActionListenerToButton(button8, LinksExecute.OPEN_UPDATE_SERVICE.getValue(), tm, 2);

        //Create tab-specific KeyListener
        listener = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        buttonAssignment.values().forEach(button -> button.addKeyListener(listener));

        //Add StatusLabel to tab
        tabStatusLabel = statusLabelList.get(3);
        add(tabStatusLabel);
    }
}

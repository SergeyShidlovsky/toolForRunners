package tabs;

import linkenums.LinksApplication;
import runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Application extends AbstractTab {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public Application(TimerTick tm, Font font, List<JLabel> statusLabelList) {

        //Create list of buttons
        button1 = new JButton("Restart With Cleared Appdata Programdata Restart Service [1]");
        button2 = new JButton("Restart With Cleared Appdata Programdata Restart Service With BackUp [2]");
        button3 = new JButton("Restart With Debug Logging And Cleared Appdata Programdata Restrt Service [3]");
        button4 = new JButton("Restart With Debug Logging And Cleared Appdata Programdata Restart Service With BackUp [4]");

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1, "Restart With Cleared Appdata Programdata Restart Service", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2, "Restart With Cleared Appdata Programdata Restart Service With BackUp", font, KeyEvent.VK_2);
        addButtonWithPreferencesToTab(button3, "Restart With Cleared Appdata Programdata Restart Service", font, KeyEvent.VK_3);
        addButtonWithPreferencesToTab(button4, "Restart With Cleared Appdata Programdata Restart Service", font, KeyEvent.VK_4);

        //Add ActionListeners on all buttons
        addActionListenerToButton(button1, LinksApplication
                .RESTART_WITH_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE
                .getValue(), tm, 1);
        addActionListenerToButton(button2, LinksApplication
                .RESTART_WITH_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE_WITH_BACK_UP
                .getValue(), tm, 1);
        addActionListenerToButton(button3, LinksApplication
                .RESTART_WITH_DEBUG_LOGGING_AND_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE
                .getValue(), tm, 1);
        addActionListenerToButton(button4, LinksApplication
                .RESTART_WITH_DEBUG_LOGGING_AND_CLEARED_APPDATA_PROGRAMMDATA_RESTART_SERVICE_WITH_BACK_UP
                .getValue(), tm, 1);

        //Add KeyListener to tab
        listener = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        buttonAssignment.values().forEach(button -> button.addKeyListener(listener));

        //Add StatusLabel to tab
        tabStatusLabel = statusLabelList.get(1);
        add(tabStatusLabel);
    }
}

package tabs;

import linkenums.LinksServices;
import runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Services extends AbstractTab {

    final JButton button1;
    final JButton button2;
    final JButton button3;
    final JButton button4;
    final JButton button5;

    public Services(TimerTick tm, Font font, List<JLabel> statusLabelList) {

        //Create list of buttons
        button1 = new JButton("Open Services [1]");
        button2 = new JButton("Start Audio Service [2]");
        button3 = new JButton("Start Integration Service [3]");
        button4 = new JButton("Stop Audio Service [4]");
        button5 = new JButton("Stop Integration Service [5]");

        //Add empty Map of buttons assignment
        buttonAssignment = new HashMap<Integer, JButton>();

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1, "Open Services window", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2, "Start Audio Service", font, KeyEvent.VK_2);
        addButtonWithPreferencesToTab(button3, "Start Integration Service", font, KeyEvent.VK_3);
        addButtonWithPreferencesToTab(button4, "Stop Audio Service", font, KeyEvent.VK_4);
        addButtonWithPreferencesToTab(button5, "Stop Integration Service", font, KeyEvent.VK_5);

        //Add ActionListeners on all buttons
        addActionListenerToButton(button1, LinksServices.OPEN_SERVICE.getValue(), tm, 2);
        addActionListenerToButton(button2, LinksServices.START_AUDIO_SERVICE.getValue(), tm, 3);
        addActionListenerToButton(button3, LinksServices.START_INTEGRATION_SERVICE.getValue(), tm, 4);
        addActionListenerToButton(button4, LinksServices.STOP_AUDIO_SERVICE.getValue(), tm, 3);
        addActionListenerToButton(button5, LinksServices.STOP_INTEGRATION_SERVICE.getValue(), tm, 5);

        //Create tab-specific KeyListener
        listener = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        buttonAssignment.values().forEach(button -> button.addKeyListener(listener));

        //Add StatusLabel to tab
        tabStatusLabel = statusLabelList.get(8);
        add(tabStatusLabel);
    }
}
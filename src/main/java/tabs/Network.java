package tabs;

import linkenums.LinksNetwork;
import runner.TimerTickListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;

public class Network extends AbstractTab {

    final JButton button1;
    final JButton button2;
    final JButton button3;


    public Network(TimerTickListener tm, Font font, List<JLabel> statusLabelList) {

        //Create list of buttons
        button1 = new JButton("DisableNetworkAdapter [1]");
        button2 = new JButton("EnableNetworkAdapter [2]");
        button3 = new JButton("OpenNetworkAdapter [3]");

        //Add empty Map of buttons assignment
        buttonAssignment = new HashMap<Integer, JButton>();

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1,"Disables active network adapter", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2,"Enables active network adapter", font, KeyEvent.VK_2);
        addButtonWithPreferencesToTab(button3,"Opens network adapter settings", font, KeyEvent.VK_3);

        //Add ActionListeners to all buttons
        addActionListenerToButton(button1, LinksNetwork.DISABLE_NETWORK_ADAPTER.getValue(), tm, 10);
        addActionListenerToButton(button2, LinksNetwork.ENABLE_NETWORK_ADAPTER.getValue(), tm, 10);
        addActionListenerToButton(button3, LinksNetwork.OPEN_NETWORK_ADAPTER.getValue(), tm, 2);

        //Create tab-specific KeyListener
        listener = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        buttonAssignment.values().forEach(button -> button.addKeyListener(listener));

        //Add StatusLabel to tab
        tabStatusLabel = statusLabelList.get(6);
        add(tabStatusLabel);
    }
}
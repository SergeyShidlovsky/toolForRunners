package tabs;

import linkenums.LinksInstallation;
import runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Installation extends AbstractTab {

    private JButton button1;
    private JButton button2;

    public Installation(TimerTick tm, Font font, List<JLabel> statusLabelList) {

        //Create list of buttons
        button1 = new JButton("GetInstallLog [1]");
        button2 = new JButton("GetOEMFiles [2]");

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1, "Copy setuoapi.dev.log to Desktop", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2, "Copy OEM files to Desktop", font, KeyEvent.VK_2);

        //Add ActionListeners on all buttons
        addActionListenerToButton(button1, LinksInstallation.GET_OEM_FILES.getValue(), tm, 2);
        addActionListenerToButton(button2, LinksInstallation.GET_INSTALL_LOG.getValue(), tm, 3);

        //Add KeyListener for Buttons' press emulation
        listener = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        buttonAssignment.values().forEach(button -> button.addKeyListener(listener));

        //Add StatusLabel to tab
        tabStatusLabel = statusLabelList.get(4);
        add(tabStatusLabel);
    }
}

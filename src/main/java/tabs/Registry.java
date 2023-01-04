package tabs;

import linkenums.LinkRegistry;
import runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Registry extends AbstractTab {

    final JButton button1;
    final JButton button2;
    final JButton button3;

    public Registry(TimerTick tm, Font font, List<JLabel> statusLabelList) {

        //Create list of buttons
        button1 = new JButton("OpenRegistryEditor [1]");
        button2 = new JButton("OpenRegistryEditorClinkPIDs [2]");
        button3 = new JButton("OpenRegistryEditorErrorReporting [3]");

        //Add empty Map of buttons assignment
        buttonAssignment = new HashMap<Integer, JButton>();

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1,"Opens Registry Editor", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2,"Open Registry Editor Clink PIDs", font, KeyEvent.VK_2);
        addButtonWithPreferencesToTab(button2,"Open Registry Editor Error Reporting", font, KeyEvent.VK_3);

        //Add ActionListeners to all Buttons
        addActionListenerToButton(button1, LinkRegistry.OPEN_REGISTRY_EDITOR.getValue(),tm,2);
        addActionListenerToButton(button2, LinkRegistry.OPEN_REGISTRY_EDITOR_CLINK_PIDS.getValue(), tm, 2);
        addActionListenerToButton(button3, LinkRegistry.OPEN_REGISTRY_EDITOR_ERROR_REPORTING.getValue(), tm, 2);

        //Create tab-specific KeyListener
        listener = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        buttonAssignment.values().forEach(button -> button.addKeyListener(listener));

        //Add StatusLabel to tab
        tabStatusLabel = statusLabelList.get(7);
        add(tabStatusLabel);
    }
}
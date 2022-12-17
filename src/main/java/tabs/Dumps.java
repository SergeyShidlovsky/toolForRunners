package tabs;

import linkenums.LinksDumps;
import runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Dumps extends AbstractTab{

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    public Dumps(TimerTick tm, Font font, List<JLabel> statusLabelList) {

        //Create list of buttons
        button1 = new JButton("Do Not Attach Last CUE Dump [1] ");
        button2 = new JButton("Get Last CUE Dump ZIP [2] ");
        button3 = new JButton("Get Manual CUE Dump ZIP [3] ");
        button4 = new JButton("Get Memory Dump [4] ");
        button5 = new JButton("Open Dump Folder [5] ");

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1, "Do Not Attach Last CUE Dump", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2, "Get Last CUE Dump ZIP", font, KeyEvent.VK_2);
        addButtonWithPreferencesToTab(button3, "Get Manual CUE Dump ZIP", font, KeyEvent.VK_3);
        addButtonWithPreferencesToTab(button4, "Get Memory Dump", font, KeyEvent.VK_4);
        addButtonWithPreferencesToTab(button5, "Open Dump Folder", font, KeyEvent.VK_5);

        //Add ActionListeners to all Buttons
        addActionListenerToButton(button1, LinksDumps.DO_NOT_ATTACH_GET_LAST_CUE_DUMP.getValue(),  tm, 2);
        addActionListenerToButton(button2, LinksDumps.GET_LAST_CUE_DUMP_ZIP.getValue(), tm, 2);
        addActionListenerToButton(button3, LinksDumps.GET_MANUAL_CUE_DUMP_ZIP.getValue(), tm, 2);
        addActionListenerToButton(button4, LinksDumps.GET_MEMORY_DUMP.getValue(), tm, 2);
        addActionListenerToButton(button5, LinksDumps.OPEN_DUMP_FOLDER.getValue(), tm, 2);

        //Create tab-specific KeyListener
        listener = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        buttonAssignment.values().forEach(button -> button.addKeyListener(listener));

        //Add StatusLabel to tab
        tabStatusLabel = statusLabelList.get(2);
        add(tabStatusLabel);
    }
}
package tabs;

import linkenums.LinksLinks;
import runner.TimerTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
public class Links extends AbstractTab {

    final JButton button1;
    final JButton button2;
    final JButton button3;
    final JButton button4;
    final JButton button5;
    final JButton button6;
    final JButton button7;
    final JButton button8;
    final JButton button9;
    final JButton button10;
    final JButton button11;
    final JButton button12;

    public Links(TimerTick tm, Font font, List<JLabel> statusLabelList) {

        //Create list of buttons
        button1 = new JButton("Firmware [1]");
        button2 = new JButton("Builder [2]");
        button3 = new JButton("Builds [3]");
        button4 = new JButton("DeviceDoc [4]");
        button5 = new JButton(" DocumentationCUE 2.0 [5] ");
        button6 = new JButton("DocumentationCUE 3.0 [6]");
        button7 = new JButton(" Phabricator [7] ");
        button8 = new JButton("PMArea [8]");
        button9 = new JButton(" Report [9] ");
        button10 = new JButton("  Squash [0]   ");
        button11 = new JButton(" Test machines [-]   ");
        button12 = new JButton("  Wiki QA [=]   ");

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1,"Open page with FW images", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2,"Open page with builder", font, KeyEvent.VK_2);
        addButtonWithPreferencesToTab(button3,"Open page with builds", font, KeyEvent.VK_3);
        addButtonWithPreferencesToTab(button4,"Open device documents page", font, KeyEvent.VK_4);
        addButtonWithPreferencesToTab(button5,"Open CUE 2.0 documentation page", font, KeyEvent.VK_5);
        addButtonWithPreferencesToTab(button6,"Open CUE 3.0 documentation page", font, KeyEvent.VK_6);
        addButtonWithPreferencesToTab(button7,"Open Phabricator page", font, KeyEvent.VK_7);
        addButtonWithPreferencesToTab(button8,"Open PMArea", font, KeyEvent.VK_8);
        addButtonWithPreferencesToTab(button9,"Open report page", font, KeyEvent.VK_9);
        addButtonWithPreferencesToTab(button10,"Open squash page", font, KeyEvent.VK_0);
        addButtonWithPreferencesToTab(button11,"Open page with stend machines list", font, KeyEvent.VK_MINUS);
        addButtonWithPreferencesToTab(button12,"Open QA Section of Project Wiki", font, KeyEvent.VK_EQUALS);

        //Add ActionListeners on all buttons
        addActionListenerToButton(button1, LinksLinks.FIRMWARE.getValue(), tm, 2);
        addActionListenerToButton(button2, LinksLinks.BUILDER.getValue(), tm, 2);
        addActionListenerToButton(button3, LinksLinks.BUILDS.getValue(), tm, 2);
        addActionListenerToButton(button4, LinksLinks.DEVICE_INFO.getValue(), tm, 2);
        addActionListenerToButton(button5, LinksLinks.DOCUMENTATION_CUE_2_0.getValue(), tm, 2);
        addActionListenerToButton(button6, LinksLinks.DOCUMENTATION_CUE_3_0.getValue(), tm, 2);
        addActionListenerToButton(button7, LinksLinks.PHABRICATOR.getValue(), tm, 2);
        addActionListenerToButton(button8, LinksLinks.PM_AREA.getValue(), tm, 2);
        addActionListenerToButton(button9, LinksLinks.REPORT.getValue(), tm, 2);
        addActionListenerToButton(button10, LinksLinks.SQUASH.getValue(), tm, 2);
        addActionListenerToButton(button11, LinksLinks.TEST_MACHINES.getValue(), tm, 2);
        addActionListenerToButton(button12, LinksLinks.WIKI_QA.getValue(), tm, 2);

        //Add KeyListener for Button press
        listener = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        buttonAssignment.values().forEach(button -> button.addKeyListener(listener));

        //Add StatusLabel to tab
        tabStatusLabel = statusLabelList.get(5);
        add(tabStatusLabel);
    }
}
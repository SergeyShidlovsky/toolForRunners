package tabs;

import linkenums.LinksAppDataLogs;
import runner.TimerTickListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.List;

public class AppDataLogs extends AbstractTab {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;

    public AppDataLogs(TimerTickListener tm, Font font, List<JLabel> statusLabelList) {

        //Create list of buttons
        button1 = new JButton("Clean Logs [1] ");
        button2 = new JButton("Clean ProgrammData [2] ");
        button3 = new JButton("Clear AppData [3] ");
        button4 = new JButton("Get Archive Appdata [4] ");
        button5 = new JButton("Get Archive ProgramData [5] ");
        button6 = new JButton("Get Last Archived Program AppData [6] ");
        button7 = new JButton("Get Last Log [7] ");
        button8 = new JButton("Open AppData [8] ");
        button9 = new JButton("Open Debug Service Folder [9] ");
        button10 = new JButton("Open Folder With Archived Program App Data [-] ");
        button11 = new JButton("Open Logs [=] ");
        button12 = new JButton("Open Program Data [q] ");

        //Add all buttons to tab
        addButtonWithPreferencesToTab(button1, "Clean Logs", font, KeyEvent.VK_1);
        addButtonWithPreferencesToTab(button2, "lean ProgrammData", font, KeyEvent.VK_2);
        addButtonWithPreferencesToTab(button3, "Clear AppData", font, KeyEvent.VK_3);
        addButtonWithPreferencesToTab(button4, "Get Archive Appdata", font, KeyEvent.VK_4);
        addButtonWithPreferencesToTab(button5, "Get Archive ProgramData", font, KeyEvent.VK_5);
        addButtonWithPreferencesToTab(button6, "Get Last Archived Program AppData", font, KeyEvent.VK_6);
        addButtonWithPreferencesToTab(button7, "et Last Log", font, KeyEvent.VK_7);
        addButtonWithPreferencesToTab(button8, "Open AppData", font, KeyEvent.VK_8);
        addButtonWithPreferencesToTab(button9, "Open Debug Service Folder", font, KeyEvent.VK_9);
        addButtonWithPreferencesToTab(button10, "Open Folder With Archived Program App Data", font, KeyEvent.VK_0);
        addButtonWithPreferencesToTab(button11, "Open Logs", font, KeyEvent.VK_MINUS);
        addButtonWithPreferencesToTab(button12, "Open Program Data", font, KeyEvent.VK_EQUALS);

        //Add ActionListeners to all buttons
        addActionListenerToButton(button1, LinksAppDataLogs.CLEAN_LOGS.getValue(), tm, 3);
        addActionListenerToButton(button2, LinksAppDataLogs.CLEAN_PROGRAMDATA.getValue(), tm, 3);
        addActionListenerToButton(button3, LinksAppDataLogs.CLEAR_APPDATA.getValue(), tm, 3);
        addActionListenerToButton(button4, LinksAppDataLogs.GET_ARCIVE_APPDATA.getValue(), tm, 3);
        addActionListenerToButton(button5, LinksAppDataLogs.GET_ARCHIVE_PROGRAMDATA.getValue(), tm, 3);
        addActionListenerToButton(button6, LinksAppDataLogs.GET_LAST_ARHIVED_PROGRAMDATA.getValue(), tm, 3);
        addActionListenerToButton(button7, LinksAppDataLogs.GET_LAST_LOG.getValue(), tm, 3);
        addActionListenerToButton(button8, LinksAppDataLogs.OPEN_APPDATA.getValue(), tm, 3);
        addActionListenerToButton(button9, LinksAppDataLogs.OPEN_DEBUG_SERVICE_FOLDER.getValue(), tm, 3);
        addActionListenerToButton(button10, LinksAppDataLogs.OPEN_FOLDER_WITH_ARCHIVED_PROGRAM_APPDATA.getValue(), tm, 3);
        addActionListenerToButton(button11, LinksAppDataLogs.OPEN_LOGS.getValue(), tm, 3);
        addActionListenerToButton(button12, LinksAppDataLogs.OPEN_PROGRAM_DATA.getValue(), tm, 3);

        //Add KeyListener for all Buttons' press emulation
        listener = addKeyListenerToTab();

        //Add key Listeners to all Buttons
        buttonAssignment.values().forEach(button -> button.addKeyListener(listener));

        //Add StatusLabel to tab
        tabStatusLabel = statusLabelList.get(0);
        add(tabStatusLabel);
    }
}

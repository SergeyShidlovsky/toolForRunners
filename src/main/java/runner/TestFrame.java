package runner;
import tabs.*;

import java.awt.*;
import java.util.List;

import javax.swing.*;

/**
 * Created by Sergey on 13.06.17.
 */

//See changelog.txt for qny questions

public class TestFrame extends JFrame {
    int quantity = 9;
    private Timer timer;
    private Font font;
    private Font labelFont;
    private List<JLabel> statusLabelList;
    private JTabbedPane tabbedPane;

    public TestFrame() {

        super("Tool For Runners");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Font of Buttons and Labels
        font = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 10);
        labelFont  = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 20);

        //Creating tabbed pane with font
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        //Creating an array of statusLabels
        statusLabelList = new JLabel[quantity];
        for (int i = 0; i < quantity; i++) {
            statusLabelList[i] = new JLabel("                      Start Script                      ");
            statusLabelList[i].setFont(labelFont);
            statusLabelList[i].setVisible(true);
            statusLabelList[i].setSize(313, 110);
            statusLabelList[i].setHorizontalAlignment(2);
            statusLabelList[i].setLocation(200, 200);
        }

        //Adding timer execution
        final TimerTick tm = new TimerTick();
        tm.setStatusLabelList(statusLabelList);

        //Adding Common timer to our tool,
        timer = new Timer(1000, tm);
        tm.setTimer(timer);

        //Adding all tabs to tabbed pane
        tabbedPane.addTab("AppDataLogs", new AppDataLogs(timer, tm, font, statusLabelList));
        tabbedPane.addTab("Application", new Application(timer, tm, font, statusLabelList));
        tabbedPane.addTab("Dumps", new Dumps(timer, tm, font, statusLabelList));
        tabbedPane.addTab("Execute", new Execute(timer, tm, font, statusLabelList));
        tabbedPane.addTab("Installation", new Installation(timer, tm, font, statusLabelList));
        tabbedPane.addTab("Links", new Links(timer, tm, font, statusLabelList));
        tabbedPane.addTab("Network", new Network(timer, tm, font, statusLabelList));
        tabbedPane.addTab("Registry", new Registry(timer, tm, font, statusLabelList));
        tabbedPane.addTab("Services", new Services(timer, tm, font, statusLabelList));

        //Adding tabbed pane to jFrame and Setting preferences
        setPreferredSize(new Dimension(655, 215));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        add(tabbedPane);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //JFrame.setDefaultLookAndFeelDecorated(true);
                new TestFrame();
            }
        });
    }
}

package runner;

import tabs.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sergey on 13.06.17.
 */

//See changelog.txt for qny questions

public class TestFrame extends JFrame {

    private Font font;
    private Timer timer;
    private int quantity;
    private Font labelFont;
    private JTabbedPane tabbedPane;
    private List<JLabel> statusLabelList;

    private static final String STATUS_LABEL_GAP = "                      ";


    public TestFrame() {

        super("Tool For Runners");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting quantity of tabs
        quantity = 9;

        //Font of Buttons and Labels
        font = new Font("Verdana", Font.PLAIN, 10);
        labelFont = new Font("Verdana", Font.PLAIN, 20);

        //Creating tabbed pane with font
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        //Creating an array of statusLabels
        statusLabelList = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            statusLabelList.add(new JLabel());
        }
        statusLabelList.forEach(label -> {
            label.setVisible(true);
            label.setFont(labelFont);
            label.setHorizontalAlignment(2);
            label.setLocation(200, 200);
            label.setSize(313, 110);
            label.setText(String.format("%sStart Script%s", STATUS_LABEL_GAP, STATUS_LABEL_GAP));
        });

        //Adding timer execution
        TimerTick tm = new TimerTick(statusLabelList);

        //Adding Common timer to our tool,
        timer = new Timer(1000, tm);
        tm.setTimer(timer);

        //Adding all tabs to tabbed pane
        tabbedPane.addTab("AppDataLogs", new AppDataLogs(timer, tm, font, statusLabelList));
        tabbedPane.addTab("Application", new Application(tm, font, statusLabelList));
        tabbedPane.addTab("Dumps", new Dumps(tm, font, statusLabelList));
        tabbedPane.addTab("Execute", new Execute(tm, font, statusLabelList));
        tabbedPane.addTab("Installation", new Installation(tm, font, statusLabelList));
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

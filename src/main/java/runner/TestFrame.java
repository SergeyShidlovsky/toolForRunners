package runner;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.ComponentListener;

        import javax.swing.*;

/**
 * Created by Sergey on 13.06.17.
 */
public class TestFrame extends JFrame {
    static int i = 0;

    public TestFrame() {

        super("Тестовое окно");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 10);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        class Exec1 extends JPanel{
            Exec1 () {
                JButton button1 = new JButton("Clear Appdata");
                button1.setFont(font);
                button1.setVisible(true);
                button1.setSize(313, 110);
                add(button1);

                JButton button2 = new JButton("Open Appdata");
                button2.setFont(font);
                button2.setVisible(true);
                button2.setSize(313, 110);
                add(button2);
            }

        }


        tabbedPane.addTab("*.bat exec",new Exec1(){
        });


        tabbedPane.addTab("Links",new Component() { //REFACTOR COMPONENT TO NESTED CLASS LINKS
            JButton button = new JButton();

        });



        tabbedPane.addTab("Articles",new Component(){

        });

        setPreferredSize(new Dimension(260, 220));
        pack();
        setLocationRelativeTo(null);
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


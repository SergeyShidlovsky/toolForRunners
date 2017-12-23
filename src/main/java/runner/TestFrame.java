package runner;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.OpenOption;

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

                //Configure visual settings of Button1
                JButton button1 = new JButton("Clear AppData");
                button1.setFont(font);
                button1.setVisible(true);
                button1.setSize(313, 110);
                add(button1);

                //Configure visual setting of Button2
                JButton button2 = new JButton("Open AppData");
                button2.setFont(font);
                button2.setVisible(true);
                button2.setSize(313, 110);
                add(button2);

                //Add ActionListeners of Button1
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button1 will perform next actions
                        // СМОТРИ СЮДА http://forum.sources.ru/index.php?showtopic=133192&view=showall
                    }
                });

                //Add KeyListener for Button1 press emulation by pressing Num1 button
                button1.addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent ke){

                    }
                });

                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Button2 will perform next actions

                    }
                });

            }
        }

        class Link2 extends JPanel{
            Link2 () {
                JButton button1 = new JButton("Open Squash");

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


        tabbedPane.addTab("Links",new Link2() { //REFACTOR COMPONENT TO NESTED CLASS LINKS
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
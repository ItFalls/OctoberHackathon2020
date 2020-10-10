import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final int DRAWING_WIDTH = 1000; //Width of Window
    public static final int DRAWING_HEIGHT = 750; //Height of Window
    private static final Color background = new Color(255, 255, 255);

    //Main Method
    public static void main(String[] args) {
        //Window
        JFrame window = new JFrame("Chart");
        window.setBounds(150, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
        window.setExtendedState(window.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.getContentPane().setLayout(new FlowLayout());
        JTextField textfield1 = new JTextField("Text field 1",10);
        JTextField textfield2 = new JTextField("Text field 2",10);
        JTextField textfield3 = new JTextField("Text field 3",10);
        window.getContentPane().add(textfield1);
        window.getContentPane().add(textfield2);
        window.getContentPane().add(textfield3);
        window.pack();
        window.setVisible(true);

        //Panel
        Runner panel = new Runner();
        panel.setBackground(background);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
        window.addKeyListener(panel);
        window.addMouseListener(panel);


        Runtime runtime = Runtime.getRuntime();
        System.out.print("What is your user folder's name?");
        String username = new Scanner(System.in).nextLine();
        String[] s = new String[] {"C:\\Users\\" + username + "\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe", "https://javaconceptoftheday.com/"};

        try
        {
            runtime.exec(s);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
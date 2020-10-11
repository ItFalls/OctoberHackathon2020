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
        //Runtime runtime = Runtime.getRuntime();
        //System.out.print("What is your user folder's name?");
        //String username = new Scanner(System.in).nextLine();
        //String[] s = new String[]{"C:\\Users\\" + username + "\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe", "https://javaconceptoftheday.com/"};

        //try {
        //    runtime.exec(s);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        //Window
        JFrame f = new JFrame("Chart");
        f.setBounds(150, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
        f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Panel
        Runner runner = new Runner();
        runner.setBackground(background);
        Container c = f.getContentPane();
        c.add(runner);
        f.setVisible(true);
        f.addKeyListener(runner);
        f.addMouseListener(runner);
    }
}
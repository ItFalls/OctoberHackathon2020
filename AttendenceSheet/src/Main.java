
import javax.swing.*;
import java.awt.*;

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

        //Panel
        Runner panel = new Runner();
        panel.setBackground(background);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
        window.addKeyListener(panel);
        window.addMouseListener(panel);
    }
}
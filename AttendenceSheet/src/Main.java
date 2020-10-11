import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Main {
    public static final int DRAWING_WIDTH = 700; //Width of Window
    public static final int DRAWING_HEIGHT = 750; //Height of Window
    private static final Color background = new Color(255, 255, 255);

    public static void main(String[] args) throws FileNotFoundException {
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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Runner extends JPanel implements ActionListener, KeyListener, MouseListener {
    private static final long serialVersionUID = 1L;

    // ==FIELDS==
    private final Font font = new Font("ComicSans", Font.PLAIN, 18);
    private JButton aButton = new JButton("a");
    private JButton bButton = new JButton("b");
    private JButton cButton = new JButton("c");


    ArrayList<Student> students;
    
    public Runner() {
        students = new ArrayList<Student>();
        /* Test Student
         * Student s = new Student(50, 50, "Bob Ross", 0);
         * students.add(s);
         */
    }

    //Paints everything
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.orange);
        g.fillRect((int) (getWidth() * 7.5 / 9), 0, (getWidth()), getHeight());
        g.setColor(Color.darkGray);
        g.setFont(font);

        this.add(aButton);
        this.add(bButton);
        this.add(cButton);
        aButton.setBounds(50 * getWidth() / 800, 9 * getHeight() / 10, 2 * getWidth() / 8, 6 * getHeight() / 80);
        aButton.setBackground(Color.WHITE);
        bButton.setBounds(310 * getWidth() / 800, 9 * getHeight() / 10, 2 * getWidth() / 8, 6 * getHeight() / 80);
        bButton.setBackground(Color.WHITE);
        cButton.setBounds(570 * getWidth() / 800, 9 * getHeight() / 10, 2 * getWidth() / 8, 6 * getHeight() / 80);
        cButton.setBackground(Color.WHITE);

        repaint();
    }


    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }


    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent arg) {
        if (arg.getKeyCode() == KeyEvent.VK_BACK_SPACE)
            if (students.size() > 0)
                students.remove(students.size() - 1);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent arg) {
    }

    @Override
    public void keyTyped(KeyEvent arg) {
        // TODO Auto-generated method stub
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
    	
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Runner extends JPanel implements ActionListener, KeyListener, MouseListener {
    private static final long serialVersionUID = 1L;

    // ==FIELDS==
    private final Font font = new Font("ComicSans", Font.PLAIN, 18);

    ArrayList<Student> students;

    public Runner() throws FileNotFoundException {
        students = new ArrayList<Student>();

        students.add(new Student(50, 50, "Bob Ross", 0));
        students.add(new Student(50, 110, "John Smith", 1));
        for (int x = 0; x < 20; x++) {
            if (students.size() < 14) {
                students.add(new Student(50, 50 + students.size() * 60, "student", 0));
            } else if (students.size() < 28) {
                students.add(new Student(560, 50 + students.size() % 14 * 60, "Student", 1));
            } else if (students.size() < 42) {
                students.add(new Student(1070, 50 + students.size() % 14 * 60, "Student", 2));
            }
        }
    }

    //Paints everything
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.darkGray);
        g.setFont(font);

        for (int i = 0; i < students.size(); i++) {
            students.get(i).draw(g);
        }
    }


    @Override
    public void mouseClicked(MouseEvent arg0) {
        for (int x = 0; x < students.size(); x++) {
            if (students.get(x).isIntersecting(getMousePosition().x, getMousePosition().y)) {
                if (students.get(x).getCalled())
                    students.get(x).call();
                else
                    students.get(x).changeStatus();
            }
        }
        repaint();
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
        if (arg.getKeyCode() == KeyEvent.VK_1) {
            for (int x = 0; x < students.size(); x++)
                if (!students.get(x).getCalled() && !students.get(x).getStatus().equals("Present") && !students.get(x).getStatus().equals("Tardy")) {
                    Random rand = new Random();
                    Student calledOn;
                    do {
                        calledOn = students.get(rand.nextInt(students.size()));
                    } while (!calledOn.getStatus().equals("Present") && !calledOn.getStatus().equals("Tardy"));
                    calledOn.call();
                    break;
                }
        }

        if (arg.getKeyCode() == KeyEvent.VK_0) {
            //order the students alphabetically
        }

        if (arg.getKeyCode() == KeyEvent.VK_SPACE) {

            Scanner sc = new Scanner(System.in);


            if (students.size() < 14) {
                System.out.print("Enter Student's Name: ");
                String name = sc.nextLine();
                students.add(new Student(50, 50 + students.size() * 60, name, 0));
            } else if (students.size() < 28) {
                students.add(new Student(560, 50 + students.size() % 14 * 60, "Student", 1));
            } else if (students.size() < 42) {
                students.add(new Student(1070, 50 + students.size() % 14 * 60, "Student", 2));
            }

            if (arg.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                if (students.size() > 0)
                    students.remove(students.size() - 1);
        }
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
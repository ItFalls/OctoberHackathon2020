import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
//master

public class Runner extends JPanel implements ActionListener, KeyListener, MouseListener {
    private static final long serialVersionUID = 1L;

    // ==FIELDS==
    private final Font font = new Font("ComicSans", Font.PLAIN, 18);
    public static ArrayList<String> arr = new ArrayList<>();

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
            if (i < 14) {
                students.get(i).setX(50);
                students.get(i).setY(50 + i * 60);
            } else if (i < 28) {
                students.get(i).setX(560);
                students.get(i).setY(50 + i % 14 * 60);
            } else if (i < 42) {
                students.get(i).setX(1070);
                students.get(i).setY(50 + i % 14 * 60);
            }

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

        if (arg.getKeyCode() == KeyEvent.VK_A) {
            students.sort((Student s1, Student s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
        }

        if (arg.getKeyCode() == KeyEvent.VK_G) {
            int num = Integer.parseInt(JOptionPane.showInputDialog("How many people per group?"));
            int groups = students.size() / num;
            Collections.shuffle(students);
            if (num >= students.size() || num <= 0)
                for (int x = 0; x < students.size(); x++)
                    students.get(x).setGroup(0);
            else {
                for (int x = 0; x < groups; x++) {
                    for (int y = x * num; y < x * num + num; y++) {
                        students.get(y).setGroup(x + 1);
                    }
                }
                if (students.size() % groups > 0) {
                    for (int x = students.size() - students.size() % groups; x < students.size(); x++)
                        students.get(x).setGroup(groups + 1);
                }

            }
        }

        if(arg.getKeyCode() == KeyEvent.VK_Z){
            Runtime runtime = Runtime.getRuntime();
            for (String link : arr) {
                String[] s = new String[]{System.getProperty("user.home") + "\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe", link};
                try {
                    runtime.exec(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if(arg.getKeyCode() == KeyEvent.VK_X) {
            arr.add(JOptionPane.showInputDialog("Enter URL Link"));
        }

        if (arg.getKeyCode() == KeyEvent.VK_S) {
            Collections.shuffle(students);
        }

        if (arg.getKeyCode() == KeyEvent.VK_C) {
            if (students.size() > 0)
                arr.remove(arr.size()-1);
        }

        if (arg.getKeyCode() == KeyEvent.VK_SPACE) {
            Scanner sc = new Scanner(System.in);
            String name = JOptionPane.showInputDialog("Enter student name");

            if (students.size() < 14) {
                students.add(new Student(50, 50 + students.size() * 60, name, 0));
            } else if (students.size() < 28) {
                students.add(new Student(560, 50 + students.size() % 14 * 60, name, 1));
            } else if (students.size() < 42) {
                students.add(new Student(1070, 50 + students.size() % 14 * 60, name, 2));
            }
        }
        if (arg.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (students.size() > 0)
                students.remove(findStudentByName(JOptionPane.showInputDialog("Enter student name")));
        }


        repaint();
    }

    public Student findStudentByName(String name) {
        for (Student studentObj : students) {
            if (studentObj.getName().replaceAll(" ", "").equalsIgnoreCase(name)) {
                return studentObj;
            }
        }
        return null;
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
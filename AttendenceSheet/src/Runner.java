import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//master

public class Runner extends JPanel implements ActionListener, KeyListener, MouseListener {
    private static final long serialVersionUID = 1L;

    // ==FIELDS==
    private final Font font = new Font("ComicSans", Font.PLAIN, 18);
    public static ArrayList<String> arr = new ArrayList<>();
    private static ArrayList<Student> students;
    private static File file;
    private static PrintWriter out;

    public Runner() throws IOException {
        students = new ArrayList<Student>();

        students.add(new Student("John", 0));
        students.add(new Student("Mike", 0));
        students.add(new Student("Ella", 0));
        students.add(new Student("Bob", 0));
        students.add(new Student("Tim", 0));
        students.add(new Student("Emma", 0));
        students.add(new Student("Jerry", 0));
        students.add(new Student("Sam", 0));
        students.add(new Student("Joe", 0));
        students.add(new Student("Liam", 0));
        students.add(new Student("Olivia", 0));
        students.add(new Student("Noah", 0));
        students.add(new Student("Ava", 0));
        students.add(new Student("Oliver", 0));


        String fileName = "links.txt";
        arr = (ArrayList<String>) Files.readAllLines(Paths.get(fileName));

        if (arr.size() == 0) {
            file = new File("links.txt");

        }
        out = new PrintWriter("links.txt");
    }

    //Paints everything
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.darkGray);
        g.setFont(font);

        for (int i = 0; i < students.size(); i++) {
            if (i < 12) {
                students.get(i).setX(15);
                students.get(i).setY(20 + i * 65);
            } else if (i < 24) {
                students.get(i).setX(525);
                students.get(i).setY(20 + i % 12 * 65);
            } else if (i < 36) {
                students.get(i).setX(1035);
                students.get(i).setY(20 + i % 12 * 65);
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
            int count = 0;
            for (int x = 0; x < students.size(); x++)
                if (students.get(x).getStatus().equals("Present") || students.get(x).getStatus().equals("Tardy")) {
                    count++;
                    break;
                }

            if (count > 0) {
                Random rand = new Random();
                Student calledOn;
                do {
                    calledOn = students.get(rand.nextInt(students.size()));
                } while (!calledOn.getStatus().equals("Present") && !calledOn.getStatus().equals("Tardy"));
                calledOn.call();

            }
        }

        if (arg.getKeyCode() == KeyEvent.VK_A) {
            students.sort((Student s1, Student s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
        }

        if (arg.getKeyCode() == KeyEvent.VK_G) {
            int num = Integer.parseInt(JOptionPane.showInputDialog("How many people per group?"));
            int groups = students.size() / num;
            if (num >= students.size() || num <= 0)
                for (int x = 0; x < students.size(); x++)
                    students.get(x).setGroup(0);
            else {
                Collections.shuffle(students);
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

        if (arg.getKeyCode() == KeyEvent.VK_Z) {
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

        if (arg.getKeyCode() == KeyEvent.VK_X) {
            String l = JOptionPane.showInputDialog("Enter URL");
            arr.add(l);
            writeValuesToFile();
        }

        if (arg.getKeyCode() == KeyEvent.VK_C) {
            if (students.size() > 0)
                arr.remove(arr.size() - 1);
        }

        if (arg.getKeyCode() == KeyEvent.VK_S) {
            Collections.shuffle(students);
        }

        if (arg.getKeyCode() == KeyEvent.VK_SPACE) {
            String name = JOptionPane.showInputDialog("Enter student name");

            if (students.size() < 12) {
                students.add(new Student(name, 0));
            } else if (students.size() < 24) {
                students.add(new Student(name, 0));
            } else if (students.size() < 36) {
                students.add(new Student(name, 0));
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

    public void writeValuesToFile() {
        try {
            for (String link : arr)
                out.println(link);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
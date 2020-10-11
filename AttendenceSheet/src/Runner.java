import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner extends JPanel implements ActionListener, KeyListener, MouseListener {
    private static final long serialVersionUID = 1L;

    // ==FIELDS==
    private final Font font = new Font("ComicSans", Font.PLAIN, 18);
<<<<<<< Updated upstream
    private JButton addStu = new JButton("Add student");
    private JButton remStu = new JButton("Remove student");
    //private JButton showList = new JButton("Show students");

=======
    private JButton aButton = new JButton("a");
    private JButton bButton = new JButton("b");
    private JButton cButton = new JButton("c");
    private static java.io.File f = new java.io.File("links.txt");
    private PrintWriter out = new PrintWriter(f);
>>>>>>> Stashed changes

    ArrayList<Student> students;
    ArrayList<JButton> atts;
    
    public Runner() throws FileNotFoundException {
        students = new ArrayList<Student>();
        atts = new ArrayList<JButton>();
        
        //Test Students
        /*JButton a1 = new JButton(), a2 = new JButton();
        Student s1 = new Student(50, 50, "Bob Ross", 0), s2 = new Student(50, 100, "John Smith", 1);
        students.add(s1);
        students.add(s2);
        atts.add(a1);
        atts.add(a2);*/
    }

    //Paints everything
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.darkGray);
        g.setFont(font);

<<<<<<< Updated upstream
        this.add(addStu);
        this.add(remStu);
        //this.add(showList);
        addStu.setBounds(50 * getWidth() / 800, 9 * getHeight() / 10, 2 * getWidth() / 8, 6 * getHeight() / 80);
        addStu.setBackground(Color.WHITE);
        remStu.setBounds(310 * getWidth() / 800, 9 * getHeight() / 10, 2 * getWidth() / 8, 6 * getHeight() / 80);
        remStu.setBackground(Color.WHITE);
        //showList.setBounds(570 * getWidth() / 800, 9 * getHeight() / 10, 2 * getWidth() / 8, 6 * getHeight() / 80);
        //showList.setBackground(Color.WHITE);

        for(int i=0;i<atts.size();i++) {
        	this.add(atts.get(i));
        	atts.get(i).setBackground(Color.WHITE);
        	atts.get(i).addActionListener(this);
        	atts.get(i).setBounds(students.get(i).getX()+150, students.get(i).getY()-20, 100, 25);
        	atts.get(i).setText(students.get(i).getStatus());
        }
        
        for(int i=0;i<students.size();i++) {
        	students.get(i).draw(g);
        }
        
=======
        this.setLayout(new GridLayout(3, 1));
        this.add(new JLabel("Enter Player 1 name:"));
        JTextField textField = new JTextField();
        textField.setSize(200, 100);
        this.add(textField);

        this.add(aButton);
        this.add(bButton);
        this.add(cButton);
        aButton.setBounds(50 * getWidth() / 800, 9 * getHeight() / 10, 2 * getWidth() / 8, 6 * getHeight() / 80);
        aButton.setBackground(Color.WHITE);
        bButton.setBounds(310 * getWidth() / 800, 9 * getHeight() / 10, 2 * getWidth() / 8, 6 * getHeight() / 80);
        bButton.setBackground(Color.WHITE);
        cButton.setBounds(570 * getWidth() / 800, 9 * getHeight() / 10, 2 * getWidth() / 8, 6 * getHeight() / 80);
        cButton.setBackground(Color.WHITE);

        aButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String str = textField.getText();
                str.replaceAll(" ", "");
                out.println(str);
            }
        });

>>>>>>> Stashed changes
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
            repaint();
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
    	JButton buttonPressed = (JButton) arg0.getSource();
    	if(buttonPressed.equals(addStu)) {
    		String ans = JOptionPane.showInputDialog("Student name (First Last)");
    		Student s = new Student(50, students.get(students.size()-1).getY()+100, ans, 0);
    		students.add(s);
    		JButton a = new JButton();
    		atts.add(a);
    	}
    	if(buttonPressed.equals(remStu)) {
    		String ans = JOptionPane.showInputDialog("Name of student to remove (First Last)");
    		for(int i=0;i<students.size();i++) {
    			if(students.get(i).getName().equalsIgnoreCase(ans)){
    				students.remove(i);
    				atts.remove(i);
    			}
    		}
    	}
    	for(int i=0;i<atts.size();i++) {
    		if(buttonPressed.equals(atts.get(i))) {
    			if(students.get(i).getStatus().equals("Absent")) {
    				students.get(i).setStatus(1);
    				atts.get(i).setText(students.get(i).getStatus());
    				System.out.println(atts.get(i).getText());
    			}
    			else if(students.get(i).getStatus().equals("Present")) {
    				students.get(i).setStatus(2);
    				atts.get(i).setText(students.get(i).getStatus());
    				System.out.println(atts.get(i).getText());
    			}
    			else if(students.get(i).getStatus().equals("Tardy")) {
    				students.get(i).setStatus(3);
    				atts.get(i).setText(students.get(i).getStatus());
    				System.out.println(atts.get(i).getText());
    			}
    			else if(students.get(i).getStatus().equals("Excused")) {
    				students.get(i).setStatus(0);
    				atts.get(i).setText(students.get(i).getStatus());
					System.out.println(atts.get(i).getText());
    			}
    		}
    	}
    	repaint();
    }
}
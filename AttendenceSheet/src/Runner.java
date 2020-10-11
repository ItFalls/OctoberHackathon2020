import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Runner extends JPanel implements ActionListener, KeyListener, MouseListener {
    private static final long serialVersionUID = 1L;

    // ==FIELDS==
    private final Font font = new Font("ComicSans", Font.PLAIN, 18);
    private JButton addStu = new JButton("Add student");
    private JButton remStu = new JButton("Remove student");
    //private JButton showList = new JButton("Show students");


    ArrayList<Student> students;
    ArrayList<JButton> atts;
    
    public Runner() {
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
        g.setColor(Color.orange);
        g.fillRect((int) (getWidth() * 7.5 / 9), 0, (getWidth()), getHeight());
        g.setColor(Color.darkGray);
        g.setFont(font);

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
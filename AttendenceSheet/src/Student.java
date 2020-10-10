import java.awt.*;

import javax.swing.JButton;

public class Student {

    private int x = 0;
    private int y = 0;
    private String name = "";
    final Font ital = new Font("ComicSans", Font.ITALIC, 18);
    
    /*
    0 - absent
    1 - present
    2 - tardy
    3 - excused
     */
    
    private int status = 0;

    public Student(int x, int y, String name, int status) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.status = status;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getStatus() {
    	if(status==0)
    		return "Absent";
    	else if(status==1)
    		return "Present";
    	else if(status==2)
    		return "Tardy";
    	else
    		return "Excused";
    }

    public void draw(Graphics g) {
    	g.drawString(getName(), x, y);
    	g.setFont(ital);
    	g.drawString(getStatus(), x+200, y);
    }
}

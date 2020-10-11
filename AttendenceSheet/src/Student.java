import java.awt.*;

public class Student {

    private int x = 0;
    private int y = 0;
    private String name = "";
    private boolean called = false;
    private int group = 0;
    
    /*
    0 - present
    1 - absent
    2 - tardy
    3 - excused
    4 - called
     */

    private int status = 0;

    public Student(int x, int y, String name, int status) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.status = status;
        called = false;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int g) {
        group = g;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public void changeStatus() {
        if (status == 3)
            this.status = 0;
        else
            this.status = status + 1;
    }

    public void call() {
        called = !called;
    }

    public boolean getCalled() {
        return called;
    }

    public String getStatus() {
        if(called)
            return "Called On!";
        else if (status == 0)
            return "Present";
        else if (status == 1)
            return "Absent";
        else if (status == 2)
            return "Tardy";
        else
            return "Excused";
    }

    public void draw(Graphics g) {
        if(called)
            g.setColor(Color.YELLOW);
        else if (status == 0)
            g.setColor(Color.green);
        else if (status == 1)
            g.setColor(Color.red);
        else if (status == 2)
            g.setColor(Color.orange);
        else
            g.setColor(Color.gray);

        int width = 500;
        int height = 50;
        g.drawRect(x, y, width, height);
        g.setColor(Color.BLACK);
        if(group > 0)
            g.drawString(getName() + "  :  " + getStatus() + "  :  Group " +  group, x + 50, y + height / 2 + 5);
        else
            g.drawString(getName() + "  :  " + getStatus(), x + 50, y + height / 2 + 5);
    }

    public boolean isIntersecting(int x, int y) {
        return (x >= getX()) && (x < getX() + 500) && (y >= getY()) && (y < getY() + 50);
    }
}

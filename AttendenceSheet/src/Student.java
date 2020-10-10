import java.awt.*;

public class Student {

    private int x = 0;
    private int y = 0;
    private String name = "";

    /*
    0 - absent
    1 - present
    2 - tardy
    3 - excused
     */
    private int  status = 0;

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

    public void draw(Graphics g) {
    }
}

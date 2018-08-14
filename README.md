# CtrlSys
import java.awt.Robot;
public class JavaApplication1 {


    public static void moveMouse(int x1,int y1,int x2,int y2,int waiTime) throws Exception
    {
        Robot r = new Robot();
        int x=x1;
        double m = (y2-y1)/(x2-x1);
        if(x<x2)
        {
            while(x<=x2)
            {
                int y=(int) ((x*m));

                r.mouseMove(x, y);
                x++;
                Thread.sleep(waiTime);
            }
        }
        else if(x>x2)
        {
            while(x>=x2)
            {
                int y=(int)((x*m));

                r.mouseMove(x, y);
                x--;
                Thread.sleep(waiTime);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
       moveMouse(100,100,50,50,20);
    }
    
}

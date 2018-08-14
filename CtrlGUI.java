import java.awt.AWTException;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;
class CtrlGUI {


    @SuppressWarnings("SleepWhileInLoop")
    public static void moveMouse(int x1,int y1,int x2,int y2,int waiTime)
    {
        try {        
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
        } catch (AWTException | InterruptedException ex) {
            Logger.getLogger(CtrlGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}

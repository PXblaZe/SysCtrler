import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CtrlGUI {


    @SuppressWarnings("SleepWhileInLoop")
    public static void moveArrow(int x1,int y1,int x2,int y2,int waiTime)
    {
        try {        
            Robot r = new Robot();
            int x=x1;
            double m = (y2-y1)/(x2-x1),y=0.0;
            for(;x<=x2;x++)
            {
                y=((x-x1)*m)+y1;
                r.mouseMove(x,(int)y);
                Thread.sleep(waiTime);
            }
            
        } catch (AWTException | InterruptedException ex) {
            Logger.getLogger(CtrlGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    @SuppressWarnings("SleepWhileInLoop")
    public static void keysTyped(String keys, int waiTime)
    {
        try {
            Robot r = new Robot();
            for(int i = 0 ; i < keys.length();i++)
            {
                if(keys.charAt(i)=='\b')
                {
                    r.keyPress(KeyEvent.VK_BACK_SPACE);
                    r.keyRelease(KeyEvent.VK_BACK_SPACE);
                }
                else if(keys.charAt(i)==' ')
                {
                    r.keyPress(KeyEvent.VK_SPACE);
                    r.keyRelease(KeyEvent.VK_SPACE);
                }
                else if(keys.charAt(i)=='\n')
                {
                    r.keyPress(KeyEvent.VK_ENTER);
                    r.keyRelease(KeyEvent.VK_ENTER);
                }
                else if(keys.charAt(i)=='\f')
                {
                    r.keyPress(KeyEvent.VK_CAPS_LOCK);
                    r.keyRelease(KeyEvent.VK_CAPS_LOCK);
                }
                else
                {
                    r.keyPress((int)keys.charAt(i));
                    r.keyRelease((int)keys.charAt(i));
                }
                Thread.sleep(waiTime);
            }
        } catch (AWTException | InterruptedException ex) {
            Logger.getLogger(CtrlGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int[] musLocason()
    {
        int xy[] = new int[2];
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        xy[0] = (int) b.getX();
        xy[1] = (int) b.getY();
        return xy;
    }
    
}

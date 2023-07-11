package Controller.ScreenDetection;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;


public class Screenshot {

    
    public static BufferedImage captureScreenshot(int x, int y, int width, int height) {
        BufferedImage screenshot;
        try {
            Robot robot = new Robot();
            Rectangle area = new Rectangle(x, y, width, height);
            screenshot = robot.createScreenCapture(area);
            return screenshot;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    


}

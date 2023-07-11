package Controller.ScreenDetection;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Screenshot {

    
    public static void captureScreenshot(int x, int y, int width, int height, String filePath) {
        try {
            Robot robot = new Robot();
            Rectangle area = new Rectangle(x, y, width, height);
            BufferedImage screenshot = robot.createScreenCapture(area);
            ImageIO.write(screenshot, "png", new File(filePath));
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
}

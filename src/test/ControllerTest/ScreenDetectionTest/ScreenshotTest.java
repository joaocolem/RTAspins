package test.ControllerTest.ScreenDetectionTest;
import Controller.ScreenDetection.*;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.image.BufferedImage;


public class ScreenshotTest {

    @Test
    public void testCaptureScreenshot() {
        // Test parameters
        int x = 0;
        int y = 0;
        int width = 100;
        int height = 100;

        // Call the method under test
        BufferedImage result = Screenshot.captureScreenshot(x, y, width, height);

        // Assert the result
        assertNotNull(result);
        assertEquals(width, result.getWidth());
        assertEquals(height, result.getHeight());
    }

}

package test.ControllerTest.ScreenDetectionTest.ImageVerificationsTest.Actions;

import Controller.ScreenDetection.ImageVerifications.Actions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class VerifyActionsTest {
    private BufferedImage image;

    @BeforeEach
    void setUp() {
        try {
            image = ImageIO.read(new File("C:\\imge\\testeacy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCheckPixelColors() {
        String result = VerifyActions.checkPixelColors(image);
        
        // Perform assertions to verify the expected result
        assertNotNull(result);
        assertTrue(result.contains("F"));
        assertTrue(result.contains("L"));
        assertFalse(result.contains("R"));
        assertFalse(result.contains("A"));
        assertTrue(result.contains("C"));

        assertEquals("CFL", result);

    }

    



}
package test.ControllerTest.ScreenDetectionTest;

import static org.junit.Assert.assertEquals;

import Controller.ScreenDetection.ImgToTxt.*;

import org.junit.Test;

public class ImgToTextTest {

    @Test
    public void testImgToText() {
        String inputFile = "C:\\imge\\testeImg.png";
        String expectedOutput = "plzonuciaoDE TEXTO";

        String actualOutput = ImgToText.imgToText(inputFile);

        assertEquals(expectedOutput, actualOutput);
    }
}

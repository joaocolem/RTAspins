import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Color;
import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.*;

public class VerifyCardTest {
    @Test
    public void testImgToText() {
        String inputFile = "C:\\imge\\testeImg.png";
        String expectedOutput = "plzonuciaoDE TEXTO";

        String actualOutput = ImgToText.imgToText(inputFile);

        assertEquals(expectedOutput, actualOutput);
    }
}

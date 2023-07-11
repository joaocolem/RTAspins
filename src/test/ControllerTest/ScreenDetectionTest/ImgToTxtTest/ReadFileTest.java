package test.ControllerTest.ScreenDetectionTest.ImgToTxtTest;
import org.junit.Test;
import static org.junit.Assert.*;
import Controller.ScreenDetection.ImgToTxt.ReadFile;


public class ReadFileTest {

    @Test
    public void testReadFile() {

        ReadFile readFile = new ReadFile();
        String fileContent = readFile.read_a_file("C:\\imge\\cartas\\screen2.png");

        // Assertion statements to verify the expected behavior
        assertNotNull(fileContent);  // Check if the returned string is not null
        // Add more assertions based on your expected behavior
    }
}

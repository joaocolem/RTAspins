package test.ControllerTest.ScreenDetectionTest;
import Controller.ScreenDetection.*;


import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class ImageProcessorTest {
    private BufferedImage image;

    @BeforeEach
    void setUp() {
        try {
            image = ImageIO.read(new File("C:\\imge\\testeImg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetSubImage() {
        // Definir as coordenadas e dimensões da subimagem
        int x = 10;
        int y = 10;
        int width = 10;
        int height = 10;

        // Obter a subimagem usando o método getSubImage()
        BufferedImage subImage = ImageProcessor.getSubImage(image, x, y, width, height);

        // Verificar se a subimagem tem as dimensões esperadas
        assertEquals(width, subImage.getWidth());
        assertEquals(height, subImage.getHeight());

        // Verificar se a subimagem é uma cópia profunda
        assertNotSame(image, subImage);

        // Verificar se a subimagem contém os mesmos pixels da região correspondente na imagem original
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int originalRGB = image.getRGB(x + i, y + j);
                int subImageRGB = subImage.getRGB(i, j);
                assertEquals(originalRGB, subImageRGB);
            }
        }
    }
}
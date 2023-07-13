package test.ControllerTest.ScreenDetectionTest.ImageVerificationsTest.CardsTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.Color;
import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.*;
import Controller.ScreenDetection.ImageVerifications.Cards.*;



public class VerifyCardTest {
    private BufferedImage image;

    @BeforeEach
    public void setUp() {
        int width = 10;
        int height = 10;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    
        // Preencher 60% dos pixels com a cor verde
        int greenPixels = (int) (width * height * 0.6);
        int currentGreenPixels = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (currentGreenPixels < greenPixels) {
                    image.setRGB(x, y, Color.GREEN.getRGB());
                    currentGreenPixels++;
                } else {
                    image.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }
    }

    @Test
    public void testAnalyze() {
        VerifyCard verifyCard = new VerifyCard(image);

        // Verificar os valores esperados após a análise
        assertEquals(60, verifyCard.getNonWhitePixels());
        assertEquals(0, verifyCard.getRedPixels());
        assertEquals(0, verifyCard.getBluePixels());
        assertEquals(0, verifyCard.getBlackPixels());
        assertEquals(60, verifyCard.getGreenPixels());
    }

    @Test
    public void testGetPredominantColor() {
        // Configurar o objeto BufferedImage de teste com pixels vermelhos
        int width = 10;
        int height = 10;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Preencher a imagem com pixels vermelhos
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, Color.RED.getRGB());
            }
        }

        VerifyCard verifyCard = new VerifyCard(image);
        verifyCard.analyze();
        String predominantColor = verifyCard.getPredominantColor();

        // Verificar o valor esperado para o caso de teste específico
        assertEquals("h", predominantColor);
    }

    @Test
    public void testHasMoreWhitePixelsThanHalf() {
        // Configurar o objeto BufferedImage de teste com metade dos pixels brancos
        int width = 10;
        int height = 10;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Preencher a metade superior da imagem com pixels brancos
        for (int y = 0; y < height / 2; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, Color.WHITE.getRGB());
            }
        }

        VerifyCard verifyCard = new VerifyCard(image);
        boolean hasMoreWhitePixels = verifyCard.hasMoreWhitePixelsThanHalf();

        // Verificar o valor esperado para o caso de teste específico
        assertTrue(hasMoreWhitePixels);
    }
}

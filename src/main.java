
import Controller.ScreenDetection.ImageProcessor;
import Controller.ScreenDetection.Screenshot;
import Controller.ScreenDetection.ImageVerifications.Actions.VerifyActions;
import Controller.ScreenDetection.ImgToTxt.ImgToText;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class main {
    public static void main(String[] args) {
        int height=605, width=806;
        //tela 0,0,605,806
        //carta1: 365,365,30, 25
        //carta2: 405,365,30,25
        //stackHero: 385,418,60,25
        //stackV1: 85,190,70,25
        //stackV2: 675,190,70,25
        //verQuant: 535,20,80,1
        //posicaoHero: 253, 424, 30, 25
        //actionV1: 10, 255, 200, 50
        //actionHero: 10, 310, 200, 30
        //actionV2: 10, 358, 200, 30


        BufferedImage tableImage = Screenshot.captureScreenshot(0, 0, width, height);

        BufferedImage carta1 = ImageProcessor.getSubImage(tableImage, 365, 365, 30, 25);
        BufferedImage carta2 = ImageProcessor.getSubImage(tableImage, 405, 365, 30, 25);
        BufferedImage stackHero = ImageProcessor.getSubImage(tableImage, 385, 418, 60, 25);
        BufferedImage stackV1 = ImageProcessor.getSubImage(tableImage, 85, 190, 70, 25);
        BufferedImage stackV2 = ImageProcessor.getSubImage(tableImage, 675, 190, 70, 25);
        BufferedImage verQuant = ImageProcessor.getSubImage(tableImage, 535, 20, 80, 1);
        BufferedImage posicaoHero = ImageProcessor.getSubImage(tableImage, 253, 424, 30, 25);
        BufferedImage actionV1 = ImageProcessor.getSubImage(tableImage, 10, 258, 200, 30);
        BufferedImage actionHero = ImageProcessor.getSubImage(tableImage, 10, 310, 200, 30);
        BufferedImage actionV2 = ImageProcessor.getSubImage(tableImage, 10, 358, 200, 30);
        
        // Salvar as imagens em arquivos
        saveImage(carta1, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\carta1.png");
        saveImage(carta2, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\carta2.png");
        saveImage(stackHero, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\stackHero.png");
        saveImage(stackV1, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\stackV1.png");
        saveImage(stackV2, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\stackV2.png");
        saveImage(verQuant, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\verQuant.png");
        saveImage(posicaoHero, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\posicaoHero.png");
        saveImage(actionV1, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\actionV1.png");
        saveImage(actionHero, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\actionHero.png");
        saveImage(actionV2, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\actionV2.png");
        
        System.out.println(VerifyActions.checkPixelColors(actionHero));
        System.out.println(VerifyActions.checkPixelColors(actionV2));
        System.out.println(VerifyActions.checkPixelColors(actionV1));




    }

    private static void saveImage(BufferedImage image, String outputPath) {
        try {
            File outputFile = new File(outputPath);
            ImageIO.write(image, "png", outputFile);
            System.out.println("Imagem salva em: " + outputPath);
        } catch (IOException e) {
            System.out.println("Erro ao salvar a imagem: " + e.getMessage());
        }
    }


}

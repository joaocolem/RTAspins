
import Controller.Game.Card;
import Controller.Game.Player;
import Controller.ScreenDetection.ImageProcessor;
import Controller.ScreenDetection.Screenshot;
import Controller.ScreenDetection.ImageVerifications.Actions.VerifyActions;
import Controller.ScreenDetection.ImageVerifications.Cards.VerifyCard;
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

        BufferedImage ImageCard1 = ImageProcessor.getSubImage(tableImage, 365, 365, 30, 25);
        BufferedImage ImageCard2 = ImageProcessor.getSubImage(tableImage, 405, 365, 30, 25);
        BufferedImage ImageStackHero = ImageProcessor.getSubImage(tableImage, 385, 418, 60, 25);
        BufferedImage ImageStackV1 = ImageProcessor.getSubImage(tableImage, 85, 190, 70, 25);
        BufferedImage ImageStackV2 = ImageProcessor.getSubImage(tableImage, 675, 190, 70, 25);
        BufferedImage ImageVerQuant = ImageProcessor.getSubImage(tableImage, 535, 20, 80, 1);
        BufferedImage ImagePosicaoHero = ImageProcessor.getSubImage(tableImage, 253, 424, 30, 25);
        BufferedImage ImageActionV1 = ImageProcessor.getSubImage(tableImage, 10, 258, 200, 30);
        BufferedImage ImageActionHero = ImageProcessor.getSubImage(tableImage, 10, 310, 200, 30);
        BufferedImage ImageActionV2 = ImageProcessor.getSubImage(tableImage, 10, 358, 200, 30);
        
        // Salvar as imagens em arquivos
        saveImage(ImageCard1, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\carta1.png");
        saveImage(ImageCard2, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\carta2.png");
        saveImage(ImageStackHero, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\stackHero.png");
        saveImage(ImageStackV1, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\stackV1.png");
        saveImage(ImageStackV2, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\stackV2.png");
        saveImage(ImageVerQuant, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\verQuant.png");
        saveImage(ImagePosicaoHero, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\posicaoHero.png");
        saveImage(ImageActionV2, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\actionV1.png");
        saveImage(ImageActionHero, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\actionHero.png");
        saveImage(ImageActionV2, "C:\\Users\\joao_\\Documents\\GitHub\\RTAspins\\src\\ImageFiles\\actionV2.png");
        
        System.out.println(VerifyActions.checkPixelColors(ImageActionHero));
        System.out.println(VerifyActions.checkPixelColors(ImageActionV1));
        System.out.println(VerifyActions.checkPixelColors(ImageActionV2));
        
    
        VerifyCard verifyCard = new VerifyCard(ImageCard1);
        VerifyCard verifyCard2 = new VerifyCard(ImageCard2);
        Card card1 = new Card(verifyCard.getNonWhitePixels(), verifyCard.getPredominantColor());
        System.out.println(card1.toString());
        Card card2 = new Card(verifyCard2.getNonWhitePixels(), verifyCard2.getPredominantColor());
        System.out.println(card2.toString());
        String [] cards = {card1.toString(), card2.toString()};
        Player hero = new Player(100, 1, null, cards);
        System.out.println(hero.toString());

        VerifyCard verifyQuant = new VerifyCard(ImageVerQuant);
        boolean isHeadsUp = verifyQuant.hasMoreWhitePixelsThanHalf();
        System.out.println(isHeadsUp);


        


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

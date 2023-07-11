package Controller.ScreenDetection.ImageVerifications.Actions;

import java.util.HashSet;
import java.util.Set;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;


public class VerifyActions {

    public static String checkPixelColors(BufferedImage image) {
        StringBuilder result = new StringBuilder();
        Set<Color> colorSet = new HashSet<>();
        
        // Define as cores a serem verificadas
        Color colorF = new Color(166, 3, 51);
        Color colorL = new Color(14, 169, 255);
        Color colorR = new Color(224, 153, 11);
        Color colorA = new Color(118, 82, 248);
        Color colorC = new Color(60, 184, 106);
        
        // Percorre todos os pixels da imagem
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color pixelColor = new Color(image.getRGB(x, y));
                
                // Verifica se a cor do pixel é igual a alguma das cores definidas
                if (pixelColor.equals(colorF) && !colorSet.contains(colorF)) {
                    result.append("F");
                    colorSet.add(colorF);
                } else if (pixelColor.equals(colorL) && !colorSet.contains(colorL)) {
                    result.append("L");
                    colorSet.add(colorL);
                } else if (pixelColor.equals(colorR) && !colorSet.contains(colorR)) {
                    result.append("R");
                    colorSet.add(colorR);
                } else if (pixelColor.equals(colorA) && !colorSet.contains(colorA)) {
                    result.append("A");
                    colorSet.add(colorA);
                } else if (pixelColor.equals(colorC) && !colorSet.contains(colorC)) {
                    result.append("C");
                    colorSet.add(colorC);
                }
            }
        }
        
        return result.toString();
    }


    // Exemplo de uso
    public static void main(String[] args) {
        // Carrega a imagem (substitua o caminho pelo caminho real da imagem no seu sistema)
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("C:\\imge\\testeacy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Cria uma instância da classe
        
        // Verifica as cores na imagem e retorna a ordem
        String colorOrder = checkPixelColors(image);
        System.out.println("Ordem das cores encontradas: " + colorOrder);
    }
}

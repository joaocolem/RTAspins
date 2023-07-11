package Controller.ScreenDetection;


import java.awt.image.BufferedImage;


public class ImageProcessor {
    public static BufferedImage getSubImage(BufferedImage image, int x, int y, int width, int height) {
        BufferedImage subImage = image.getSubimage(x, y, width, height);
        return deepCopy(subImage); // Faz uma cópia profunda da subimagem para evitar que a mesma seja modificada externamente
    }

    private static BufferedImage deepCopy(BufferedImage image) {
        BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        copy.getGraphics().drawImage(image, 0, 0, null);
        return copy;
    }
}

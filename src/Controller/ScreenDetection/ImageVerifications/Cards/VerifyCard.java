package Controller.ScreenDetection.ImageVerifications.Cards;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VerifyCard {
    private BufferedImage image;
    private int nonWhitePixels;
    private int redPixels;
    private int bluePixels;
    private int blackPixels;
    private int greenPixels;

    public VerifyCard(BufferedImage image) {
        this.image = image;
        this.nonWhitePixels = 0;
        this.redPixels = 0;
        this.bluePixels = 0;
        this.blackPixels = 0;
        this.greenPixels = 0;
    }

    public void analyze() {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color pixelColor = new Color(image.getRGB(x, y));
                int red = pixelColor.getRed();
                int green = pixelColor.getGreen();
                int blue = pixelColor.getBlue();

                if (!isWhite(pixelColor)) {
                    nonWhitePixels++;

                    if (isRed(red, green, blue)) {
                        redPixels++;
                    } else if (isBlue(red, green, blue)) {
                        bluePixels++;
                    } else if (isBlack(red, green, blue)) {
                        blackPixels++;
                    } else if (isGreen(red, green, blue)) {
                        greenPixels++;
                    }
                }
            }
        }
    }

    private boolean isWhite(Color color) {
        return color.getRed() == 255 && color.getGreen() == 255 && color.getBlue() == 255;
    }

    private boolean isRed(int red, int green, int blue) {
        return red > green && red > blue;
    }

    private boolean isBlue(int red, int green, int blue) {
        return blue > red && blue > green;
    }

    private boolean isBlack(int red, int green, int blue) {
        return red == 0 && green == 0 && blue == 0;
    }

    private boolean isGreen(int red, int green, int blue) {
        return green > red && green > blue;
    }

    public int getNonWhitePixels() {
        return nonWhitePixels;
    }

    public String getPredominantColor() {
        if (redPixels > bluePixels && redPixels > blackPixels && redPixels > greenPixels) {
            return "h";
        } else if (bluePixels > redPixels && bluePixels > blackPixels && bluePixels > greenPixels) {
            return "d";
        } else if (blackPixels > redPixels && blackPixels > bluePixels && blackPixels > greenPixels) {
            return "s";
        } else if (greenPixels > redPixels && greenPixels > bluePixels && greenPixels > blackPixels) {
            return "c";
        } else {
            return "";
        }
    }

    public boolean hasMoreWhitePixelsThanHalf() {
        int totalPixels = image.getWidth() * image.getHeight();
        int whitePixels = totalPixels - nonWhitePixels;
        return whitePixels > totalPixels / 3;
    }
}


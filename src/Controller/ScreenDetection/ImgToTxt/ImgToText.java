package Controller.ScreenDetection.ImgToTxt;
import Controller.ScreenDetection.Screenshot;

import java.io.PrintWriter;

public class ImgToText {
    
    final static String tesseractInstallPath="C:\\Program Files (x86)\\Tesseract-OCR\\tesseract";

    public static String imgToText(String inputFile) {
        

        String outputFile="C:\\imge\\teste";
        String[] command =
        {
            "cmd",
        };
        Process p;
        try {
        p = Runtime.getRuntime().exec(command);
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("\""+tesseractInstallPath+"\" \""+inputFile+"\" \""+outputFile+"\" -l eng");
            stdin.close();
            p.waitFor();

        } catch (Exception e) {
        e.printStackTrace();
        }

        return(ReadFile.read_a_file(outputFile+".txt"));
    }
}
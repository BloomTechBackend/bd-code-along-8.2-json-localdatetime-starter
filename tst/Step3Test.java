import controllers.LibraryController;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Step3Test {

    @Test
    public void testReportMatchesTestImage() {
        LibraryController controller = new LibraryController();

        File chartFile = new File("chart.png");
        if (chartFile.exists()) {
            chartFile.delete();
        }

        controller.loadBooks("books.csv");

        assertTrue(chartFile.exists());

        assertTrue(compareImages(chartFile) == 0);
    }

    private double compareImages(File chart) {
        BufferedImage img1 = null;
        BufferedImage img2 = null;
        try {
            img1 = ImageIO.read(chart);
            img2 = ImageIO.read(App.class.getResource("testChart.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        int w1 = img1.getWidth();
        int w2 = img2.getWidth();
        int h1 = img1.getHeight();
        int h2 = img2.getHeight();

        double percentage = 0.0;
        if ((w1!=w2)||(h1!=h2)) {
            System.out.println("Both images should have same dimwnsions");
        } else {
            long diff = 100;
            for (int j = 0; j < h1; j++) {
                for (int i = 0; i < w1; i++) {
                    //Getting the RGB values of a pixel
                    int pixel1 = img1.getRGB(i, j);
                    Color color1 = new Color(pixel1, true);
                    int r1 = color1.getRed();
                    int g1 = color1.getGreen();
                    int b1 = color1.getBlue();
                    int pixel2 = img2.getRGB(i, j);
                    Color color2 = new Color(pixel2, true);
                    int r2 = color2.getRed();
                    int g2 = color2.getGreen();
                    int b2= color2.getBlue();
                    //sum of differences of RGB values of the two images
                    long data = Math.abs(r1-r2)+Math.abs(g1-g2)+ Math.abs(b1-b2);
                    diff = diff+data;
                }
            }
            double avg = diff/(w1*h1*3);
            percentage = (avg/255)*100;
            System.out.println("Difference: "+ percentage);
        }
        return percentage;
    }

}

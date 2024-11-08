import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;

public class Compare {
    static void processImage() {
        String file1 = "p4.jpg";
        Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
        String file2 = "p5.jpg";
        Image image2 = Toolkit.getDefaultToolkit().getImage(file2);
        try {
            PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
            PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);

            if (grab1.grabPixels() && grab2.grabPixels()) {
                int[] data1 = (int[]) grab1.getPixels();
                int[] data2 = (int[]) grab2.getPixels();
                System.out.println("Fingerprint matches: " + java.util.Arrays.equals(data1, data2));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        processImage();
    }
}

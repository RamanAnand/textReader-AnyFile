package imageFilterActions;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class GrayScale {

	public static void convertGrey(String filepath, String filePathOutput) throws IOException {
		File imageFile = new File(filepath);
		BufferedImage image = ImageIO.read(imageFile);
		int width = image.getWidth();
		int height = image.getHeight();
		for(int i=0; i<height; i++){

			for(int j=0; j<width; j++){

				Color c = new Color(image.getRGB(j, i));
				int red = (int)(c.getRed() * 0.299);
				int green = (int)(c.getGreen() * 0.587);
				int blue = (int)(c.getBlue() *0.114);
				Color newColor = new Color(red+green+blue, red+green+blue,red+green+blue);

				image.setRGB(j,i,newColor.getRGB());
			}
		}
		File ouptut = new File(filePathOutput+".png");
		ImageIO.write(image, "png", ouptut);
//		System.out.println("Image grayscaled");
	}

}


package imageFilterActions;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class DilateImage {

	public static void dilate(String filePath, String filePathOutput) {
	      Mat src = Imgcodecs.imread(filePath);
	      Mat dst = new Mat();
	      Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
	         new  Size((1*1) + 0.5, (1*1)+0.5));
	      Imgproc.dilate(src, dst, kernel);
	      Imgcodecs.imwrite(filePathOutput+"Dilation.png", dst);
	      System.out.println("Image dilated");
	}

}

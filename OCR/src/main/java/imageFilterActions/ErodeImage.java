package imageFilterActions;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ErodeImage {

	public static void erode(String filePath, String filePathOutput) {
	      Mat src = Imgcodecs.imread(filePath);
	      Mat dst = new Mat();
	      Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
	         new  Size((2*1) + 1, (2*1)+1));
	      Imgproc.erode(src, dst, kernel);
//	      Imgcodecs.imwrite(filePathOutput+"Erosion.png", dst);
	      Imgcodecs.imwrite(filePathOutput+".png", dst);
	      System.out.println("Image eroded");
	}

}

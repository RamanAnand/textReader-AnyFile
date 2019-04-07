package imageFilterActions;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Threshold {

	public static void adaptiveThreshold(String filepath, String filePathOutput) {
		Mat src = Imgcodecs.imread(filepath,0);
		Mat dst = new Mat();
		Imgproc.adaptiveThreshold(src, dst, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C,
				Imgproc.THRESH_BINARY, 15, 40);
		Imgcodecs.imwrite(filePathOutput+"AdaptiveThreshold.png", dst);
		System.out.println("Image adaptive threshold performed");
	}


	public static void Thresholding(String filepath, String filePathOutput) {
		Mat src = Imgcodecs.imread(filepath,0);
		Mat dst = new Mat();		
		Imgproc.threshold(src, dst, 127, Imgproc.THRESH_BINARY,Imgproc.COLOR_RGB2GRAY);	
		Core.bitwise_xor(src, dst, dst);
		Imgcodecs.imwrite(filePathOutput+"Threshold.png", dst);
		System.out.println("Image threshold performed with binary inversion");
	}
}

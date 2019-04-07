package imageFilterActions;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class InvertColor {
	public static void interColor(String filepath, String filePathOutput) {
		//inverting color for better clarity
		Mat src = Imgcodecs.imread(filepath);
		Mat dst = new Mat();
		Core.bitwise_not(src, dst);
//		Imgcodecs.imwrite(filePathOutput+"inverted.png", dst);
		Imgcodecs.imwrite(filePathOutput+".png", dst);
//		System.out.println("Image color inverted");
	}
}

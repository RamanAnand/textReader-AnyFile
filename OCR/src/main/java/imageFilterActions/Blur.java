package imageFilterActions;

import java.io.IOException;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Blur {

	public static void averageBlur(String filePath, String filePathOutput) {
		Mat src = Imgcodecs.imread(filePath);
		Mat dst = new Mat();
		// Creating the Size and Point objects
//		Size size = new Size(20, 20);
//		Point point = new Point(10, 10);
//		Imgproc.blur(src, dst, size, point, Core.BORDER_DEFAULT);
		Imgproc.bilateralFilter(src, dst, -0, 1.0, 1.0);
//		Imgcodecs.imwrite(filePathOutput+"blur.png", dst);
		Imgcodecs.imwrite(filePathOutput+".png", dst);
//		System.out.println("Image bilateral filtered");

	}

	public static void GaussianBlur(String filePath, String filePathOutput) throws IOException {
		Mat src = Imgcodecs.imread(filePath);
		Mat dst = new Mat();
		Imgproc.GaussianBlur(src, dst, new Size(3, 3), 0);
//		Imgcodecs.imwrite(filePathOutput+"Gaussian.png", dst);
		Imgcodecs.imwrite(filePathOutput+".png", dst);
//		System.out.println("Image blurred");
	}

}

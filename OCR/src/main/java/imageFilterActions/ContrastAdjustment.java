package imageFilterActions;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ContrastAdjustment {
	public static void contrastAdjust(String filepath, String filePathOutput) {

		Mat source = Imgcodecs.imread(filepath, Imgproc.COLOR_BGR2GRAY);
		Mat destination = new Mat(source.rows(),source.cols(),source.type());

		Imgproc.equalizeHist(source, destination);
		Imgcodecs.imwrite(filePathOutput+"contrast.jpg", destination);
		System.out.println("Image contrast Processed");
	}

}
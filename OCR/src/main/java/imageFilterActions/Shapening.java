package imageFilterActions;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Shapening {

	public static void sharpening(String filePath, String filePathOutput) {
		Mat source = Imgcodecs.imread(filePath);
        Mat dst = new Mat(source.rows(),source.cols(),source.type());
        Imgproc.GaussianBlur(source, dst, new Size(0,0), 10);
        Core.addWeighted(source, 1.5, dst, -0.5, 0, dst);
        Imgcodecs.imwrite(filePathOutput+".png", dst);
//        System.out.println("Image sharpened");
	}

}

package imageFilterActions;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ScaleImageSize {

	public static void scaleImage(String filePath, String filePathOutput){
		Mat src = Imgcodecs.imread(filePath);
		Mat dst = new Mat();
		int height = src.height();
		int width = src.width();
		if(height >= width) {
			if(height <= 3700) {
				//scale image -> LARGE
				System.out.println("image actual size "+height +" "+width);
				Size size = new Size(src.rows()*2,src.rows()*3); //width * height
				int interpolation = Imgproc.INTER_CUBIC;   
				Imgproc.resize(src, dst, size, 0, 0, interpolation);
				Imgcodecs.imwrite(filePathOutput+".png", dst);
				int height1 = dst.height();
				int width1 = dst.width();
//				System.out.println("image scaled "+height1 +" "+width1);
			}
			else {
				Mat src1 = Imgcodecs.imread(filePath);
				Mat dst1 = src1.clone();
				Imgcodecs.imwrite(filePathOutput+".png", dst1);
				System.out.println("image not scaled");
			}
		}
		else {
			if(width < 1000) {
				System.out.println("image actual size "+height +" "+width);
				Size size = new Size(src.rows()*6,src.rows()*4);
				int interpolation = Imgproc.INTER_CUBIC;   
				Imgproc.resize(src, dst, size, 0, 0, interpolation);
				Imgcodecs.imwrite(filePathOutput+".png", dst);
				int height1 = dst.height();
				int width1 = dst.width();
//				System.out.println("image scaled "+width1 +" "+height1);
			}
			else {
				Mat src1 = Imgcodecs.imread(filePath);
				Mat dst1 = src1.clone();
				Imgcodecs.imwrite(filePathOutput+".png", dst1);
				System.out.println("image not scaled");
			}
		}
		
	}


}

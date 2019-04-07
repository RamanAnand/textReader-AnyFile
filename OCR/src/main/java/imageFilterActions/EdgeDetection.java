package imageFilterActions;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class EdgeDetection {
	
	public static void sobelEdgeDetection(String filepath, String filePathOutput) {
		
		Mat src_gray =  Imgcodecs.imread(filepath);
		Mat dst = new Mat();
		int kernelSize=9;
		Mat kernel = new Mat(kernelSize,kernelSize, CvType.CV_32F){
            {
               put(0,0,0);
               put(0,1,-1);
               put(0,2,0);
               
               put(1,0-1);
               put(1,1,4);
               put(1,2,-1);

               put(2,0,0);
               put(2,1,-1);
               put(2,2,0);
                        
              
            }
         }; 
//         Imgproc.Canny(src_gray, src_gray, kernel, 10, 100);
		Imgproc.filter2D(src_gray, dst, src_gray.depth(), kernel);
		Imgcodecs.imwrite(filePathOutput+"\\Edged.png", src_gray);
		
	}
}

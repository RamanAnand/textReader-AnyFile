package imageProcessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import org.opencv.core.Core;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImageProcess {
	static {
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );		
	}
	
	public static void TextProcessPackOne(String filePath, String filePathOutput, String filename) throws IOException, InterruptedException, TesseractException {
		filePathOutput = filePathOutput+"\\"+filename;
		imageFilterActions.ScaleImageSize.scaleImage(filePath,filePathOutput);
		imageFilterActions.Shapening.sharpening(filePathOutput+".png",filePathOutput);
		imageFilterActions.GrayScale.convertGrey(filePathOutput+".png", filePathOutput);
		imageFilterActions.InvertColor.interColor(filePathOutput+".png", filePathOutput);
		imageFilterActions.Blur.GaussianBlur(filePathOutput+".png",filePathOutput);
		File imageFile = new File(filePathOutput+".png");
		TessaractOCR(imageFile, filePathOutput+".txt");
		imageFile.delete();
	}
	
	public static void TessaractOCR(File file, String filePathToWriteContent) throws TesseractException, IOException {
		ITesseract instance = new Tesseract();
		String imageTextContent = instance.doOCR(file);
		/*
		 * below code is to keep the text file  with white spaces and new lines
		 */
		BufferedReader reader = new BufferedReader(new StringReader(imageTextContent));
		PrintWriter writer = new PrintWriter(new FileWriter(filePathToWriteContent));
		reader.lines().forEach(line -> writer.println(line));
		writer.close();
		System.out.println("Contents written into "+filePathToWriteContent+"\n");
	
	}
}

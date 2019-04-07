package controller;

import java.io.File;
import java.io.IOException;

import imageProcessing.ImageProcess;
import net.sourceforge.tess4j.TesseractException;

public class ImageParser {

	public static void processImage(File selectedFile, String outputFolder) throws IOException, InterruptedException, TesseractException {
		// TODO Auto-generated method stub
		String filePath = selectedFile.getAbsolutePath();
		String filePathOutput = outputFolder;
		String filename = selectedFile.getName().substring(0, selectedFile.getName().lastIndexOf("."));
		
		
		ImageProcess.TextProcessPackOne(filePath, filePathOutput, filename);
	}

}

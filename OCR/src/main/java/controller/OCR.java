package controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import net.sourceforge.tess4j.TesseractException;

public class OCR {
	public static void main(String args[]) throws IOException, SAXException, TikaException, InterruptedException, TesseractException {
		
		
		System.out.println("Welcome to OCR");Thread.sleep(3000);
		System.out.println("Keep all the attachments in a folder and pass the absolute(Complete) path of the folder");
		System.out.println("Source Folder:");
		Scanner sc= new Scanner(System.in);
		String inputPath = sc.nextLine();
		long startTime = System.nanoTime();
		
		File directory = new File(inputPath);
		
		String strDirectoy ="output";
		String outputPath = inputPath+"\\"+strDirectoy;
		System.out.println(outputPath);
		
	    boolean success = (new File(outputPath)).mkdir();
	    if (success) {
	      System.out.println("Directory: " + strDirectoy + " created");
	    }  
		
		File[] listOfFiles = directory.listFiles();
		for(File selectedFile: listOfFiles) {//all file will now be sent for processing
			System.out.println(selectedFile.getName());
			String ext = checkExtension(selectedFile.getAbsolutePath());
			if(ext!=null) {
				Boolean typeOfFile = checkImageorNot(ext);
				if(typeOfFile==true) {
					System.out.println("image");
					String outputFolder=outputPath;
					ImageParser.processImage(selectedFile,outputFolder);
				}
				else {
					System.out.println("not image");
					String outputFolder=outputPath;
					NotImageParser.getContents(selectedFile,outputFolder);
				}				
			}
		}sc.close();
		long totalTime = System.nanoTime() - startTime;
		System.out.println("Total processing time = "+TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS)+" seconds");
	}

	private static Boolean checkImageorNot(String ext) {
		boolean image = true;
		if(ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpg") ||
				ext.equalsIgnoreCase("tif") || ext.equalsIgnoreCase("jpeg") ||
				ext.equalsIgnoreCase("tiff") || ext.equalsIgnoreCase("gif")||
				ext.equalsIgnoreCase("bmp")) {
			return image;
		}
		else {
			image=false;
			return image;
		}		
	}

	private static String checkExtension(String absolutePath) {
		int isDotPresent = absolutePath.lastIndexOf(".");//returns -1 if "." not present
		if(isDotPresent!=-1) {
			String extension= absolutePath.substring(absolutePath.lastIndexOf(".")+1);
			return extension;
		}
		return null;		
	}

}

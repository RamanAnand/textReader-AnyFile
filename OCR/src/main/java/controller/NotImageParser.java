package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;

import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class NotImageParser {

	public static void getContents(File selectedFile, String outputFolder) throws IOException, SAXException, TikaException {
		// TODO Auto-generated method stub
		System.out.print("Contents extraction by TIKA parse() in progress...\n");
		Parser parser = new AutoDetectParser(); 
		
		ContentHandler handler = new BodyContentHandler(-1); 
		Metadata metadata = new Metadata();
		InputStream stream = TikaInputStream.get(selectedFile);
		ParseContext context = new ParseContext();		
		parser.parse(stream, handler, metadata, context);

		BufferedReader reader = new BufferedReader(new StringReader(handler.toString()));
		/*
		 * below code is to keep the text file  with white spaces and new lines
		 */
		
		PrintWriter writer = new PrintWriter(new FileWriter(outputFolder+"\\"+selectedFile.getName()+".txt"));
		reader.lines().forEach(line -> writer.println(line));
		writer.close();
		System.out.println("file written into "+outputFolder);

	}

}

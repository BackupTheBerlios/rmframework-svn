package com.epac.java.converter.fm2prop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.DocumentException;

public class Main {
	
	public static void main(String[] args) {
		
		if (args.length != 2) {
			System.err.println(getCommandLineUsage());
			System.exit(3);
		}
		
		checkFileNotExist(args[0]);
		checkDirNotExist(args[1]);
		
		XmlLoader xmlLoader = null;
		SectionHandler sectionHandler = new SectionHandler();
		
		try {
			xmlLoader = new XmlLoader(args[0]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(4);
		} catch (DocumentException e) {
			e.printStackTrace();
			System.exit(4);
		}
		
		xmlLoader.parseXml(sectionHandler);
		System.out.println(sectionHandler.getPropertiesAsString());
		
		// write string to file
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
			out.write(sectionHandler.getPropertiesAsString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error: Can't write to file "+args[1]);
			System.exit(5);
		}
		
	}
	
	private static String getCommandLineUsage() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Wrong command line arguments!").append(getNewline());
		sb.append("Usage: java -jar fm2propConverter.jar sourceFile targetFile").append(getNewline());
		sb.append("Reads the <sourceFile> which is the xml and converts it to the <targetFile>.").append(getNewline());
		sb.append("The <targetFile> will be written to targetFile");
		
		return sb.toString();
	}
	
	private static String getFileNotExist(String file) {
		StringBuffer sb = new StringBuffer();
		sb.append("The file ").append(file).append(" doesn't exist.").append(getNewline());
		return sb.toString();
	}
	
	private static StringBuffer getNewline() {
		return new StringBuffer("\n");
	}
	
	private static void checkFileNotExist(String fileString) {
		File sourceFile = new File(fileString);
		if (! sourceFile.exists()) {
			System.err.println(getFileNotExist(fileString));
			System.exit(2);
		}
	}
	
	private static void checkDirNotExist(String fileString) {
		File sourceFile = new File(fileString);
		
		try {
			sourceFile.getCanonicalPath();
		} catch (IOException e) {
			System.err.println(getFileNotExist(fileString));
			System.exit(2);
		}
	}

}

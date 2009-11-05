package com.epac.java.converter.ms2text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.eventusermodel.MissingRecordAwareHSSFListener;
import org.apache.poi.hssf.eventusermodel.EventWorkbookBuilder.SheetRecordCollectingListener;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class Main {
	
	public static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			logger.info("Argument "+i+":"+args[i]);
		}
		
		System.out.println("Starting with argument 0 = "+args[0]);
		
		if (args.length != 2) {
			System.err.println(getCommandLineUsage());
			System.exit(3);
		}
		
		checkFileNotExist(args[0]);
		checkDirNotExist(args[1]);
		
		POIFSFileSystem fs = null;
		try {
			FileInputStream inputStream = new FileInputStream(args[0]);
			fs = new POIFSFileSystem(inputStream);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		XlsHSSFListener xlsListener = new XlsHSSFListener("\t");
		MissingRecordAwareHSSFListener listener = new MissingRecordAwareHSSFListener(xlsListener);
		FormatTrackingHSSFListener formatListener = new FormatTrackingHSSFListener(listener);
		HSSFEventFactory factory = new HSSFEventFactory();
		HSSFRequest request = new HSSFRequest();
		
		boolean outputFormulaValues = true;
		
		if (outputFormulaValues) {
			request.addListenerForAllRecords(listener);
		} else {
			SheetRecordCollectingListener workbookBuildingListener = new SheetRecordCollectingListener(formatListener);
			request.addListenerForAllRecords(workbookBuildingListener);
		}
		
		try {
			factory.processWorkbookEvents(request, fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		List<String> valueList = xlsListener.getValueList();
		logger.info("valueList: "+ valueList.size());
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
			for (String s : valueList) {
				out.write(s + "\n");
			}
		} catch (IOException e) {
			logger.error("Can't write to file "+args[1]);
			System.exit(5);
		}
		System.exit(0);
	}
	
	private static String getCommandLineUsage() {
		StringBuffer sb = new StringBuffer();
		sb.append("Wrong command line arguments!").append(getNewline());
		sb.append("Usage: java -jar MS2TextConverter.jar sourceFile targetFile").append(getNewline());
		sb.append("Reads the <sourceFile> which is the Microsoft Source File and converts it to the <targetFile>.").append(getNewline());
		sb.append("The <targetFile> will be written to targetFile");
		sb.append("Result Codes: ").append(getNewline());
		sb.append("2: File doesn't exist.").append(getNewline());
		sb.append("3: Wrong number of arguments.").append(getNewline());
		sb.append("5: Can't write to output file.");
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

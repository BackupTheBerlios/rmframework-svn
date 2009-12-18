package com.epac.java.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.cli.CommandLine;

/**
 * 
 * System.exit:
 * 2: File doesn't exist
 * 
 * @author heikok
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		
		int minAppearance = 10;
		
		CommandLineConfig clConfig = new CommandLineConfig(args);
		clConfig.createOptions();
		CommandLine line = clConfig.createCommandLine();
		
		if (line.hasOption("help")) {
			clConfig.printHelp(true);
		}
		
		if (line.hasOption("showArgs")) {
			clConfig.printArguments(true);
		}
		
		if (line.hasOption("minAppearance")) {
			System.out.println(line.getOptionValue("minAppearance"));
			minAppearance = new Integer(line.getOptionValue("minAppearance"));
		}
		
		
		String fileName = line.getOptionValue("file");
		String outFileName = line.getOptionValue("outFile");
		if (fileName == null) {
			clConfig.printHelp(true);
		}
		
		if (outFileName != null && fileName == null) {
			clConfig.printHelp(true);
		}
		
		checkFileNotExist(fileName);
		
		Action action = new Action();
		
		if (minAppearance >= action.getLFCount(fileName)) {
			System.out.println("Not enough CRs. Mininum default is 10. Or change by -appearance command line switch.");
			System.exit(0);
		}

		
		if (line.hasOption("showByte")) {
			action.showByte(fileName, line.getOptionValue("showByte"));
			System.exit(0);
		}
		
		try {
			List<Integer> outputList = action.convertInput(fileName);
			FileOutputStream oStream = new FileOutputStream(outFileName);
			
			for (int i = 0; i < outputList.size(); i++) {
				oStream.write(outputList.get(i).intValue());
			}
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
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
		if (!sourceFile.exists()) {
			System.err.println(getFileNotExist(fileString));
			System.exit(2);
		}
	}
}

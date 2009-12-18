package com.epac.java.converter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


/**
 * System exit:
 * 
 * 0: Success
 * 11: CommandLine parsing failed
 * @author heikok
 *
 */
public class CommandLineConfig {
	
	private String[] args;
	private Options options;
	
	public CommandLineConfig(String[] args) {
		this.args = args;
	}
	
	@SuppressWarnings("static-access")
	public Options createOptions() {
		
		options = new Options();
		Option help = new Option("help", "print this message");
		Option showArgs = new Option("showArgs", "shows all command line arguments");
		Option file = OptionBuilder.withArgName("fileName").hasArg().withDescription("file name to check for special CR character").create("file");
		Option outFile = OptionBuilder.withArgName("fileName").hasArg().withDescription("file name to write the converted output to").create("fileOut");
		Option appearance = OptionBuilder.withArgName("amount").hasArg().withDescription("minimum amount of CRs in file required (default 10)").create("minAppearance");
		Option showByte = OptionBuilder.withArgName("amount").hasArg().withDescription("show amount of bytes of the file").create("showByte");
		//Option appearance = new Option("minAppearance", "minimum amount of CRs in file required (default 10)");
		options.addOption(help);
		options.addOption(showArgs);
		options.addOption(showByte);
		options.addOption(appearance);
		options.addOption(file);
		options.addOption(outFile);
		
		return options;
	}
	
	public CommandLine createCommandLine() {
		CommandLineParser parser = new GnuParser();
		CommandLine line = null;
		try {
			line = parser.parse(options, args);
		} catch (ParseException exp) {
			System.err.println("Parsing failed. Reason: "+exp.getMessage());
			System.exit(11);
		}
		return line;
	}
	
	public void printArguments(boolean sysExit) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("Argument " + i + ":" + args[i]);
		}
		if (sysExit) System.exit(0);
	}
	
	public void printHelp(boolean sysExit) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(getCommandLineSyntax(), getOptions());
		if (sysExit) System.exit(0);
	}
	
	public String getCommandLineSyntax() {
		String syntax = "ConvertCR2LF: Converts the Carriage Returns (CR) of a file to Line Feeds (LF)";
		return syntax;
	}
	
	public Options getOptions() {
		return options;
	}

}

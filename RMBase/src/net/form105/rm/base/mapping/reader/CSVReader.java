package net.form105.rm.base.mapping.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import net.form105.rm.base.Agent;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.mapping.DefaultMapperControl;
import net.form105.rm.server.i18n.BaseMessage;

public class CSVReader implements ISequenceReader {

	private String file;
	private BufferedReader reader;
	private String delimiter = "\t";
	private DefaultMapperControl control;
	private List<String> currentSequence;

	public CSVReader(String file, DefaultMapperControl control) {
		this.control = control;
		
		String configPath = Agent.getRMProperty("server.import.folder");
		if (! configPath.endsWith(File.separator)) {
			configPath = configPath + File.separator;
		}
		
		this.file = configPath + file;
		
	}

	public void readCSV() throws FileNotFoundException {
		FileReader fReader = new FileReader(file);
		reader = new BufferedReader(fReader);
	}

	public void open() {
		try {
			FileReader fReader = new FileReader(file);
			reader = new BufferedReader(fReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see net.form105.rm.base.mapping.reader.IMapperReader#readSequence()
	 */
	public List<String> readSequence() {
		return currentSequence;
	}
	
	public String getTemplateId() {
		return "CSV_TEMPLATE";
	}
	
	public void importAll() {
		
		try {
			readCSV();
		} catch (FileNotFoundException e) {
			String[] parameters = new String[] {file};
			throw new RMException(new BaseMessage(), "exception.fileNotFound", parameters );
		}
		
		String line;
		
		try {
		
		while ((line = reader.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, delimiter);
			ArrayList<String> tokenList = new ArrayList<String>();
			while (st.hasMoreTokens()) {
				tokenList.add(st.nextToken());
			}
			currentSequence = tokenList;
			control.map(this);
		}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}

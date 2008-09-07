package net.form105.rm.base.mapping.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import net.form105.rm.base.mapping.MapperControl;

public class CSVReader implements IMapperReader {

	private String file;
	private BufferedReader reader;
	private String delimiter;
	private MapperControl control;
	private List<String> currentSequence;

	public CSVReader(String file, MapperControl control) {
		this.file = file;
		this.control = control;
	}

	public void readCSV(String file) throws FileNotFoundException {
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
		return "CSV_SEQUENCE_TEMPLATE";
	}
	
	public void importAll() {
		
		String line;
		
		try {
		
		while ((line = reader.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, delimiter);
			ArrayList<String> tokenList = new ArrayList();
			while (st.hasMoreTokens()) {
				tokenList.add(st.nextToken());
			}
			control.map(this);
		}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}

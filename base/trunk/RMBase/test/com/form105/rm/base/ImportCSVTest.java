package com.form105.rm.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ImportCSVTest {

	private String[][] numbers = new String[24][24];
	private File file = new File("something.csv");

	public ImportCSVTest() {
	}

	public void importCSV() {

		BufferedReader bufRdr;
		try {
			bufRdr = new BufferedReader(new FileReader(file));
			String line = null;
			int row = 0;
			int col = 0;

			// read each line of text file
			while ((line = bufRdr.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				while (st.hasMoreTokens()) {
					// get next token and store it in the array
					numbers[row][col] = st.nextToken();
					col++;
				}
				row++;
			}

			// close the file
			bufRdr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}

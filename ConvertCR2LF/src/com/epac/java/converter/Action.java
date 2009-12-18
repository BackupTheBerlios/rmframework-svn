package com.epac.java.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Action {
	
	
	public void showByte(String fileName, String amount) {
		int i;
		int b = 0;
		int intAmount = new Integer(amount).intValue();
		FileInputStream iStream;
		try {
			File file = new File(fileName);
			iStream = new FileInputStream(file);
			
			for (i = 0; (i <= intAmount) && (b = iStream.read()) != -1 ; i++) {
				System.out.print(b+" ");
			}
			
			iStream.close();
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public int getLFCount(String fileName) {
		int apperance = 0;
		int b = 0;
		
		FileInputStream iStream;
		try {
			File file = new File(fileName);
			iStream = new FileInputStream(file);
			
			while ((b = iStream.read()) != -1) {
				if (b == 13) {
					apperance++;
				}
			}
			
			iStream.close();
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return apperance;
		
	}
	
	public List<Integer> convertInput(String fileName) {
		int b = 0;
		List<Integer> intArray = new ArrayList<Integer>();
		
		FileInputStream iStream;
		try {
			File file = new File(fileName);
			iStream = new FileInputStream(file);
			
			while ((b = iStream.read()) != -1) {
				if (b == 13) {
					intArray.add(10);
				} else {
					intArray.add(b);
				}
			}
			
			iStream.close();
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return intArray;
	}
	
	public void writeBack(String fileName, List<Integer> intList) {
		
		FileOutputStream oStream;
		try {
			File file = new File(fileName);
			oStream = new FileOutputStream(file);
			
			for (int i = 0; i < intList.size(); i++) {
				oStream.write(intList.get(i));
			}
			
			oStream.flush();
			oStream.close();
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}

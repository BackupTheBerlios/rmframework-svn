/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.form105.rm.base;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;
import org.junit.Test;


public class Snippet {
	
	
	public void run() {
		DOMReader reader = new DOMReader();
		
		SAXReader xmlReader = new SAXReader();
		try {
			Document document = xmlReader.read("my.xml");
			Element rootElement = document.getRootElement();
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void testReference() {
		String s = "heiko";
		int i = 0;
		MyClass myClass = new MyClass(s, i);
		System.out.println(myClass.getS() +":"+ myClass.getI());
		
		s = "heikoNew";
		i= 1;
		System.out.println(myClass.getS() +":"+ myClass.getI());
		
	}
	
	public class MyClass {
		
		public String s;
		/**
		 * @return the s
		 */
		public String getS() {
			return s;
		}

		/**
		 * @param s the s to set
		 */
		public void setS(String s) {
			this.s = s;
		}

		/**
		 * @return the i
		 */
		public int getI() {
			return i;
		}

		/**
		 * @param i the i to set
		 */
		public void setI(int i) {
			this.i = i;
		}

		public int i;
		
		public MyClass(String s, int i) {
			this.s = s;
			this.i = i;
		}
	}

}

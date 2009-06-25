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
package com.form105.rm.base.math;

import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.junit.Test;


public class BigIntegerTest {
	
	private static Logger logger = Logger.getLogger(BigIntegerTest.class);
	
	@Test
	public void createBigInteger() {
		
		byte[] identIntSequence = new byte[8];
		
		identIntSequence[0] = 0;
		identIntSequence[1] = 0;
		identIntSequence[2] = 0;
		identIntSequence[3] = 0;
		identIntSequence[4] = 0;
		identIntSequence[5] = 0;
		identIntSequence[6] = 1;
		identIntSequence[7] = 1;
		
		BigInteger bInt = new BigInteger(identIntSequence);
		
		logger.info(bInt);
	}

}

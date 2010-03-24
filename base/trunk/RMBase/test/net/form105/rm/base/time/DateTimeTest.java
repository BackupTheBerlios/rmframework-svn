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
package net.form105.rm.base.time;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.junit.Test;


public class DateTimeTest {
	
	@Test
	public void showDateTime() {
		
		DateTimeFormatter dtFormatter = ISODateTimeFormat.dateTime();
		String time = dtFormatter.print(System.currentTimeMillis());
		System.out.println("Current time: "+time);
		
		
		String isoTimeAsString = "2008-10-02T17:45:22.000+02:00";
		DateTime dt = dtFormatter.parseDateTime(isoTimeAsString);
		
		System.out.println(dtFormatter.print(dt));
		
		PeriodFormatter parser = ISOPeriodFormat.standard();
		Period period = parser.parsePeriod("P2W");
		System.out.print(period.getWeeks());
		
	}

}

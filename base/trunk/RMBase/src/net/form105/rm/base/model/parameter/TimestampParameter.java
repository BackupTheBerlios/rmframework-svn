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
package net.form105.rm.base.model.parameter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class TimestampParameter extends AbstractParameter<DateTime> {

	private static final long serialVersionUID = 1L;
	
	private DateTime dateTime;
	
	@Override
	public DateTime getParameterValue() {
		return dateTime;
	}

	@Override
	public String getValueAsString() {
		DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
		return fmt.print(dateTime);
	}

	public void setParameterValue(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public void setParameterValue(Long timestamp) {
		DateTime dateTime = new DateTime(timestamp);
		this.dateTime = dateTime;		
	}
}

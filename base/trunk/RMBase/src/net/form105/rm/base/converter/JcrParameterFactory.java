/*
 * Copyright (c) 2010, form105 Heiko Kundlacz
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
package net.form105.rm.base.converter;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

import net.form105.rm.base.exception.ConvertingToParameterException;
import net.form105.rm.base.exception.JcrConnectionException;
import net.form105.rm.base.model.parameter.BooleanParameter;
import net.form105.rm.base.model.parameter.FloatParameter;
import net.form105.rm.base.model.parameter.IParameter;
import net.form105.rm.base.model.parameter.LongParameter;
import net.form105.rm.base.model.parameter.StringParameter;
import net.form105.rm.base.model.parameter.TimestampParameter;

import org.joda.time.DateTime;

public class JcrParameterFactory implements IParameterFactory {

	enum ParameterType {
		NoType, StringParameter, LongParameter, TimestampParameter, FloatParameter, BooleanParameter;

		private ParameterType() {

		}

		public static ParameterType getObjectByString(String name) {
			for (ParameterType type : ParameterType.values()) {
				if (type.name().equals(name)) {
					return type;
				}
			}
			return NoType;
		}
	}

	public IParameter getParameter(Object source) {
		Node node = (Node) source;
		IParameter parameter = null;
		try {
			Property property = node.getProperty("ParameterType");
			ParameterType paramType = ParameterType.getObjectByString(property.getString());
			
			switch (paramType) {
			case StringParameter:
				StringParameter sParameter = new StringParameter();
				sParameter.setParameterValue(node.getProperty("Value").getString());
				parameter = sParameter;
				break;
				
			case LongParameter:
				LongParameter lParameter = new LongParameter();
				lParameter.setParameterValue(node.getProperty("Value").getLong());
				parameter = lParameter;
				break;
				
			case TimestampParameter:
				TimestampParameter tParameter = new TimestampParameter();
				tParameter.setParameterValue(new DateTime(node.getProperty("Value").getLong()));
				parameter = tParameter;
				break;
			case FloatParameter:
				FloatParameter fParameter = new FloatParameter();
				fParameter.setParameterValue(node.getProperty("Value").getDecimal());
				parameter = fParameter;
				break;
			case BooleanParameter:
				BooleanParameter bParameter = new BooleanParameter();
				bParameter.setParameterValue(node.getProperty("Value").getBoolean());
				parameter = bParameter;
				break;
			default:
				break;
			}
		} catch (ValueFormatException e) {
			throw new ConvertingToParameterException(parameter);
		} catch (RepositoryException e) {
			throw new JcrConnectionException();
		}
		
		return parameter;
	}
}

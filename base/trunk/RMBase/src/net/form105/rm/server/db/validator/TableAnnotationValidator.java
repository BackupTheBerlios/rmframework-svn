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
package net.form105.rm.server.db.validator;

import net.form105.rm.base.db.AbstractDBEntity;
import net.form105.rm.base.db.MappingTable;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.server.i18n.BaseI18NMessage;

public class TableAnnotationValidator implements IEntityValidator {

	@Override
	public boolean isValid(AbstractDBEntity entity) {

		MappingTable classAnnotation = entity.getClass().getAnnotation(MappingTable.class);
		
		if (classAnnotation == null) {
			throw new RMException(new BaseI18NMessage(), "validator.entity.mappingTable.exist", new String[] {entity.getClass().getName()});
		}

		return true;
	}

}

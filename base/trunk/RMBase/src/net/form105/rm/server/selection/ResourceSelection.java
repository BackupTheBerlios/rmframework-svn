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
package net.form105.rm.server.selection;

import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.resource.AbstractAgentObjectDao;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.Resource;
import net.form105.rm.base.selection.AbstractSelection;

public class ResourceSelection extends AbstractSelection<Resource> {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    @Override
    public List<Resource> select() {
        ILookup daoLookup = Agent.getDaoLookup();
        AbstractAgentObjectDao<Resource> dao = (AbstractAgentObjectDao<Resource>) daoLookup.getFirstContentObject(Resource.class);
        List<Resource> resourceList = dao.getReadDao().findAll();
        return resourceList;
    } 

}

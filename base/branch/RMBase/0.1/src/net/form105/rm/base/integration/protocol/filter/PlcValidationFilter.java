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
package net.form105.rm.base.integration.protocol.filter;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;

public class PlcValidationFilter extends IoFilterAdapter {
    
    public boolean isValid(IoBuffer buffer) {
        
        return true;
    }
    
    public void messageReceived(NextFilter nextFilter, IoSession session,
            Object message) throws Exception {
        
        IoBuffer buffer = (IoBuffer) message;
        
        // validate messageHeader
        
        if (isValid(buffer)) {
            
        }
        nextFilter.messageReceived(session, message);
    }

}

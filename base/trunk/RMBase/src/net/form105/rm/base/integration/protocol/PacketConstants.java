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
package net.form105.rm.base.integration.protocol;

public class PacketConstants {
	
	// Packet Type
	public static int PacketType_Control = 1;
	public static int PacketType_Acknoledge = 2;
	public static int PacketType_ErrorMessage = 3;
	public static int PacketType_StatusMessage = 4;
	
	// Packet Source
	public static int PacketSource_Plc1 = 1;
	public static int PacketSource_Plc2 = 2;
	public static int PacketSource_Plc3 = 3;
	public static int PacketSource_Plc4 = 4;
	
	// Packet Sink
	public static int PacketSource_RM1 = 101;
	public static int PacketSource_RM2 = 102;
	
	// Packet End
	public static int PacketEnd = 0xFFFFFFFF;
	
	
	
	

}

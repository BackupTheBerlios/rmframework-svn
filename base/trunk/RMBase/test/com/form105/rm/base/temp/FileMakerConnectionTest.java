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
package com.form105.rm.base.temp;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLWarning;

import org.junit.Before;
import org.junit.Test;

public class FileMakerConnectionTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void connect() {
        try {
            Driver driver = (Driver) Class.forName("com.ddtek.jdbc.sequelink.SequeLinkDriver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:sequelink://192.168.3.37:2399;serverDataSource=rm;DBUser=Admin;DBPassword=admin");
            //Connection connection = DriverManager.getConnection("jdbc:sequelink://192.168.3.37:2399;user=Admin;password=admin;serverDataSource=rm");
            SQLWarning warning = connection.getWarnings();
            if (warning != null) {
                System.out.println(warning);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

}

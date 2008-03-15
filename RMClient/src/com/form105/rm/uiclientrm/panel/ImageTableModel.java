/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.uiclientrm.panel;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author heiko
 */
public class ImageTableModel extends AbstractTableModel {
    
    private final Object rowData[][] = {
        {"1", "one", "ichi", "un", "I"},
        {"2", "two", "ni", "deux", "II"},
        {"3", "three", "san", "trois", "III"},
        {"4", "four", "shi", "quatre", "IV"},
        {"5", "five", "go", "cinq", "V"},
        {"6", "six", "roku", "treiza", "VI"},
        {"7", "seven", "shichi", "sept", "VII"}
    };
    
    private final String rowColumn[] = {
        "1. Column", "2. Column", "3. Column", "4. Column", "5. Column"
    };

    public int getRowCount() {
        return rowData.length;
    }

    public int getColumnCount() {
        return rowColumn.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return (String) rowColumn[column];
    }

    public Object getValueAt(int arg0, int arg1) {
        return rowData[arg0][arg1];
    }

}

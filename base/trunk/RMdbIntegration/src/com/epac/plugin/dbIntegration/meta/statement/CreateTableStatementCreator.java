package com.epac.plugin.dbIntegration.meta.statement;

import java.util.List;

import com.epac.plugin.dbIntegration.mapping.statement.StatementConstant;
import com.epac.plugin.dbIntegration.meta.IMetaColumn;
import com.epac.plugin.dbIntegration.meta.MetaTable;

public class CreateTableStatementCreator {
	
	private MetaTable metaTable;
	
	public CreateTableStatementCreator(MetaTable metaTable) {
		this.metaTable = metaTable;
	}
	
	public StringBuffer getStatement() {
		return createTablePart().append(createColumnPart());
	}
	
	private StringBuffer createTablePart() {
		StringBuffer sb = new StringBuffer();
		sb.append(StatementConstant.CREATE_STRING).append(StatementConstant.BLANK_STRING); // Create
		sb.append(StatementConstant.TABLE_STRING).append(StatementConstant.BLANK_STRING); // Table
		sb.append(metaTable.getId()).append(StatementConstant.BLANK_STRING); // Table name
		return sb;
	}
	
	private StringBuffer createColumnPart() {
		StringBuffer sb = new StringBuffer();
		List<IMetaColumn> colList = metaTable.getColumnList();
		if (colList.size() == 0) {
			return sb;
		}
		
		sb.append(StatementConstant.LEFT_PARENTHESES);
		
		StringBuffer colSb = new StringBuffer();
		
		
		for (int i=0; i < colList.size(); i++) {
			String colId = colList.get(i).getId();
			String colType = colList.get(i).getType().name();
			int colSize = colList.get(i).getSize();
			boolean hasSize = colList.get(i).hasSize();
			
			colSb.append(colId).append(StatementConstant.BLANK_STRING); // column name
			colSb.append(colType).append(StatementConstant.BLANK_STRING); // column type

			if (hasSize) {
				colSb.append(StatementConstant.LEFT_PARENTHESES); // (
				colSb.append(colSize); // size
				colSb.append(StatementConstant.RIGHT_PARENTHESES); // )
			}
			
			colSb.append(StatementConstant.COMMA); //
		}
		
		// remove last comma
		colSb.deleteCharAt(colSb.length() - 1);
		
		sb.append(colSb);
		sb.append(StatementConstant.RIGHT_PARENTHESES);
		return sb;
	}

}

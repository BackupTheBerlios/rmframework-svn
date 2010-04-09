package com.epac.plugin.dbIntegration.meta.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epac.plugin.dbIntegration.mapping.statement.StatementConstant;
import com.epac.plugin.dbIntegration.meta.IMetaColumn;
import com.epac.plugin.dbIntegration.meta.MetaColumn;
import com.epac.plugin.dbIntegration.meta.MetaType;
import com.epac.plugin.dbIntegration.meta.NullMetaColumn;
import com.epac.plugin.dbIntegration.meta.converter.IDBConverter;
import com.epac.plugin.dbIntegration.meta.converter.ReservedKeywords;

public class InsertDataStatementCreator {
	
	public static Logger logger = Logger.getLogger(InsertDataStatementCreator.class);

	private MetaColumn metaCol;
	// includes columnId/value
	private Map<IMetaColumn, String> valueMap;
	private IDBConverter colConv;
	private ReservedKeywords keywords = new ReservedKeywords();

	public InsertDataStatementCreator(Map<IMetaColumn, String> valueMap, IDBConverter colConv) {
		this.valueMap = valueMap;
		this.colConv = colConv;
	}

	public StringBuffer getStatement() {

		ReservedKeywords keywords = new ReservedKeywords();

		StringBuffer stmtSb = new StringBuffer();

		StringBuffer colSb = new StringBuffer();
		StringBuffer valuesSb = new StringBuffer();

		Iterator<IMetaColumn> iter = valueMap.keySet().iterator();
		IMetaColumn mCol = new NullMetaColumn();
		while (iter.hasNext()) {

			mCol = iter.next();

			if (valueMap.get(mCol) == null)
				continue;

			if (mCol.getType() == MetaType.TIMESTAMP || mCol.getType() == MetaType.DATETIME
					&& valueMap.get(mCol) != null) {
				valuesSb.append(StatementConstant.LEFT_CURLYBRACE);
			} else {
				valuesSb.append(StatementConstant.SINGLE_QUOTE);
			}
			// check if column name is a reserved keyword - if so, append a
			// identifier
			String id = keywords.prepareKeyword(mCol.getId());

			String value = "";
			if (valueMap.get(mCol) != null) {
				value = valueMap.get(mCol);
			}
			colSb.append(id).append(StatementConstant.COMMA);
			;

			valuesSb.append(value);
			if (mCol.getType() == MetaType.TIMESTAMP || mCol.getType() == MetaType.DATETIME
					&& valueMap.get(mCol) != null) {
				valuesSb.append(StatementConstant.RIGHT_CURLYBRACE);
			} else {
				valuesSb.append(StatementConstant.SINGLE_QUOTE);
			}
			valuesSb.append(StatementConstant.COMMA);
		}

		colSb.deleteCharAt(colSb.length() - 1);
		valuesSb.deleteCharAt(valuesSb.length() - 1);

		stmtSb.append(StatementConstant.INSERT_STRING).append(StatementConstant.BLANK_STRING);
		stmtSb.append(StatementConstant.INTO_STRING).append(StatementConstant.BLANK_STRING);
		stmtSb.append(mCol.getTable().getId()).append(StatementConstant.BLANK_STRING); // tableId

		stmtSb.append(StatementConstant.LEFT_PARENTHESES).append(StatementConstant.BLANK_STRING);
		stmtSb.append(colSb); // columns
		stmtSb.append(StatementConstant.RIGHT_PARENTHESES).append(StatementConstant.BLANK_STRING);

		stmtSb.append(StatementConstant.VALUES_STRING);
		stmtSb.append(StatementConstant.LEFT_PARENTHESES).append(StatementConstant.BLANK_STRING);
		stmtSb.append(valuesSb); // columns
		stmtSb.append(StatementConstant.RIGHT_PARENTHESES).append(StatementConstant.BLANK_STRING);

		return stmtSb;

	}

	public PreparedStatement preparedStatement(Connection con) throws SQLException {

		//ReservedKeywords keywords = new ReservedKeywords();
		StringBuffer stmtSb = new StringBuffer();
		
		Object[] colArray = valueMap.keySet().toArray();
		
		
		StringBuffer colSb = new StringBuffer();
		StringBuffer valueSb = new StringBuffer();
		IMetaColumn mCol = new NullMetaColumn();
		
		for (int i = 0; i < colArray.length; i++) {
			
			String colname = keywords.prepareKeyword(((IMetaColumn) colArray[i]).getId());
			colSb.append(colname).append(StatementConstant.COMMA);
			valueSb.append("?,");
		}
		colSb.deleteCharAt(colSb.length() - 1);
		valueSb.deleteCharAt(valueSb.length() - 1);
		
		stmtSb.append(StatementConstant.INSERT_STRING).append(StatementConstant.BLANK_STRING);
		stmtSb.append(StatementConstant.INTO_STRING).append(StatementConstant.BLANK_STRING);
		stmtSb.append(((IMetaColumn)colArray[0]).getTable().getId()).append(StatementConstant.BLANK_STRING);
		stmtSb.append(StatementConstant.LEFT_PARENTHESES).append(StatementConstant.BLANK_STRING);
		stmtSb.append(colSb.toString()).append(StatementConstant.BLANK_STRING);
		stmtSb.append(StatementConstant.RIGHT_PARENTHESES).append(StatementConstant.BLANK_STRING);
		stmtSb.append(StatementConstant.VALUES_STRING).append(StatementConstant.BLANK_STRING);
		
		stmtSb.append(StatementConstant.LEFT_PARENTHESES).append(StatementConstant.BLANK_STRING);
		stmtSb.append(valueSb.toString()).append(StatementConstant.BLANK_STRING);
		stmtSb.append(StatementConstant.RIGHT_PARENTHESES).append(StatementConstant.BLANK_STRING);
		
		PreparedStatement stmt = con.prepareStatement(stmtSb.toString());
		
		String millis = null;
		
		for (int i = 0; i < colArray.length; i++) {
			MetaType type = ((IMetaColumn) colArray[i]).getType();
			mCol = (IMetaColumn) colArray[i];;
			
			MetaType convertedType = MetaType.valueOf(colConv.convert(type.name()));
			
			if (valueMap.get(colArray[i]) == null) {
				stmt.setNull(i + 1, convertedType.getDataType());
				//stmt.setString(i + 1, "");
				continue;
			}
			
			switch (type) {
			case DATETIME:

				millis = valueMap.get(colArray[i]);
				stmt.setTimestamp(i + 1, new Timestamp(new Long(millis).longValue()));
				break;
				
			case TIMESTAMP:

				millis = valueMap.get(colArray[i]);
				stmt.setTimestamp(i + 1, new Timestamp(new Long(millis).longValue()));
				break;
				
			case DOUBLE:
				stmt.setDouble(i + 1, new Double(valueMap.get(colArray[i])).doubleValue());

			default:

				stmt.setString(i + 1, valueMap.get(colArray[i]));
				break;
			}
		}

		return stmt;

	}

}

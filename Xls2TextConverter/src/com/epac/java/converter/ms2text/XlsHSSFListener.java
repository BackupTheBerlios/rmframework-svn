package com.epac.java.converter.ms2text;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingCellDummyRecord;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.BoolErrRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.RKRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.StringRecord;

public class XlsHSSFListener implements HSSFListener {
	
	public static Logger logger = Logger.getLogger(XlsHSSFListener.class);
	
	private String id = "XLS";
	private SSTRecord sstRecord = null;
	
	private List<String> valueList = new ArrayList<String>();
	private String lineValue = "";
	private boolean rowIsEmpty = true;;
	private String delemiter;
	
	
	public XlsHSSFListener(String delemiter) {
		this.delemiter = delemiter;
		valueList.add(id);
	}

	public void processRecord(Record record) {
		
		int row = -1;
		int col = -1;
		String value = null;
		
		
		switch (record.getSid()) {
		
		case BoundSheetRecord.sid:
			logger.info(record.toString());
			break;
		case BOFRecord.sid:
			BOFRecord bofRecord = (BOFRecord) record;
			logger.info(bofRecord.toString());
			break;
		case SSTRecord.sid:
			logger.info("SSTRecord");
			sstRecord = (SSTRecord) record;
			sstRecord.toString();
			break;

		case BlankRecord.sid:
			// used if the cell is empty
			BlankRecord blancRecord = (BlankRecord) record;
			//row = blancRecord.getRow();
			//col = blancRecord.getColumn();
			break;
		case BoolErrRecord.sid:
			logger.info("BoolErrRecord");
			break;

		case FormulaRecord.sid:
			logger.info("FormulaRecord");
			break;
		case StringRecord.sid:
			logger.info("StringRecord");
			break;

		case LabelRecord.sid:
			logger.info("LabelRecord");
			break;
		case LabelSSTRecord.sid:
			LabelSSTRecord lsrec = (LabelSSTRecord) record;

			row = lsrec.getRow();
			col = lsrec.getColumn();
			if(sstRecord == null) {
				value = "(No SST Record, can't identify string)";
			} else {
				value = sstRecord.getString(lsrec.getSSTIndex()).toString();
			}
			logger.info("value: "+value);
			
			break;

		case NoteRecord.sid:
			logger.info("SSTRecord");
			break;
		case NumberRecord.sid:
			logger.info("NumberRecord");
			break;
		case RKRecord.sid:
			logger.info("RKRecord");
			break;
		default:
			break;
		}

		
		// Handle missing column
		if(record instanceof MissingCellDummyRecord) {
			MissingCellDummyRecord mc = (MissingCellDummyRecord)record;
			row = mc.getRow();
			col = mc.getColumn();
			logger.info("last cell dummy record");
		}
		
		if (col > 0) {
			lineValue = lineValue + delemiter;
		}
		
		if (value != null && value != "" && ! (record instanceof LastCellOfRowDummyRecord) ) {
			lineValue = lineValue + value;
			rowIsEmpty = false;
		} else {
			
		}
		
		if(record instanceof LastCellOfRowDummyRecord) {
			// write empty lines only
			if (! rowIsEmpty) {
				valueList.add(lineValue);
			}
			lineValue = "";
			rowIsEmpty = true;
		} 
		
	}
	
	public List<String> getValueList() {
		return valueList;
	}
	

}

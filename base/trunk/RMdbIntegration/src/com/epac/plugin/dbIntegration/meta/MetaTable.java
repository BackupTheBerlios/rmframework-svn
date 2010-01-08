package com.epac.plugin.dbIntegration.meta;

import java.util.ArrayList;
import java.util.List;

public class MetaTable {
	
	private String id;
	private String name;
	private List<IMetaColumn> columnList = new ArrayList<IMetaColumn>();
	private List<IMetaIndex> indexList = new ArrayList<IMetaIndex>();
	
	
	public MetaTable(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * The id of the table
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * The name of the table (mostly the same than the id)
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public void addColumn(IMetaColumn column) {
		columnList.add(column);
	}
	
	/**
	 * The a column of the table by id
	 * @param id
	 * @return
	 */
	public IMetaColumn getColumnById(String id) {
		for (int i = 0; i < columnList.size(); i++) {
			if (columnList.get(i).getId().equals(id)) return columnList.get(i);
		}
		return new NullMetaColumn();
	}
	
	public void addIndex(IMetaIndex index) {
		indexList.add(index);
	}
	
	public List<IMetaColumn> getColumnList() {
		return columnList;
	}
	
	public List<IMetaIndex> getMetaIndexList() {
		return indexList;
	}

}

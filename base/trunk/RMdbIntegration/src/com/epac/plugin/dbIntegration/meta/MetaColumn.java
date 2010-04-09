package com.epac.plugin.dbIntegration.meta;

public class MetaColumn implements IMetaColumn {

	private String id;
	private String name;
	private MetaType type;
	private boolean nullable;
	private int size;
	private MetaTable table;

	public MetaColumn(MetaTable table, String id, String name, MetaType type, boolean nullable, int size) {
		this.table = table;
		this.id = id;
		this.name = name;
		this.type = type;
		this.nullable = nullable;
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see com.epac.plugin.dbIntegration.meta.IMetaColumn#getId()
	 */
	public String getId() {
		return id;
	}

	/**
	 * The name of the column (mostly the same than the id)
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.epac.plugin.dbIntegration.meta.IMetaColumn#getType()
	 */
	public MetaType getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see com.epac.plugin.dbIntegration.meta.IMetaColumn#isNullable()
	 */
	public boolean isNullable() {
		return nullable;
	}

	/* (non-Javadoc)
	 * @see com.epac.plugin.dbIntegration.meta.IMetaColumn#setNullable(boolean)
	 */
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	@Override
	public boolean hasSize() {
		if (size != -1) { return true;} else { return false; }
	}

	@Override
	public MetaTable getTable() {
		return table;
	}

}

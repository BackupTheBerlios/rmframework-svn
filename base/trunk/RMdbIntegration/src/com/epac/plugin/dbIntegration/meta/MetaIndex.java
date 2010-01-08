package com.epac.plugin.dbIntegration.meta;

public class MetaIndex implements IMetaIndex {
	
	private String id;
	private String name;
	
	
	public MetaIndex(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see com.epac.plugin.dbIntegration.meta.IMetaIndex#getId()
	 */
	public String getId() {
		return id;
	}

	/**
	 * The name of the index (mostly the same than the id)
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}

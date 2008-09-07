package net.form105.rm.base.mapping.reader;

import java.util.List;

public interface IMapperReader {
	
	public abstract String getTemplateId();

	public abstract List<String> readSequence();

}
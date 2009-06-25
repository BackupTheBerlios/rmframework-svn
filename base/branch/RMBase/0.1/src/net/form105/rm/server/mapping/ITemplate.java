package net.form105.rm.server.mapping;

import java.util.List;

import net.form105.rm.base.mapping.IField;
import net.form105.rm.base.model.ParameterizedElement;

public interface ITemplate {
	
	public abstract String getId();
	
	public abstract List<IField> getSequence();
	
	public abstract ParameterizedElement getParameterizedElement();

}

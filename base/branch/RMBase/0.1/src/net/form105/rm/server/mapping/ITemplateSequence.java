package net.form105.rm.server.mapping;

import java.util.List;

import net.form105.rm.base.mapping.IField;

public interface ITemplateSequence {

	public abstract String getId();

	public abstract List<IField> getSequenceAsList();

}
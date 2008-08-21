package net.form105.web.impl.panel;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.wicket.extensions.model.AbstractCheckBoxModel;
import org.apache.wicket.model.IModel;

/**
 * A model for checkboxes that represent a more-than-one-selection.
 * 
 * @author ivaynberg
 * 
 */
public class CheckBoxModel extends AbstractCheckBoxModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final IModel selection;
	private final Serializable token;

	/**
	 * Constructor
	 * 
	 * @param selection
	 *            model that contains a collection of tokens which will
	 *            represent selection state
	 * @param token
	 *            token whose presense in the collection represents a selection
	 *            state
	 */
	public CheckBoxModel(IModel selection, Serializable token) {
		super();
		this.selection = selection;
		this.token = token;
	}

	@Override
	public boolean isSelected() {
		List<Serializable> collection = (List<Serializable>) selection.getObject();
		return collection.contains(token);
	}

	@Override
	public void select() {
		Collection<Serializable> collection = (List) selection.getObject();
		collection.add(token);
	}

	@Override
	public void unselect() {
		List<Serializable> collection = (List) selection.getObject();
		collection.remove(token);
	}

}

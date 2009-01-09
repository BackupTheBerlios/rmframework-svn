package net.form105.web.impl.panel.filter;

public class NoFilterPanel<T> extends AbstractFilterPanel<T, Object> {

	private static final long serialVersionUID = 1L;
	
	public NoFilterPanel(String id) {
		super(id);
	}

	@Override
	protected void onFormSubmit() {
		
	}

}

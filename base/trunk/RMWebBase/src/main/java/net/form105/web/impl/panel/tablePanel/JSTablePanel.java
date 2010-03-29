package net.form105.web.impl.panel.tablePanel;

import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.markup.html.resources.JavascriptResourceReference;
import org.apache.wicket.model.IModel;

public class JSTablePanel extends Panel {
	
	private static final long serialVersionUID = 1L;

	public JSTablePanel(String id, IModel<?> model) {
		super(id, model);

	}

	
	private class JSTableBehavior extends AbstractDefaultAjaxBehavior {
		
		private static final long serialVersionUID = 1L;

		@Override
		public void renderHead(IHeaderResponse response) {
			super.renderHead(response);
			response.renderJavascriptReference(new JavascriptResourceReference(JSTablePanel.class, "omnigrid_1_2_5/omnigrid.js"));
			response.renderCSSReference(new CompressedResourceReference(JSTablePanel.class, "omnigrid_1_2_5/omnigrid.css"));
		}

		@Override
		protected void respond(AjaxRequestTarget target) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}



package net.form105.web.impl.panel.tablePanel;

import java.util.ArrayList;
import java.util.List;

import net.form105.web.base.util.JsonUtils;

import org.apache.log4j.Logger;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.markup.html.resources.JavascriptResourceReference;

public class JSTablePanel extends Panel {
	
	public static Logger logger = Logger.getLogger(JSTablePanel.class);
	
	private static final long serialVersionUID = 1L;

	public JSTablePanel(String id) {
		super(id);
		
		add(new JSTableBehavior());

	}

	
	private class JSTableBehavior extends AbstractDefaultAjaxBehavior {
		
		
		
		private static final long serialVersionUID = 1L;

		@Override
		public void renderHead(IHeaderResponse response) {
			
			super.renderHead(response);
			
			logger.info("CallbackUrl: "+getCallbackUrl());
			response.renderJavascriptReference(new JavascriptResourceReference(JSTablePanel.class, "omnigrid_1_2_5/omnigrid.js"));
			response.renderJavascriptReference(new JavascriptResourceReference(JSTablePanel.class, "omnigrid_1_2_5/CreateTable.js"));
			response.renderJavascriptReference(new JavascriptResourceReference(JSTablePanel.class, "omnigrid_1_2_5/tableHeader.js"));
			response.renderCSSReference(new CompressedResourceReference(JSTablePanel.class, "omnigrid_1_2_5/omnigrid.css"));
			//response.renderOnDomReadyJavascript("")
			
			
		}

		
		/**
		 * Data for web client:
		 * {"page":null,"total":"164","data":[{"option_id":"1","blog_id":"0","option_name":"siteurl","option_value":"http:\/\/www.omnisdata.com","autoload":"yes"},{"option_id":"2","blog_id":"0","option_name":"blogname","option_value":"Omnisdata","autoload":"yes"},{"option_id":"3","blog_id":"0","option_name":"blogdescription","option_value":"Omnisdata","autoload":"yes"},{"option_id":"4","blog_id":"0","option_name":"users_can_register","option_value":"0","autoload":"yes"},
		 */
		
		@Override
		protected void respond(AjaxRequestTarget target) {
			logger.info("Ajax event occured!");
			getRequest().getParameter("q");
			List<String> myList = new ArrayList<String>();
			myList.add("string1");
			myList.add("string2");
			myList.add("string3");
			
			
			target.appendJavascript("form105.dataSource.responseArray = " + JsonUtils.marshal(myList.toArray()) + ";");
			
			
		}
		
	}
	

}



package net.form105.web.base.template;

import java.lang.reflect.ParameterizedType;

import org.apache.wicket.markup.html.WebPage;

public class Template extends WebPage<Void> {
	
	public Template() {
		 Class clazz = (Class) ((ParameterizedType) getClass()
	                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void readGenericType() {
		
		
		
	}

}

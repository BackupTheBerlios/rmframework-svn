package net.form105.web.base.jetty;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class EomMessageHandler extends AbstractHandler {

	public static Logger logger = Logger.getLogger(EomMessageHandler.class);
	
	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = baseRequest.getSession();
		
		HttpSession servletSession = request.getSession();
		
		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String header = request.getHeader(name);
			logger.info("request header: "+header);
		}
		
		
	}

}

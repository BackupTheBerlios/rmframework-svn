package net.form105.web.base.jetty;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.eclipse.jetty.servlets.MultiPartFilter;

public class EomMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static Logger logger = Logger.getLogger(EomMessageServlet.class);

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("do post invoked");
		
		
		BufferedReader reader = req.getReader();
		String line;
		while ( (line = reader.readLine()) != null) {
			logger.info("line: "+line);
		}
		
		logger.info("upload: "+req.getParameter("fileupload"));
		Enumeration<String> names = req.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			logger.info(name+":"+req.getHeader(name));
		}
		
		Enumeration<String> attribs = req.getAttributeNames();
		while (attribs.hasMoreElements()) {
			
			String attrib = attribs.nextElement();
			logger.info("Attrib:"+attrib+":"+req.getAttribute(attrib));
			
		}
		
		
		logger.info("Query String: "+req.getQueryString());
		
		req.getContentType();
		
		
		Map<String, String[]> paraMap = req.getParameterMap();

		for (String s : paraMap.keySet()) {
			logger.info("parameter name: "+s);
		}
		//super.doPost(req, resp);
	}
	
	

}

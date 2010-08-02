package net.form105.web.base.jetty;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

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
			StringBuffer sbLine = new StringBuffer(line);
			if (sbLine.indexOf("xmlMessage=<?xml version=1.0 encoding=UTF-8?>", 0) == 0) {
				
				resp.getOutputStream().print("OK");
				
			} else {
				resp.getOutputStream().print("Wrong format");
			}
		}
		
		//logger.info("upload: "+req.getParameter("xmlMessage"));
		Enumeration<String> names = req.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			logger.info(name+":"+req.getHeader(name));
		}
		
		//super.doPost(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		super.doGet(req, resp);
	}
	
	
	
	

}

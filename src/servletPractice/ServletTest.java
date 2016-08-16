package servletPractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;

import javax.jws.WebParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/servletTest")
public class ServletTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		writer.write("<p>this is a test.</p>");
		writer.write("<script>alert(123)</script>");
		Enumeration<String> obj = request.getHeaderNames();
		while(obj.hasMoreElements()){
			String headerName = obj.nextElement();
			System.out.println(headerName + " : " + request.getHeader(headerName));
		}
		System.out.println("pathInfo : "+request.getPathInfo());
		System.out.println("authType : "+request.getAuthType());
		System.out.println("contentType : "+request.getContentType());
		System.out.println("contextPath : "+request.getContextPath());
		System.out.println("pathInfo : "+request.getPathInfo());
		System.out.println("servletPath : "+request.getServletPath());
		System.out.println("requestUrl : "+request.getRequestURI());
	}

}

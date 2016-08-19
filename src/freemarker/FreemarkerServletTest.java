package freemarker;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/freemarkerServlet")
public class FreemarkerServletTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = request.getServletContext();
		response.setCharacterEncoding("UTF-8");
		FreemarkerUtil.initConfiguration(servletContext);
		Writer writer = response.getWriter();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("author", "zouyang");
		People p = new People();
		p.setName("zhang三");
		p.setAge("13");
		p.setSex("男");
		map.put("people", p);
		FreemarkerUtil.addModelData(map, "freemarker.ftl", writer);
	}
	
}

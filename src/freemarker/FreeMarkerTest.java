package freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerTest {
	public static void main(String[] args) throws IOException, TemplateException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_24);
		cfg.setDirectoryForTemplateLoading(new File("D:/sourceofsoft/app-server/apache-tomcat-7.0.63/FreemarkerTemplate"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);;
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "zouyang");
		
		People p = new People();
		p.setName("zouyang");
		p.setSex("男");
		p.setAge("22");
		map.put("people", p);
		
		Template template = cfg.getTemplate("test.ftl");
		Writer writer = new OutputStreamWriter(System.out);
		template.process(map, writer);
	}
}

package freemarker;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerTest {
	public static void main(String[] args) throws IOException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_24);
		cfg.setDirectoryForTemplateLoading(new File("D:/sourceofsoft/app-server/apache-tomcat-7.0.63/FreemarkerTemplate"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);;
	}
}

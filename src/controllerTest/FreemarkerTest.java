package controllerTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerTest {

	public static void main(String[] args) throws IOException, TemplateException {
		// TODO Auto-generated method stub
		File dir = new File("C:/Users/zouyang/Desktop/templates");
		if(!dir.exists()){
			dir.mkdir();
		}
		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
		cfg.setDirectoryForTemplateLoading(dir);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        
        Map<String,Object> root = new HashMap<String,Object>();
        People peo = new People();
        peo.setAge("123");
        peo.setName("test");
        root.put("people_01", peo);
        peo = new People();
        peo.setAge("12");
        peo.setName("yang");
        root.put("people_02", peo);
        
        File file = null;
        if(dir.isDirectory()){
        	file = new File(dir.getPath()+"/testTemplate.ftl");
        	file.createNewFile();
        }
        Reader reader = new InputStreamReader(new FileInputStream(file));
        
        Template template =cfg.getTemplate("testTemplate.ftl");
        Writer writer = new OutputStreamWriter(System.out);
        template.process(root, writer);
	}

}

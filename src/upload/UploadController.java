package upload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import common.utils.UploadUtil;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping("/index")
	public String uploadView(){
		return "upload";
	}
	@RequestMapping(value="/uploadByStream",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody String uploadByStream(
			@RequestParam(value="files1",required=false)CommonsMultipartFile[] files,HttpServletRequest request,HttpServletResponse response){
		System.out.println("需要上传："+files.length+"个文件");
		String pathname = "C:\\Users\\zouyang\\Desktop\\test\\";
		String result = UploadUtil.uploadByStream(files, pathname);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value="/uploadByMultipartFile",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody String uploadByMultipartFile(
			@RequestParam(value="files2",required=false)CommonsMultipartFile[] files,HttpServletRequest request,HttpServletResponse response){
		System.out.println("需要上传："+files.length+"个文件");
		String pathname = "C:\\Users\\zouyang\\Desktop\\test\\";
		String result = UploadUtil.uploadMultipartFile(files, pathname);
		System.out.println(result);
		return result;
	}
}

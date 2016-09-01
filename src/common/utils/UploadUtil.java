package common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadUtil {
	//通过字节流的形式上传
	public static String uploadByStream(List<MultipartFile> files,String pathname){
		if(files.size()<=0){
			return "没有文件";
		}else{
			File dir = new File(pathname);
			if(!dir.exists()){
				dir.mkdirs();
			}else{
				if(dir.isFile()){
					return "保存路径不是一个文件夹";
				}
			}
			long begin = new Date().getTime();
			for(int i = 0;i<files.size();i++){
				MultipartFile file = files.get(i);
				FileOutputStream out;
				try {
					byte[] b = file.getBytes();
					File f = new File(pathname+ new Date().getTime() + file.getOriginalFilename());
					if(!f.exists()){
						f.createNewFile();
					}
					out = new FileOutputStream(f);
					out.write(b);
					out.flush();
					out.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					return "发生异常，上传失败";
				} 
				
			}
			long end  = new Date().getTime();
			System.out.println("上传用时："+(end-begin)+"ms");
			return "上传完成";
		}
	}
	//通过spring包装好的解析器实现上传，这种方式上传速度更快
	public static String uploadMultipartFile(List<MultipartFile> files,String pathname){
		if(files.size()<=0){
			return "没有文件";
		}else{
			File dir = new File(pathname);
			if(!dir.exists()){
				dir.mkdirs();
			}else{
				if(dir.isFile()){
					return "保存路径不是一个文件夹";
				}
			}
			long begin = new Date().getTime();
			for(int i = 0;i<files.size();i++){
				MultipartFile file = files.get(i);
				try {
					File f = new File(pathname+ new Date().getTime() + file.getOriginalFilename());
					if(!f.exists()){
						f.createNewFile();
					}
					file.transferTo(f);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			long end = new Date().getTime();
			System.out.println("上传用时："+(end-begin)+"ms");
			return "上传成功";
		}
	}
}

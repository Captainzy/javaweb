package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class TestNIO {
	public static void main(String[] args) throws Exception {
		//baseTest();
		//scannerAndGatherTest();
		transferTest();
	}
	
	public static void baseTest() throws Exception{
		String path = TestNIO.class.getClassLoader().getResource("").getPath()+"/nio/nio-data.txt";
		RandomAccessFile file = new RandomAccessFile(new File(path), "rw");
		FileChannel fileChannel = file.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		int count = fileChannel.read(buf);
		StringBuffer sb = new StringBuffer();
		while(count != -1){
			buf.flip();
			if(buf.hasArray()) {
				byte[] bytes = buf.array();
				String str = new String(bytes,buf.position(),buf.limit(),"UTF-8");
				sb.append(str);
			}
//			
//			while(buf.hasRemaining()){
//				System.out.print((char)buf.get());
//			}
			buf.clear();
			count = fileChannel.read(buf);
		}
		System.out.println(sb);
		buf.clear();
		fileChannel.close();
		file.close();
	}
	
	public static void scannerAndGatherTest() throws Exception{
		String path = TestNIO.class.getClassLoader().getResource("").getPath() + "nio/nio-data.txt";
		RandomAccessFile file = new RandomAccessFile(new File(path), "rw");
		FileChannel channel = file.getChannel();
		ByteBuffer b1 = ByteBuffer.allocate(20);
		ByteBuffer b2 = ByteBuffer.allocate(20);
		ByteBuffer[] bytesArray = {b1,b2};
		long count = channel.read(bytesArray);
		StringBuffer sb = new StringBuffer();
		while(count != -1){
			for(int i = 0;i<bytesArray.length;i++){
				ByteBuffer b = bytesArray[i];
				b.flip();
				String str = new String(b.array(),b.position(),b.limit(),"UTF-8");
				bytesArray[i].clear();
				sb.append(str);
			}
			count = channel.read(bytesArray);
		}
		System.out.println(sb);
		channel.close();
		file.close();
	}
	
	public static void transferTest() throws Exception{
		String path = TestNIO.class.getClassLoader().getResource("").getPath()+"nio/from-nio-data.txt";
		String path2 = TestNIO.class.getClassLoader().getResource("").getPath()+"nio/to-nio-data.txt";

		RandomAccessFile fromFile = new RandomAccessFile(path, "rw");  
		FileChannel      fromChannel = fromFile.getChannel();  
		RandomAccessFile toFile = new RandomAccessFile(path2, "rw");  
		FileChannel      toChannel = toFile.getChannel();  		  
		toChannel.transferFrom(fromChannel, 0, fromChannel.size()); 
		
		ByteBuffer b = ByteBuffer.allocate(1024);
		StringBuffer sb = new StringBuffer();
		int count = toChannel.read(b);
		while(count != -1){
			b.flip();
			byte[] bytes = b.array();
			String str = new String(bytes,b.position(),b.limit(),"UTF-8");
			sb.append(str);
			b.clear();
			count = toChannel.read(b);
		}
		System.out.println(sb);
	}
	
	public static void selectorTest(){
		
	}
}

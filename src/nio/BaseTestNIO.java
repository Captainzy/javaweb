package nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BaseTestNIO {
	public static void main(String[] args) throws Exception{
		RandomAccessFile file = new RandomAccessFile(new File("C:\\Users\\TZ\\Desktop/nio-data.txt"), "rw");
		FileChannel fileChannel = file.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		int count = fileChannel.read(buf);
		while(count != -1){
			buf.flip();
			byte[] bytes = buf.array();
			String str = new String(bytes,"gbk");
			System.out.print(str);
//			while(buf.hasRemaining()){
//				System.out.print((char)buf.get());
//			}
			buf.clear();
			count = fileChannel.read(buf);
		}
		buf.clear();
		fileChannel.close();
		
		
	}
}

package nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BaseTestNIO {
	public static void main(String[] args) throws Exception{
		String path = BaseTestNIO.class.getClassLoader().getResource("").getPath()+"/nio/nio-data.txt";
		RandomAccessFile file = new RandomAccessFile(new File(path), "rw");
		FileChannel fileChannel = file.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		int count = fileChannel.read(buf);
		while(count != -1){
			buf.flip();
			byte[] bytes = buf.array();
			String str = new String(bytes,"UTF-8");
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

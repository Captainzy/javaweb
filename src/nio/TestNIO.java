package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TestNIO {
	public static void main(String[] args) throws Exception {
		//baseTest();
		//scannerAndGatherTest();
		//transferTest();
		selectorTest();
		
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
	
	public static void selectorTest() throws Exception{

		Selector selector = Selector.open();
		SocketAddress address = new InetSocketAddress("127.0.0.1", 9969); 
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(address);
		socketChannel.configureBlocking(false);//设置为非阻塞模式
		int interestKey = SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE;//客户端不能OP_ACCEPT
		socketChannel.register(selector, SelectionKey.OP_CONNECT );
		while(true) {  
			int readyChannels = selector.select();  
			if(readyChannels == 0) {
				continue;                                                                 
			}
			Set<SelectionKey> selectedKeys = selector.selectedKeys();  
			Iterator keyIterator = selectedKeys.iterator();  
			while(keyIterator.hasNext()) {  
				SelectionKey key = (SelectionKey) keyIterator.next();  
				if (key.isConnectable()) {  
					System.out.println("连接到服务端了");
					writeMessage(key);
				} else if (key.isReadable()) {  
					System.out.println("接收到服务端的消息了");
				} else if (key.isWritable()) {  
					System.out.println("可以发送消息到服务端了");
				}
			}
		}
	} 
	
	public static void writeMessage(SelectionKey key) throws Exception{
		System.out.println("发送消息到服务端");
		SocketChannel sc = (SocketChannel) key.channel();
		String path = TestNIO.class.getClassLoader().getResource("").getPath()+"nio/to-nio-data.txt";
		RandomAccessFile file = new RandomAccessFile(path, "rw");  
		ByteBuffer b = ByteBuffer.allocate(1024);
		FileChannel channel = file.getChannel();
		channel.transferTo(0, channel.size(),sc);
//		int count = channel.read(b);
//		while(count!=-1){
//			b.flip();
//			sc.write(b);
//			b.clear();
//			count = channel.read(b);
//		}
	}
}

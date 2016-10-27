package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TestServerSocketChannel {
	public static void main(String[] args) throws Exception{
		Selector selector = Selector.open();
		ServerSocketChannel  channel = ServerSocketChannel.open();
		channel.bind(new InetSocketAddress("127.0.0.1", 9969));
		channel.configureBlocking(false);
		channel.register(selector, SelectionKey.OP_ACCEPT);
		while(true){
			int readyChannels = selector.select();
			if(readyChannels>0){
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator it = keys.iterator();
				while(it.hasNext()){
					SelectionKey key = (SelectionKey) it.next();
					if(key.isAcceptable()){
						System.out.println("有客户端连接上了");
					}else if(key.isReadable()){
						readMessage(key);
					}else if(key.isWritable()){
						System.out.println("发送消息给客户端了");
					}
				}
			}
		}
	}
	
	public static void readMessage(SelectionKey key) throws Exception{
		System.out.println("处理客户端发送的信息");
		ServerSocketChannel socketChannel = (ServerSocketChannel) key.channel();
		SocketChannel sc = socketChannel.accept();
		ByteBuffer b = ByteBuffer.allocate(1024);
		int count = sc.read(b);
		StringBuffer sb = new StringBuffer();
		while(count != -1){
			b.flip();
			String str = new String(b.array(),b.position(),b.limit(),"UTF-8");
			sb.append(str);
			b.clear();
			count = sc.read(b);
		}
		System.out.println(sb);
	}
}	

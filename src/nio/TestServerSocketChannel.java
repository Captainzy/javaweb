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

import org.springframework.expression.spel.ast.Selection;

public class TestServerSocketChannel {
	public static void main(String[] args) throws Exception{
		Selector selector = Selector.open();
		ServerSocketChannel  serverChannel = ServerSocketChannel.open();
		serverChannel.bind(new InetSocketAddress("127.0.0.1", 9969));
		serverChannel.configureBlocking(false);
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		while(true){
			selector.select();
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator it = keys.iterator();
			while(it.hasNext()){
				SelectionKey key = (SelectionKey) it.next();
				it.remove();
				if(key.isAcceptable()){
					System.out.println("有客户端连接上了");
					 ServerSocketChannel server = (ServerSocketChannel)key.channel();
                     //获得客户端连接通道
                     SocketChannel sc = server.accept();
                     sc.configureBlocking(false);
	                 sc.register(selector, SelectionKey.OP_READ);
				}else if(key.isReadable()){
					SocketChannel sc = (SocketChannel) key.channel();
					ByteBuffer b = ByteBuffer.allocate(200);
					int count = sc.read(b);
					StringBuffer sb = new StringBuffer();
				
						String str = new String(b.array());
						sb.append(str);
						b.clear();
						count = sc.read(b);
					
					System.out.println(sb);
				}
			}
		}
		
	}
	
}	
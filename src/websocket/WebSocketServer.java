package websocket;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocketServer")
public class WebSocketServer {
	
	//public static final CopyOnWriteArraySet<WebSocketServer> connections = new CopyOnWriteArraySet<>();
	public static final AtomicInteger onlineCount = new AtomicInteger(0);
	public static final AtomicInteger guestId = new AtomicInteger(0);
	private final String clientName;
	private Session session;
	
	public WebSocketServer(){
		this.clientName = "客户端："+guestId.incrementAndGet()+"号";
	}
	@OnOpen
	public void onOpen(Session session){
		this.session = session;
		System.out.println("连接数："+onlineCount.incrementAndGet());
		//connections.add(this);
		String message ="服务端：信息改变";
		int i = 0;
		int s = 0;
		while(true){
						
			if(s%5 == 0){
				sendMessage(message +"\t回复时间："+ new Date().getTime());
				i++;
			}
			if(i==10){
				System.out.println("根据条件中断连接");
				
				try {
					this.session.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			s++;
		}
		
	}
	
	@OnMessage
	public void onMessage(String message){
		System.out.println("来自客户"+this.guestId+"号的信息："+message);
	}

	@OnClose
	public void onClose(){
		//connections.remove(this);
		System.out.println("一个连接断开");
		System.out.println("当前连接数: "+onlineCount.decrementAndGet());
	}
	
	@OnError
	public void onError(Throwable error){
		error.printStackTrace();
	}
	
	public void sendMessage(String message){
		try {
			synchronized (this) {
				this.session.getBasicRemote().sendText(message);
			}
		} catch (IOException e) {
			System.out.println("给客户端发送信息失败");
		}
	}
}

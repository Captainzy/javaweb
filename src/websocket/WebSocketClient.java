package websocket;

import java.io.IOException;
import java.net.URI;

import javax.websocket.*;
import javax.websocket.server.PathParam;

@ClientEndpoint
public class WebSocketClient {
	
	private Session session;
	
	public WebSocketClient(){}
	
	public WebSocketClient(Session session){
		this.session = session;
	}
	
	@OnOpen
	public void onOpen (Session session) {
		try {
			session.getBasicRemote().sendText ("服务端你好");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnMessage
	public void onMessage(String message){
		System.out.println("这是服务端返回的消息："+message);
	}
	
	@OnClose
	public void onClose(){
		try {
			this.session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnError
	public void onError(Throwable error){
		error.printStackTrace();
	}
	public static void main(String[] args) {
		WebSocketContainer container = null;
		Session session = null;
		try {
			container = ContainerProvider.getWebSocketContainer(); 
			session = container.connectToServer(WebSocketClient.class, URI.create("ws://localhost:8181/javaweb/websocketServer"));
			WebSocketClient client = new WebSocketClient(session);
			client.onOpen(session);
		} catch (DeploymentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

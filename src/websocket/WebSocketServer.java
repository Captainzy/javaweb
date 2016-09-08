package websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("")
public class WebSocketServer {
	@OnOpen
	public void onOpen(){
		
	}
	
	@OnClose
	public void onClose(){
		
	}
	 
	@OnMessage
	public void onMessage(){
		
	}
	
	@OnError
	public void onError(){
		
	}
}

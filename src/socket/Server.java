package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		int port = 8181;
		ServerSocket server = new ServerSocket(port);
		Socket socket = server.accept();
		
		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		StringBuffer str = new StringBuffer();
		char[] cbuf = new char[64];
		int len = 0;
		while((len = reader.read(cbuf))>-1){
			String temp = new String(cbuf);
			if(temp.indexOf("eof")>-1){
				str.append(temp.substring(0,temp.indexOf("eof")));
				break;
			}
			str.append(temp);
		}
		System.out.println(str);
		System.out.println("以上是客户端发送的信息");
		System.out.println("----------------------------------------------");
		Writer writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		writer.write("客户端，服务端向你问好！！");
		writer.flush();
		
		writer.close();
		reader.close();
		socket.close();
		server.close();
	}
}

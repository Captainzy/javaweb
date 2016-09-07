package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args){
		String host = "127.0.0.1";
		int port = 8181;
		Socket client;
		Writer writer;
		InputStreamReader reader;
		
		try {
			client = new Socket(host, port);
			
			writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			writer.write("hello2 我是客户端");
			writer.flush();
			
			reader = new InputStreamReader(client.getInputStream());
			char[] cbuf = new char[64];
			StringBuffer sb = new StringBuffer();
			int len;
			while((len = reader.read(cbuf))>-1){
				String str = new String(cbuf);
				if(str.indexOf("eof")>-1){
					sb.append(str.substring(0, str.indexOf("eof")));
					break;
				}
				sb.append(str);
				
			}
			System.out.println("这是客户端反馈的信息："+sb);
			
			writer.close();
			reader.close();
			client.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

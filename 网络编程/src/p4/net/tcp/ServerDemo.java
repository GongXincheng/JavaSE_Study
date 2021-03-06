package p4.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args) throws IOException {
		//服务端接收客户端发过来的数据，并打印在控制台上
		/*
		 * 建立TCP服务端思路：
		 * 
		 * 1.创建TCP服务端socket服务，通过ServerSocket对象
		 * 2.服务端必须对外提供一个端口，否则客户端无法连接
		 * 3.获取连接过来的客户端对象
		 * 4.通过客户端对象获取socket流读取客户端发来的数据
		 * 		打印在控制台上
		 * 5.关闭资源，关客户端，关服务端
		 */
		
		//1.创建服务端对象
		ServerSocket ss = new ServerSocket(10003);
		
		//2.获取链接过来的客户端对象
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		
		//3.通过socket对象获取输入流，要读取客户端发来的数据
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(ip+": "+text);
		
		s.close();
		ss.close();
		
		
		
		
	}
}

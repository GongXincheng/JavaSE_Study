package p4.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
	public static void main(String[] args) throws IOException, IOException {
		//客户端发送数据到服务端
		/*
		 * TCP传输，客户端建立的过程
		 * 
		 * 1. 创建TCP客户端socket服务，使用Socket对象。
		 * 		建议该对象一创建就明确目的地。要连接的主机
		 * 
		 * 2. 如果连接建立成功，说明 数据传输通道已建立
		 * 		该通道就是socket流，是底层建立好的
		 * 		既然是流，那就说明这里既有输出 又有 输入
		 * 		想要输入或者输出流对象，可以找Socket对象来获取
		 * 		getOutputStream(),getInputStream();
		 * 
		 * 3. 使用输出流，将数据写出。
		 * 4. 关闭资源。
		 */
		
		//1.创建客户端socket服务
		Socket socket = new Socket("localhost", 10003);
		
		//2.获取socket流中的输出流。
		OutputStream out = socket.getOutputStream();
		
		//3.使用输出流将指定的数据写出去
		out.write("TCP演示...Come On...".getBytes());
		
		//4.关闭资源
		socket.close();
	}
}

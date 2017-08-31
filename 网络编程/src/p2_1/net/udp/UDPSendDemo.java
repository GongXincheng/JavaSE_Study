package p2_1.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {
	public static void main(String[] args) throws IOException {
		System.out.println("发送端启动...");
		/*
		 * 创建UDP传输的发送端：
		 * 思路：
		 * 1. 建立UDP的socket服务(端点)
		 * 2. 将要发送的数据封装到 数据包(DatagramPacket) 中
		 * 3. 通过UDP的socket服务将数据包发送出去
		 * 4. 关闭socket服务。
		 */
		
		//1.建立UDP的socket服务。使用DatagramSocket对象.
		DatagramSocket ds = new DatagramSocket(10001);
		
		//2.将要发送的数据封装到数据包中
		String str = "UDP传输演示....";
		//使用DatagramPacket 将数据封装到该对象包中
		byte[] buf = str.getBytes();
		DatagramPacket dp =  new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"),10000);
		
		//3.通过UDP的socket服务将数据包发送出去
		ds.send(dp);
		
		//4.关闭资源
		ds.close();
	}
}

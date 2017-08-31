package p2_1.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo2 {
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
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line = bufr.readLine())!=null){
			byte[] buf = line.getBytes();
			DatagramPacket dp =  new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"),10000);
			
			//3.通过UDP的socket服务将数据包发送出去
			ds.send(dp);
			
			if("over".equals(line))
				break;
		}
		
		//4.关闭资源
		ds.close();
	}
}

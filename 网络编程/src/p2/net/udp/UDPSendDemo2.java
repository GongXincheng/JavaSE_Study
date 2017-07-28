package p2.net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 2017年7月28日 18:29:38
 */
public class UDPSendDemo2 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("发送端启动......");
		/*
		 * 创建UDP传输的发送端：
		 * 思路：
		 * 1.建立UDP的socket服务(端点)
		 * 2.将发送的数据封装到数据包中。
		 * 3.通过UDP的socket服务将数据包发送出去。
		 * 4.关闭socket服务。
		 */
		
		//1.UDP的socket服务。使用DatagramSocket对象。
		DatagramSocket ds = new DatagramSocket();
		
		//2.将要发送的数据封装到数据包中
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line=bufr.readLine())!=null){
			byte[] buf = line.getBytes();
			
			//使用DatagramPacket将数据封装到该对象的包中
			DatagramPacket dp = 
					new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.102"), 10000);
			
			//3.通过UDP的socket服务将数据包发送出去。使用send方法
			ds.send(dp);
			
			if("over".equals(line))
				break;
		}
		
		//4.关闭socket服务。
		ds.close();
	}
	
}

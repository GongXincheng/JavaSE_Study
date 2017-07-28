package p2.net.udp;
/*
 * 2017年7月28日 19:06:39
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceDemo2 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("接收端启动......");
		/*
		 * 建立UDP接收端的思路：
		 * 1.创建UDP的socket服务,因为是要接收数据，必须要明确端口号。
		 * 2.创建数据包 用于存储接收到的数据，方便用数据包对象的方法解析数据
		 * 3.使用socket服务的receiver方法，将接收到的数据存储到数据包中
		 * 4.通过数据包对象的方法，解析数据包中的数据
		 * 5.关闭资源
		 */
		
		//1.建立UDP的socket服务
		DatagramSocket ds = new DatagramSocket(10000);
		
		while(true){
		//2.创建数据包 用于存储接收到的数据，方便用数据包对象的方法解析数据
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		//3.使用socket服务的receiver方法，将接收到的数据存储到数据包中
		ds.receive(dp);	//阻塞式的
		
		//4.通过数据包对象的方法，解析数据包中的数据,比如地址，端口，数据内容
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();
		String text = new String(dp.getData(), 0, dp.getLength());
		System.out.println(ip+":"+port+":"+text);
		}
		//5.关闭资源
//		ds.close();
		
	}
	
}

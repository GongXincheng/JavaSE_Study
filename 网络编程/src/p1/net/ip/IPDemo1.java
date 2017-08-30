package p1.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo1 {
	public static void main(String[] args) throws UnknownHostException {

		// 获取本地主机ip地址对象
		InetAddress ip = InetAddress.getLocalHost();
		
		//获取其他主机的ip地址对象
		ip = InetAddress.getByName("WQ-20170502UVEM");
		System.out.println("主机地址："+ip.getHostAddress());
		System.out.println("主机名称："+ip.getHostName());
		
/*		主机地址：127.0.0.1
		主机名称：WQ-20170502UVEM */
	}
}

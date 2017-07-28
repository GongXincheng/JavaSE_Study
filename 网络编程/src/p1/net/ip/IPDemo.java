package p1.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 2017年7月28日 16:09:45
 */
public class IPDemo {

	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress ip = InetAddress.getLocalHost();//获取本地主机的 IP 地址
		
		//获取其他主机的ip地址对象
		ip = InetAddress.getByName("www.baidu.com");
		
		System.out.println(ip.getHostAddress());	// 返回该IP 的 IP 地址字符串
		System.out.println(ip.getHostName());		// 获取此 IP 地址的主机名。
	}
	
	
/*
 		192.168.1.101
		SKY-20160824VZA
		
		192.168.1.102
		WQ-20170502UVEM
*/	
	

}

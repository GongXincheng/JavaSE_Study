package p3.net.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable {

	private DatagramSocket ds;
	
	public Send(DatagramSocket ds){
		this.ds = ds;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			
			while((line = bufr.readLine())!=null){
				byte[] buf = line.getBytes();
				
				//创建数据报包对象,将数据封装到该对象中去
				DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"),10002);
				//发送
				ds.send(dp);
				
				if("886".equals(line)){
					break;
				}
			}
			//关闭资源
			ds.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

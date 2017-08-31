package p3.net.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Rece implements Runnable {
	
	private DatagramSocket ds;
	
	public Rece(DatagramSocket ds){
		this.ds = ds;
	}
	
	@Override
	public void run() {
		
		try {
			while(true){
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				
				ds.receive(dp);
				 
				 String ip = dp.getAddress().getHostAddress();
				 int port = dp.getPort();
				 String text = new String(dp.getData(),0,dp.getLength());
				 System.out.println(ip+":"+port+":"+text);
			
				 if(text.equals("886")){
					 System.out.println(ip+"推出聊天室...");
				 }
			}
			
		} catch (Exception e) {
			
		}
		
	}

}

package p3.net.chat;

import java.io.IOException;
import java.net.DatagramSocket;

public class ChatDemo {
	
	public static void main(String[] args) throws IOException {
		
		DatagramSocket send = new DatagramSocket();
		DatagramSocket rece = new DatagramSocket(10002);
		
		Send s = new Send(send);
		Rece r = new Rece(rece);
		
		new Thread(s).start();
		new Thread(r).start();
		
	}
}

package p4.io.buffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		
//		myself();
		
		FileReader fr = new FileReader("IO流.txt");
		BufferedReader bufr = new BufferedReader(fr);
		
//之前的方法		
//		char[] buf = new char[1024];
//		int len = 0;
//		while((len = bufr.read(buf))!=-1)
//			System.out.println(new String(buf, 0, len));

		
//新的方法： readLine()
		String line = null;
		while((line=bufr.readLine())!=null)
			System.out.println(line);
		
		bufr.close();
		
	}

	
//自己写的传统读
	public static void myself() {
		FileReader fr = null;
		try {
			fr = new FileReader("IO流.txt");
			
			char[] buf = new char[1024];
			int len = 0;
			while((len=fr.read(buf))!=-1){
				System.out.println(new String(buf, 0, len));
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}finally{
			if(fr!=null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
}

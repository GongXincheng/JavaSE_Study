package p2.io.filereader;

import java.io.FileReader;
import java.io.IOException;

/*
 * 2017年7月27日 13:56:15
 * 需求：读取一个文本文件。将读取到的字符打印到控制台
 */
public class FlieReaderDemo1 {
	public static void main(String[] args) throws IOException {
		
		//1.创建读取字符数据的输入流对象
		/*
		 * 在创建读取流对象时，必须要明确被读取的文件。一定要确定该文件是存在的。 
		 * 
		 * 用一个读取流关联一个已存在文件。 
		 */
		FileReader fr = new FileReader("demo.txt");
		
		//用Reader中的read方法读取字符。
		int ch = 0;
		while( (ch=fr.read()) != -1)
			System.out.print((char)ch);
		
		
/*		int ch1 = fr.read();
		System.out.println((char)ch1);
		int ch2 = fr.read();
		System.out.println((char)ch2);
		int ch3 = fr.read();
		System.out.println(ch3);
*/		
		fr.close();
	}
}

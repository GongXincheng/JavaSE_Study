package p3.io.copytext;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 2017年7月27日 14:47:52
 * 需求：作业：将c盘的一个文本文件复制到d盘。
 * 
 * 思路：
 * 1，需要读取源，
 * 2，将读到的源数据写入到目的地。
 * 3，既然是操作文本数据，使用字符流。 
 * 
 */
public class CopyTextTest1 {
	
	public static void main(String[] args) throws IOException {
		
		//1,读取已有的文本文件,使用字符输入流和文件相关联
		FileReader fr = new FileReader("c:\\IO流_1.txt");		
		//2, 创建一个目的，用于存储读到数据
		FileWriter fw = new FileWriter("copytext_1.txt");		
		//3, 频繁的读写操作
		int ch = 0;
		while((ch = fr.read())!=-1)
			fw.write(ch);
		//4, 关闭流
		fw.close();
		fr.close();
			
/*BySelf：
		FileReader fr = new FileReader("c:\\demo.txt");
		FileWriter fw = new FileWriter("d:\\demo.txt");
		char[] ch = new char[1024];
		int num = 0;
		while((num=fr.read(ch))!=-1)
			fw.write(ch, 0, num);
		
		fr.close();
		fw.close();
*/
	}
	
}

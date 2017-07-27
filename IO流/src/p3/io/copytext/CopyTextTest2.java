package p3.io.copytext;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 2017年7月27日 15:10:33
 */
public class CopyTextTest2 {
	
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args){
		
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("IO流_1.txt");
			fw = new FileWriter("copytext_2.txt",true);
			
			//创建一个临时容器，用于缓存读取道德字符
			char[] buf = new char[BUFFER_SIZE];
			//定义一个变量记录读取到的字符数，其实就是往数组里装的字符的个数
			int len = 0;
			while((len = fr.read(buf))!=-1)
				fw.write(buf, 0, len);
				
		} catch (IOException e) {
			throw new RuntimeException("读写失败");
		}
		finally{
			if(fw!=null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(fr!=null)
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
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

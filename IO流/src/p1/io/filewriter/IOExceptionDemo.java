package p1.io.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class IOExceptionDemo {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args){
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("k:\\demo.txt");

			fw.write("abcde" + LINE_SEPARATOR + "aaaaa"); //换行

		} catch (IOException e) {
			System.out.println(e.toString());
		}
		finally{
			if(fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException("关闭失败!");
				}
		}
		
		System.out.println("over");
		
	}
	
}

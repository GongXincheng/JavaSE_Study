package p4.io.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterDemo {
//	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	public static void main(String[] args) throws Exception {
		
		FileWriter fw = new FileWriter("buf.txt");
		
		//为了提高写入的效率。使用了字符流的缓冲区
		//创建了一个字符写入流的缓冲区对象，并和指定的被缓冲的流对象相关联。
		BufferedWriter bufw = new BufferedWriter(fw);
		
		//使用缓冲区的写入方法，将数据先写入到缓冲区中。
//		bufw.write("abcdeafasfafafafafafwafwafwaf"+LINE_SEPARATOR+"aasdada");
//		bufw.write("aaaaaaaaa");
//		bufw.newLine();
//		bufw.write("kkkkkkkkk");
		
		for(int i = 0; i<4; i++){
			bufw.write("abcdef"+i);
			bufw.newLine();	//换行
			bufw.flush();
		}
		
		//使用缓冲区的舒刷新方法，将数据刷新到目的地中。
		bufw.flush();
		
		//关闭缓冲区,其实关闭的就死被缓冲的流对象。
		bufw.close();
		
	}
	
}

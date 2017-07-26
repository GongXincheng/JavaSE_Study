package p3.news.demo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.sort;//静态导入，其实导入的是类中的静态成员
import static java.util.Collections.*;
import static java.lang.System.*;

public class StaticImportDemo {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("abc3");
		list.add("abc7");
		list.add("abc1");
		out.println(list);
		
		sort(list);
		out.println(list);
		
		String max = max(list);
		out.println("max : "+max);
	}
	
}

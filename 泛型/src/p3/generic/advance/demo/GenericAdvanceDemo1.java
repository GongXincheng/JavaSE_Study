package p3.generic.advance.demo;
/*
 * 2017年7月23日 16:13:11
 * 通配符 ？
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericAdvanceDemo1 {
	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("abc");
		al.add("hehe");
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(5);
		al2.add(67);
		
		printCollection(al);
		printCollection(al2);
		
	}
	/**
	 * 迭代并打印集合中的元素
	 * 如果不对元素进行操作，只是打印，就是用该方法
	 * 使用通配符 : ?
	 * @param al
	 */
	private static void printCollection(Collection<?> al) {
		Iterator<?> it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

/*如果对元素进行操作，就是用该方法
	private static <T> void printCollection(Collection<T> al) {
		Iterator<T> it = al.iterator();
		while(it.hasNext()){
			T t = it.next();
			System.out.println(t);
		}
	}
*/
}

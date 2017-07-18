package 多线程;
/*
 * 2017年7月16日 09:30:12
 * 
 * 多线程下的单例设计模式，
 * 懒汉式效率和安全的解决
 */

//饿汉式
class Single
{
	private static final Single s = new Single();
	private Single(){}
	public static Single getInstance(){
		return s;
	}
}

/*懒汉式*/
class Single1
{
	private static Single1 s = null;
	private Single1(){}
	public static Single1 getInstance(){
		if(s==null){
			synchronized(Single1.class){
				if(s == null){
					s = new Single1();
				}
			}
		}
		return s;
	}
}

public class SingleDemo {

}

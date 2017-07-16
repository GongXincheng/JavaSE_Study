package 单例设计模式;

/*	2017年6月3日 18:17:29
 * 		单例设计模式
 * 
 * 	如何保证对象的唯一性
 *	1. 不允许其他程序用new创建该类对象
 *	2. 在该类创建一个本类实例
 *	3. 对外提供一个方法让其他程序可以获取该对象
 *
 * 	步骤：
 * 	1. 私有化该类构造方法
 * 	2. 通过new在本类创建一个本类对象(并设为静态)	
 * 	3. 定义一个共有的，静态的方法，将创建的对象返回
 */

//饿汉式
class Single{
	static Single s = new Single();
	
	private Single(){};
	
	public static Single getInstance(){
		//可以在里面添加 if语句  满足条件才可返回single对象
		return s;
	}
}

/*懒汉式
 * 面试的时候用，实际开发用的少，多线程的时候容易出问题
 */	
class Single2{
	static Single2 s = null;
	
	private Single2(){};
	
	public static Single2 getInstance(){	
		
		if(s==null){						//用此方法解决懒汉式的安全和效率问题 21-多线程讲解
			synchronized(Single2.class){	
				if(s==null){
					s = new Single2();
				}
			}
		}
		return s;
	}
}


public class SingleDemo {
	public static void main(String[] args){
		
		Test t1 = Test.getInstance();
		Test t2 = Test.getInstance();
		t1.setNum(20);
		t2.setNum(10);
		System.out.println(t1.getNum());
		System.out.println(t2.getNum());
		
		/*运行结果：
		 * 10
		 * 10
		 */
	}
}


//测试类
class Test{
	static Test t = new Test();
	private int num;
	
	private Test(){};
	
	public static Test getInstance(){
		return t;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}




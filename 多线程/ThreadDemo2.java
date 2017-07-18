package 多线程;
/* 2017年7月15日 17:20:08
* 
*	 创建线程方式二： 实现Runnable接口实现run方法
*		步骤：
*			1. 让该类实现Runnable方法,实现run()方法
*			2. 创建 Thread对象 构造器中传递 该类的对象： Thread t = new Thread(new xxx())
*			3. 调用Thread对象的start方法 开启线程并调用线程的任务run方法执行
*
*		重要：将线程的任务进行了对象的封住，封装到了runnable‘的子类中
*/

class Fu{}	
						//因为Demo1继承了Fu类，就不能继承Thread类，java不支持多继承
class Demo1 extends Fu implements Runnable  //准备扩展Demo1类，让其中的内容作为线程的任务执行
{						//通过实现接口来执行
	public void run() {
		show();
	}						
	public void show(){
		for(int x=0; x<20; x++){
			System.out.println(Thread.currentThread().getName()+"...."+x);
		}
	}
}

public class ThreadDemo2{
	public static void main(String[] args) {
		Demo1 d = new Demo1();
		Thread t1 = new Thread(d,"张三");
		Thread t2 = new Thread(d,"wangcai");
		t1.start();
		t2.start();
	}
}

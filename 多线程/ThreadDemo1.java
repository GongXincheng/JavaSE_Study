package 多线程;
/*
进程：正在进行中的程序(直译).
		
线程：就是进程中一个负责程序执行的控制单元(执行路径)
一个进程中可以多执行路径，称之为多线程。

一个进程中至少要有一个线程。

开启多个线程是为了同时运行多部分代码。

每一个线程都有自己运行的内容。这个内容可以称为线程要执行的任务。

多线程好处：解决了多部分同时运行的问题。

多线程的弊端：线程太多回到效率的降低。

其实应用程序的执行都是cpu在做着快速的切换完成的。这个切换是随机的。

JVM启动时就启动了多个线程，至少有两个线程可以分析的出来。

1，执行main函数的线程，
		该线程的任务代码都定义在main函数中。

2，负责垃圾回收的线程。
*/

/*
 * 如何创建一个线程？
 * 		
 * 	  创建线程方式一：继承Thread类
 *		步骤：
 *			1.定义一个类继承Thread类
 *			2.覆盖Thread类中的run方法
 *			3.直接创建Thread的子对象创建线程
 *			4.调用start方法 开启线程并调用线程的任务run方法执行
 * 
 *	 创建线程方式二： 实现Runnable接口实现run方法
 *		步骤：
 *			1. 让该类实现Runnable方法
 *			2. 创建 Thread对象 构造器中传递 该类的对象： Thread t = new Thread(new xxx())
 *			3. 调用Thread对象的start方法 开启线程并调用线程的任务run方法执行
 */

class Demo extends Thread{	//创建线程方式一：继承Thread类
	private String name;
	
	Demo(String name){
		super(name);
		this.name = name;
	}
	
	public void run(){	//run方法中 封装了线程的任务
		for(int x=0; x<10; x++){
			for(int y=-99999; y<99999; y++){}
			System.out.println(name+".....x="+x+"...."+Thread.currentThread().getName());
		}											//	获取当前线程的名称
	}
}

class ThreadDemo{
	public static void main(String[] args) {
		Demo d1 = new Demo("旺财");		//创建线程 d1 d2
		Demo d2 = new Demo("xianqiang");
		d1.start();	//开启线程 调用run()方法
		d2.start();
		System.out.println("over...."+Thread.currentThread().getName());
	}
}

/*
class Demo extends Thread{
	private String name;
	Demo(String name){
		super(name);
		this.name = name;
	}
	
	public void run(){
		for(int i=0; i<10; i++){
			for(long j=0;j<99999999;j++){}
			System.out.println(this.name+"...."+i+"...."+"当前线程名为：["+Thread.currentThread().getName()+"]");
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		Demo d1 = new Demo("张三");
		Demo d2 = new Demo("wangcai");
		d1.start();
		d2.start();
		System.out.println("over......"+"当前线程名为：["+Thread.currentThread().getName()+"]");
	}
}
*/

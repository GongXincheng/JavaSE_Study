package 多线程;

/*
 * 	2017年7月19日16:58:16
 * 
 * 	join() 方法：等待该线程终止
 * 
 * */

class Demo2 implements Runnable{
	public void run(){
		for(int i=0; i<50; i++){
			System.out.println(Thread.currentThread().getName()+"......."+i);
		}
	}
}

public class JoinDemo {
	public static void main(String[] args) {
		Demo2 d = new Demo2();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();
		try {
			t1.join();		//t1线程要申请加入进来，运行， 此时main线程就会把   执行权 和 执行资格 都 释放，t1线程获取执行权和执行资格
							//等待该线程终止，main线程等待t1线程终止
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		
		for(int i=0; i<50; i++){
			System.out.println(Thread.currentThread().getName()+"......."+i);
		}
	}
}

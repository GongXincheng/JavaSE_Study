package 多线程;
/*
 * 2017年7月16日 09:39:10
 * 
 * 死锁：常见情景之一：同步的嵌套
 * 
 * */

class Test implements Runnable
{
	private boolean flag;
	Test(boolean flag){
		this.flag = flag;
	}
	
	public void run(){
		if(flag){
			while(true)
				synchronized(MyLock.lockA){
					System.out.println(Thread.currentThread().getName()+"....if  lockA");
					synchronized(MyLock.lockB){
						System.out.println(Thread.currentThread().getName()+"....if  lockB");
					}
				}
		}
		else{
			while(true)
				synchronized(MyLock.lockB){
					System.out.println(Thread.currentThread().getName()+"....else  lockB");
					synchronized(MyLock.lockA){
						System.out.println(Thread.currentThread().getName()+"....else  lockA");
					}
				}
		}
	}
}

class MyLock{
	public static final Object lockA = new Object();
	public static final Object lockB = new Object();
}

public class DeadLockTest {
	public static void main(String[] args) {
		Test a = new Test(true);
		Test b = new Test(false);
		
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
	}
}

package 多线程;
/*
 * 	2017年7月15日 22:17:04
 * 
 * 	修改：运用同步代码函数，并验证同步函数的锁是谁
 *	答案：同步函数的锁是：this  
 */

class Tickett2 implements Runnable{
	private int num = 100;
	
	public void run(){
		while(true){
			sale();
			if(num<=0){
				System.out.println("票已售空");
				break;
			}
		}
	}
	
	public synchronized void sale(){	//同步函数的锁为 this
		if(num>0){									//为了检验线程安全问题
			try { Thread.sleep(25); } catch (InterruptedException e){}	//线程sleep时，会抛出 InterruptedException 异常
			System.out.println("["+Thread.currentThread().getName()+"]售出："+ num-- +"号票");
		}
	}
}

public class SaleTicket3 {
	public static void main(String[] args) {
		Tickett2 t = new Tickett2();
		Thread t1 = new Thread(t,"一号窗口");
		Thread t2 = new Thread(t,"二号窗口");
		Thread t3 = new Thread(t,"三号窗口");
		Thread t4 = new Thread(t,"四号窗口");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

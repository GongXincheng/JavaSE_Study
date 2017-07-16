package 多线程;
/*
 * 2017年7月15日 20:32:19
 * 
 *  创建线程方式二： 实现Runnable接口实现run方法
 *	运用同步代码块
 */

class Tickett1 implements Runnable{
	private int num = 100;
//	Object obj = new Object();
	
	public void sale(){
		while(true){
			synchronized(this /*obj*/ ){	//同步代码块
				if(num>0){
					try {
						//为了检验线程安全问题
						Thread.sleep(25);	//线程sleep时，会抛出 InterruptedException 异常
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("["+Thread.currentThread().getName()+"]售出："+ num-- +"号票");
				}
				else{
					System.out.println("票已售空");
					break;
				}
			}
		}
	}
	public void run(){
		sale();
	}
}

public class SaleTicket2 {
	public static void main(String[] args) {
		Tickett1 t = new Tickett1();
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

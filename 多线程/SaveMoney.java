package 多线程;
/*
 * 2017年7月15日 21:49:53
 * 
 * 需求：储户，两个，每个都到银行存钱每次存100，共存3次 
 */

class Bank{
	private int sum;	//银行的总钱数
	
	public synchronized void add(int num){	//方法②：同步函数	同步函数的锁为 this
		sum = sum + num;
		try { Thread.sleep(20); }catch(InterruptedException e){}//检验线程安全问题
		System.out.println("sum = "+sum);
	}
}

class Cus implements Runnable{
	private Bank bank = new Bank();
	//Object obj = new Object();
	
	public void run(){
		for(int i=0; i<3; i++){
			//synchronized(obj){	//方法①：同步代码块，解决线程安全问题
				bank.add(100);
			//}
		}
	}
}

public class SaveMoney {
	public static void main(String[] args) {
		Cus s = new Cus();
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(s);
		t1.start();
		t2.start();
	}
}

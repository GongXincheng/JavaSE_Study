package 多线程;
/*
 * 2017年7月15日 18:41:40
 * 
 * 用第一种方法实现：继承Thread类
 * */

class Tickett extends Thread
{
	private static int num = 100;	//如果使用第一种方法，必须静态才能解决
	Tickett(String name){
		super(name);
	}
	
	public void run(){
		sale();
	}
	public void sale()
	{
		while(true){
			if(num>0){
				System.out.println("["+Thread.currentThread().getName()+"]售出："+ num-- +"号票");	
			}
			else{
				System.out.println("票已售空");
				break;
			}
		}
	}
}

public class SaleTicket1 {
	public static void main(String[] args) {
		Tickett t1 = new Tickett("一号窗口");
		Tickett t2 = new Tickett("二号窗口");
		Tickett t3 = new Tickett("三号窗口");
		Tickett t4 = new Tickett("四号窗口");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

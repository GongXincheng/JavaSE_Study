package 多线程;
/*
 * 运用第一种创建线程的方法
 * Thread.currentThread().getName() 获取当前线程的名字
 * 而且需要把票的数量 定义成静态变量 共享数据
 * */
class Ticket extends Thread{
	private static int num = 100;
	
	Ticket(String name){
		super(name);
	}
	
	public void run(){
		while(true){
			if(num>0){
				System.out.println("["+Thread.currentThread().getName()+"]"+"售出："+num--+"号票");
			}
			else{
				System.out.println("票已售光");
				break;
			}
		}
	}
}

public class TicketDemo1 {
	public static void main(String[] args) {
		Ticket t1 = new Ticket("一号窗口");
		Ticket t2 = new Ticket("二号窗口");
		Ticket t3 = new Ticket("三号窗口");
		Ticket t4 = new Ticket("四号窗口");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

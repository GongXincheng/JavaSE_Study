package 多线程;

class Ticket2 implements Runnable{
	private int num = 100;
	
	public void run(){
		while(true){
			show();
			if(num<=0){
				System.out.println("["+Thread.currentThread().getName()+"]："+"票已售光");
				break;
			}
		}
	}
	
	public synchronized void show(){
		if(num>0){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("["+Thread.currentThread().getName()+"]...售出.."+num--+"号");
		}
	}
}

public class TicketDemo3 {
	public static void main(String[] args) {
		Ticket2 d = new Ticket2();
		Thread t1 = new Thread(d,"一号窗口");
		Thread t2 = new Thread(d,"二号窗口");
		Thread t3 = new Thread(d,"三号窗口");
		Thread t4 = new Thread(d,"四号窗口");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

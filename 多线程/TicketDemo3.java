package ���߳�;

class Ticket2 implements Runnable{
	private int num = 100;
	
	public void run(){
		while(true){
			show();
			if(num<=0){
				System.out.println("["+Thread.currentThread().getName()+"]��"+"Ʊ���۹�");
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
			System.out.println("["+Thread.currentThread().getName()+"]...�۳�.."+num--+"��");
		}
	}
}

public class TicketDemo3 {
	public static void main(String[] args) {
		Ticket2 d = new Ticket2();
		Thread t1 = new Thread(d,"һ�Ŵ���");
		Thread t2 = new Thread(d,"���Ŵ���");
		Thread t3 = new Thread(d,"���Ŵ���");
		Thread t4 = new Thread(d,"�ĺŴ���");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

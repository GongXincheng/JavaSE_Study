package ���߳�;

class Ticket1 implements Runnable{
	private int num = 100;
	Object obj = new Object();
	
	public void run(){
		while(true){
			//ͬ��
			synchronized (obj) {
				if(num>0){
					//���߳���ʱ����10���룬Ϊ�˼�������
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("["+Thread.currentThread().getName()+"]"+"�۳���"+num--+"��Ʊ");
				}
				else{
					System.out.println("["+Thread.currentThread().getName()+"]��"+"Ʊ���۹�");
					break;
				}
			}		
		}
	}
}

public class TicketDemo2 {
	public static void main(String[] args) {
		Ticket1 d = new Ticket1();
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

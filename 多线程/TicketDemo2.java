package 多线程;

class Ticket1 implements Runnable{
	private int num = 100;
	Object obj = new Object();
	
	public void run(){
		while(true){
			//同步
			synchronized (obj) {
				if(num>0){
					//让线程暂时冻结10毫秒，为了检验问题
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("["+Thread.currentThread().getName()+"]"+"售出："+num--+"号票");
				}
				else{
					System.out.println("["+Thread.currentThread().getName()+"]："+"票已售光");
					break;
				}
			}		
		}
	}
}

public class TicketDemo2 {
	public static void main(String[] args) {
		Ticket1 d = new Ticket1();
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

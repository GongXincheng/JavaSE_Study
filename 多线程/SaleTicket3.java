package ���߳�;
/*
 * 	2017��7��15�� 22:17:04
 * 
 * 	�޸ģ�����ͬ�����뺯��������֤ͬ������������˭
 *	�𰸣�ͬ�����������ǣ�this  
 */

class Tickett2 implements Runnable{
	private int num = 100;
	
	public void run(){
		while(true){
			sale();
			if(num<=0){
				System.out.println("Ʊ���ۿ�");
				break;
			}
		}
	}
	
	public synchronized void sale(){	//ͬ����������Ϊ this
		if(num>0){									//Ϊ�˼����̰߳�ȫ����
			try { Thread.sleep(25); } catch (InterruptedException e){}	//�߳�sleepʱ�����׳� InterruptedException �쳣
			System.out.println("["+Thread.currentThread().getName()+"]�۳���"+ num-- +"��Ʊ");
		}
	}
}

public class SaleTicket3 {
	public static void main(String[] args) {
		Tickett2 t = new Tickett2();
		Thread t1 = new Thread(t,"һ�Ŵ���");
		Thread t2 = new Thread(t,"���Ŵ���");
		Thread t3 = new Thread(t,"���Ŵ���");
		Thread t4 = new Thread(t,"�ĺŴ���");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

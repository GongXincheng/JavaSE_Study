package ���߳�;
/*
 * 2017��7��15�� 20:32:19
 * 
 *  �����̷߳�ʽ���� ʵ��Runnable�ӿ�ʵ��run����
 *	����ͬ�������
 */

class Tickett1 implements Runnable{
	private int num = 100;
//	Object obj = new Object();
	
	public void sale(){
		while(true){
			synchronized(this /*obj*/ ){	//ͬ�������
				if(num>0){
					try {
						//Ϊ�˼����̰߳�ȫ����
						Thread.sleep(25);	//�߳�sleepʱ�����׳� InterruptedException �쳣
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("["+Thread.currentThread().getName()+"]�۳���"+ num-- +"��Ʊ");
				}
				else{
					System.out.println("Ʊ���ۿ�");
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

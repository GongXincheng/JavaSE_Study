package ���߳�;
/*
 * 2017��7��15�� 21:49:53
 * 
 * ���󣺴�����������ÿ���������д�Ǯÿ�δ�100������3�� 
 */

class Bank{
	private int sum;	//���е���Ǯ��
	
	public synchronized void add(int num){	//�����ڣ�ͬ������	ͬ����������Ϊ this
		sum = sum + num;
		try { Thread.sleep(20); }catch(InterruptedException e){}//�����̰߳�ȫ����
		System.out.println("sum = "+sum);
	}
}

class Cus implements Runnable{
	private Bank bank = new Bank();
	//Object obj = new Object();
	
	public void run(){
		for(int i=0; i<3; i++){
			//synchronized(obj){	//�����٣�ͬ������飬����̰߳�ȫ����
				bank.add(100);
			//}
		}
	}
}

public class SavaMoney {
	public static void main(String[] args) {
		Cus s = new Cus();
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(s);
		t1.start();
		t2.start();
	}
}

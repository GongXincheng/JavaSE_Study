package ���߳�;
/*
 * 2017��7��15�� 18:41:40
 * 
 * �õ�һ�ַ���ʵ�֣��̳�Thread��
 * */

class Tickett extends Thread
{
	private static int num = 100;	//���ʹ�õ�һ�ַ��������뾲̬���ܽ��
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
				System.out.println("["+Thread.currentThread().getName()+"]�۳���"+ num-- +"��Ʊ");	
			}
			else{
				System.out.println("Ʊ���ۿ�");
				break;
			}
		}
	}
}

public class SaleTicket1 {
	public static void main(String[] args) {
		Tickett t1 = new Tickett("һ�Ŵ���");
		Tickett t2 = new Tickett("���Ŵ���");
		Tickett t3 = new Tickett("���Ŵ���");
		Tickett t4 = new Tickett("�ĺŴ���");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

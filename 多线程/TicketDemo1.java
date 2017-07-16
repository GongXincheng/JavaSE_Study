package ���߳�;
/*
 * ���õ�һ�ִ����̵߳ķ���
 * Thread.currentThread().getName() ��ȡ��ǰ�̵߳�����
 * ������Ҫ��Ʊ������ ����ɾ�̬���� ��������
 * */
class Ticket extends Thread{
	private static int num = 100;
	
	Ticket(String name){
		super(name);
	}
	
	public void run(){
		while(true){
			if(num>0){
				System.out.println("["+Thread.currentThread().getName()+"]"+"�۳���"+num--+"��Ʊ");
			}
			else{
				System.out.println("Ʊ���۹�");
				break;
			}
		}
	}
}

public class TicketDemo1 {
	public static void main(String[] args) {
		Ticket t1 = new Ticket("һ�Ŵ���");
		Ticket t2 = new Ticket("���Ŵ���");
		Ticket t3 = new Ticket("���Ŵ���");
		Ticket t4 = new Ticket("�ĺŴ���");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

package ���߳�;
/* 2017��7��15�� 17:20:08
* 
*	 �����̷߳�ʽ���� ʵ��Runnable�ӿ�ʵ��run����
*		���裺
*			1. �ø���ʵ��Runnable����,ʵ��run()����
*			2. ���� Thread���� �������д��� ����Ķ��� Thread t = new Thread(new xxx())
*			3. ����Thread�����start���� �����̲߳������̵߳�����run����ִ��
*
*		��Ҫ�����̵߳���������˶���ķ�ס����װ����runnable����������
*/

class Fu{}	
						//��ΪDemo1�̳���Fu�࣬�Ͳ��ܼ̳�Thread�࣬java��֧�ֶ�̳�
class Demo1 extends Fu implements Runnable  //׼����չDemo1�࣬�����е�������Ϊ�̵߳�����ִ��
{						//ͨ��ʵ�ֽӿ���ִ��
	public void run() {
		show();
	}						
	public void show(){
		for(int x=0; x<20; x++){
			System.out.println(Thread.currentThread().getName()+"...."+x);
		}
	}
}

public class ThreadDemo2{
	public static void main(String[] args) {
		Demo1 d = new Demo1();
		Thread t1 = new Thread(d,"����");
		Thread t2 = new Thread(d,"wangcai");
		t1.start();
		t2.start();
	}
}

package ���߳�;
/*
���̣����ڽ����еĳ���(ֱ��).
		
�̣߳����ǽ�����һ���������ִ�еĿ��Ƶ�Ԫ(ִ��·��)
һ�������п��Զ�ִ��·������֮Ϊ���̡߳�

һ������������Ҫ��һ���̡߳�

��������߳���Ϊ��ͬʱ���жಿ�ִ��롣

ÿһ���̶߳����Լ����е����ݡ�������ݿ��Գ�Ϊ�߳�Ҫִ�е�����

���̺߳ô�������˶ಿ��ͬʱ���е����⡣

���̵߳ı׶ˣ��߳�̫��ص�Ч�ʵĽ��͡�

��ʵӦ�ó����ִ�ж���cpu�����ſ��ٵ��л���ɵġ�����л�������ġ�

JVM����ʱ�������˶���̣߳������������߳̿��Է����ĳ�����

1��ִ��main�������̣߳�
		���̵߳�������붼������main�����С�

2�������������յ��̡߳�
*/

/*
 * ��δ���һ���̣߳�
 * 		
 * 	  �����̷߳�ʽһ���̳�Thread��
 *		���裺
 *			1.����һ����̳�Thread��
 *			2.����Thread���е�run����
 *			3.ֱ�Ӵ���Thread���Ӷ��󴴽��߳�
 *			4.����start���� �����̲߳������̵߳�����run����ִ��
 * 
 *	 �����̷߳�ʽ���� ʵ��Runnable�ӿ�ʵ��run����
 *		���裺
 *			1. �ø���ʵ��Runnable����
 *			2. ���� Thread���� �������д��� ����Ķ��� Thread t = new Thread(new xxx())
 *			3. ����Thread�����start���� �����̲߳������̵߳�����run����ִ��
 */

class Demo extends Thread{	//�����̷߳�ʽһ���̳�Thread��
	private String name;
	
	Demo(String name){
		super(name);
		this.name = name;
	}
	
	public void run(){	//run������ ��װ���̵߳�����
		for(int x=0; x<10; x++){
			for(int y=-99999; y<99999; y++){}
			System.out.println(name+".....x="+x+"...."+Thread.currentThread().getName());
		}											//	��ȡ��ǰ�̵߳�����
	}
}

class ThreadDemo{
	public static void main(String[] args) {
		Demo d1 = new Demo("����");		//�����߳� d1 d2
		Demo d2 = new Demo("xianqiang");
		d1.start();	//�����߳� ����run()����
		d2.start();
		System.out.println("over...."+Thread.currentThread().getName());
	}
}

/*
class Demo extends Thread{
	private String name;
	Demo(String name){
		super(name);
		this.name = name;
	}
	
	public void run(){
		for(int i=0; i<10; i++){
			for(long j=0;j<99999999;j++){}
			System.out.println(this.name+"...."+i+"...."+"��ǰ�߳���Ϊ��["+Thread.currentThread().getName()+"]");
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		Demo d1 = new Demo("����");
		Demo d2 = new Demo("wangcai");
		d1.start();
		d2.start();
		System.out.println("over......"+"��ǰ�߳���Ϊ��["+Thread.currentThread().getName()+"]");
	}
}
*/

























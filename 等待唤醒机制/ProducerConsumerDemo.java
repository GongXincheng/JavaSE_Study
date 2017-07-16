package 等待唤醒机制;
/*
 * 2017年7月16日15:36:30
 * 
 * 生产者，消费者
 * 多生产者，多消费者的问题
 * 
 * while判断标记，解决了线程获取执行权后，是否要运行
 * notifyAll解决了，本方线程一定会唤醒对方线程
 * 
 * 问题：效率太低。。
 * 
 * 锁的JDK1.5新特性
 * */
class Resource2{
	private String name;
	private int count = 1;
	private boolean flag = false;
	
	public synchronized void set(String name){
		while(flag)	//判断是都有产品，如果有，wait();
			try {this.wait();} catch (InterruptedException e) {}
		this.name = name+count;	//设置产品名称
		count++;
		System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
		flag = true;
		this.notifyAll();	//唤醒另一个线程
	}
	
	public synchronized void out(){
		while( !flag )
			try {this.wait();} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName()+".......消费者......."+name);
		flag = false;
		this.notifyAll();	//唤醒另一个线程
	}
}

class Producer implements Runnable{	//生产者
	private Resource2 r;
	Producer(Resource2 r){
		this.r = r;
	}
	public void run() {
		while(true){
			r.set("烤鸭");
		}
	}
}

class Consumer implements Runnable{	//消费者
	private Resource2 r;
	Consumer(Resource2 r){
		this.r = r;
	}
	public void run() {
		while(true){
			r.out();
		}
	}
}

public class ProducerConsumerDemo {
	public static void main(String[] args) {
		Resource2 r = new Resource2();
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);
		Thread t0 = new Thread(pro);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		Thread t3 = new Thread(con);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}

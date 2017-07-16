package 等待唤醒机制;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
 * 				--------------- 锁的JDK1.5新特性 -------------
 * 				Lock lock = new ReentrantLock();	//创建锁对象
 * 				Condition con = lock.newCondition();//通过已有的锁，获取该锁上的监视器对象
 * 				
 * 				lock.lock(); //获取锁
 * 				try{
 * 					code...
 * 					con.await	//等待
 *					con.signal	//唤醒一个线程
 * 					con.signalAll//唤醒全部线程
 * 				}
 * 				finally{
 *    				 lock.unlock();	//关闭锁
 * 				}
 * 				
 * */
class Resource3{
	private String name;
	private int count = 1;
	private boolean flag = false;
	
	//创建一个锁对象
	Lock lock = new ReentrantLock();
	//通过已有的锁，获取两组视器对象，一组监视生产者，一组监视消费者
	Condition producer_con= lock.newCondition();
	Condition consumer_con = lock.newCondition();
	
	public void set(String name){
		lock.lock(); //获取锁
		try {
			while(flag)	//判断是都有产品，如果有，wait();
//				try {lock.wait();} catch (InterruptedException e) {}
				try {producer_con.await();} catch (InterruptedException e) {}
			this.name = name+count;	//设置产品名称
			count++;
			System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
			flag = true;
			//lock.notifyAll();	//唤醒另一个线程
//			con.signalAll();
			consumer_con.signal();
		}
		finally{
			lock.unlock();
		}
		
	}
	
	public 
	void out(){
		lock.lock(); //获取锁
		try{
			while( !flag )
//				try {this.wait();} catch (InterruptedException e) {}
				try {consumer_con.await();} catch (InterruptedException e) {}
			System.out.println(Thread.currentThread().getName()+".......消费者......."+name);
			flag = false;
			//lock.notifyAll();	//唤醒另一个线程
//			con.signalAll();
			producer_con.signal();
		}
		finally{
			lock.unlock();
		}
	}
}

class Producer1 implements Runnable{	//生产者
	private Resource3 r;
	Producer1(Resource3 r){
		this.r = r;
	}
	public void run() {
		while(true){
			r.set("烤鸭");
		}
	}
}

class Consumer1 implements Runnable{	//消费者
	private Resource3 r;
	Consumer1(Resource3 r){
		this.r = r;
	}
	public void run() {
		while(true){
			r.out();
		}
	}
}

public class ProducerConsumerDemo2 {
	public static void main(String[] args) {
		Resource3 r = new Resource3();
		Producer1 pro = new Producer1(r);
		Consumer1 con = new Consumer1(r);
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

package 练习;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*	2017年7月18日18:37:35
 * 
 * 生产者，消费者
 * 						！！！！！多生产者，多消费者的问题！！！！！
 * 
 *方法一：运用同步函数解决：
 * 		while判断标记，解决了线程获取执行权后，是否要运行
 * 		notifyAll解决了，本方线程一定会唤醒对方线程
 * 		效率低
 * 
 * 方法二：JDK新特性 
 * 		
 *				--------------- 锁的JDK1.5新特性 -------------
 * 					Lock lock = new ReentrantLock();	//创建锁对象
 * 					Condition con = lock.newCondition();//通过已有的锁，获取该锁上的监视器对象
 * 				
 * 					lock.lock(); //获取锁
 * 					try{
 * 						code...
 * 						con.await	//等待
 *						con.signal	//唤醒一个线程
 * 						con.signalAll//唤醒全部线程
 * 					}
 * 					finally{
 *    					 lock.unlock();	//关闭锁
 * 					}
 */

class Product{
	private String name;
	private int count = 1;
	private boolean flag = false;
	
	//创建一个锁对象
	Lock lock = new ReentrantLock();
	//通过已有的锁，获取两组视器对象，一组监视生产者，一组监视消费者
	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();
	
	public void set(String name){
		lock.lock();	//获取锁
		try{	
			while(flag)	//判断产品是否被消费	如果没有被消费(flag=true) 则该线程被冻结
				try { producer_con.await();} catch (InterruptedException e) {}
			this.name = name+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
			flag = true;	//产品已经被生产 flag= true
			consumer_con.signal();	//唤醒 对方线程
		}
		finally{
			lock.unlock();	//释放锁
		}
	}
	
	public void out(){
		lock.lock();	//获取锁
		try{
			while( !flag )	//判断产品是否被消费	如果被消费(flag=false) 则该线程被冻结
				try { consumer_con.await();} catch (InterruptedException e) {}
			System.out.println(Thread.currentThread().getName()+"...........消费者..."+name);
			flag = false;
			producer_con.signal();;	//唤醒对方程
		}
		finally{
			lock.unlock();	//释放锁
		}
	}
	
	/*			---------- 运用同步函数 解决多生产多消费的安全问题  （效率低 ）------------------
 
	public synchronized void set(String name){
		while(flag)	//判断产品是否被消费	如果没有被消费(flag=true) 则该线程被冻结
			try { this.wait();} catch (InterruptedException e) {}
		this.name = name+count;
		count++;
		System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
		flag = true;	//产品已经被生产 flag= true
		this.notifyAll();	//唤醒 对方线程
	}
	
	public synchronized void out(){
		while( !flag )	//判断产品是否被消费	如果被消费(flag=false) 则该线程被冻结
			try { this.wait();} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName()+"...........消费者..."+name);
		flag = false;
		this.notifyAll();	//唤醒对方程
	}
	*/
}

class Producer implements Runnable{
	Product product;
	Producer(Product product){
		this.product = product;
	}
	
	public void run(){
		while(true){
			product.set("烤鸭");
		}
	}
}

class Consumer implements Runnable{
	Product product;
	Consumer(Product product){
		this.product = product;
	}
	
	public void run(){
		while(true){
			product.out();
		}
	}
}

public class ProducerConsumer {
	public static void main(String[] args) {
		//创建资源
		Product pro = new Product();
		//创建线程任务
		Producer producer1 = new Producer(pro);
		Producer producer2 = new Producer(pro);
		Consumer consumer1 = new Consumer(pro);
		Consumer consumer2 = new Consumer(pro);
		//创建线程
		Thread t0 = new Thread(producer1);
		Thread t1 = new Thread(producer2);
		Thread t2 = new Thread(consumer1);
		Thread t3 = new Thread(consumer2);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}

/*	运行结果：
--------------------------------------------
Thread-1...生产者...烤鸭22495
Thread-2...........消费者...烤鸭22495
Thread-0...生产者...烤鸭22496
Thread-3...........消费者...烤鸭22496
Thread-1...生产者...烤鸭22497
Thread-2...........消费者...烤鸭22497
Thread-0...生产者...烤鸭22498
Thread-3...........消费者...烤鸭22498
Thread-1...生产者...烤鸭22499
Thread-2...........消费者...烤鸭22499
Thread-0...生产者...烤鸭22500
Thread-3...........消费者...烤鸭22500
Thread-1...生产者...烤鸭22501
Thread-2...........消费者...烤鸭22501
Thread-0...生产者...烤鸭22502
Thread-3...........消费者...烤鸭22502
Thread-1...生产者...烤鸭22503
Thread-2...........消费者...烤鸭22503
Thread-0...生产者...烤鸭22504
Thread-3...........消费者...烤鸭22504
Thread-1...生产者...烤鸭22505
Thread-2...........消费者...烤鸭22505
Thread-0...生产者...烤鸭22506
Thread-3...........消费者...烤鸭22506
Thread-1...生产者...烤鸭22507
Thread-2...........消费者...烤鸭22507
Thread-0...生产者...烤鸭22508
Thread-3...........消费者...烤鸭22508
---------------------------------------------
*/

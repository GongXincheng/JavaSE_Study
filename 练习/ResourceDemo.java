package 练习; 

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 2017年7月18日17:26:57
 * 
 * 	线程间的通信
 * 			当输入一个信息之后，紧接着输出一个信息
 * 
 * 	方法一：运用同步函数解决：效率低
 * 	方法二： 运用JDK新特性 Lock：效率高
 */

class Resource{
	private String name;
	private String sex;
	private boolean flag = false;
	Lock lock = new ReentrantLock();	//创建锁
	Condition con = lock.newCondition();	//创建一个监视器con
	
	public void set(String name, String sex){
		lock.lock();//获取锁
		try{
			while(flag)
				try { con.await();} catch (InterruptedException e) {} //被冻结 存放在 Resource 对象的线程池中
			this.name = name;
			this.sex = sex;
			flag = true;	//存入信息后 flag为true
			con.signal();;	//唤醒线程池中的线程
		}
		finally{
			lock.unlock();
		}
	}
	public synchronized void out(){
		lock.lock();//获取锁
		try{
			while(!flag)
				try { con.await();} catch (InterruptedException e) {} //被冻结 存放在 Resource 对象的线程池中
			System.out.println(name+"..........."+sex);
			flag = false;	//存入信息后 flag为flase
			con.signal();	//唤醒线程池中的线程
		}
		finally{
			lock.unlock();
		}
	}
	
/*
 * 		运用同步函数解决

	public synchronized void set(String name, String sex){	
		if(flag)	//判断Resource对象中 是否已经存了信息(信息是否被输出)
			try { this.wait();} catch (InterruptedException e) {} //被冻结 存放在 Resource 对象的线程池中
		this.name = name;
		this.sex = sex;
		flag = true;	//存入信息后 flag为true
		this.notify();	//唤醒线程池中的线程
	}
	
	public synchronized void out(){
		if( !flag )
			try { this.wait();} catch (InterruptedException e) {} //被冻结 存放在 Resource 对象的线程池中
		System.out.println(name+"..........."+sex);
		flag = false;	//存入信息后 flag为flase
		this.notify();	//唤醒线程池中的线程
	}
*/
}

	
	
class Input implements Runnable{
	Resource res;
	Input(Resource res){
		this.res = res;
	}
	
	public void run(){
		int x = 0;
		while(true){
			if(x==0){
				res.set("mack", "nan");
			}
			else{
				res.set("丽丽", "女女女女女");
			}
			x = (x+1)%2;
		}
	}
}

class Output implements Runnable{
	Resource res;
	Output(Resource res){
		this.res = res;
	}
	
	public void run(){
		while(true){
			res.out();
		}
	}
}

public class ResourceDemo {
	public static void main(String[] args) {
		//创建资源
		Resource res = new Resource();
		//创建任务
		Input input = new Input(res);
		Output output = new Output(res);
		//创建线程	
		Thread t1 = new Thread(input);
		Thread t2 = new Thread(output);
		t1.start();
		t2.start();
	}
}


/*	运行结果：
 * -------------------
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
丽丽...+...女女女女女
make...+...nan
*/
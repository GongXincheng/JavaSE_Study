package 练习;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 	2017年7月18日16:36:32
 * 
 *  需求：储户，两个，每个都到银行存钱每次存100，共存3次 
 * */
class Bank{
	private int sum;
	Lock lock = new ReentrantLock();
	
//	public synchronized void saveMoney(int num){	//同步函数
//		sum = sum + num;
//		System.out.println("["+Thread.currentThread().getName()+"]存入100后："+sum);
//	}
	
	public void saveMoney(int num){	
		lock.lock();	//获取锁
		try{
			sum = sum + num;
			System.out.println("["+Thread.currentThread().getName()+"]存入100后："+sum);
		}
		finally{
			lock.unlock();	//释放锁
		}
	}
}

class Cus implements Runnable{
	private Bank bank;	//存入的银行
	private int count;	//存的次数
	private int num;	//每次存多少钱
	
	Cus(Bank bank, int count, int num){
		this.bank = bank;
		this.count = count;
		this.num = num;
	}
	
	public void run(){
		for(int i=0; i<count; i++){
			bank.saveMoney(num);	//每次存的钱数
		}
	}
}

public class SaveMoney {
	public static void main(String[] args) {
		
		Bank bank = new Bank();		//创建一个银行对象
		Cus cus1 = new Cus(bank,8,100);	//储户一，及任务
		Cus cus2 = new Cus(bank,3,50);	//储户二，及任务
		Thread t1 = new Thread(cus1,"储户一");	//创建线程1
		Thread t2 = new Thread(cus2,"储户二");	//创建线程2
		t1.start();
		t2.start();
	}
}

/*	运行结果：
 *-------------------------------
[储户一]存入100后：100
[储户一]存入100后：200
[储户一]存入100后：300
[储户一]存入100后：400
[储户一]存入100后：500
[储户一]存入100后：600
[储户二]存入100后：650
[储户二]存入100后：700
[储户二]存入100后：750
[储户一]存入100后：850
[储户一]存入100后：950
 *------------------------------- 
 */
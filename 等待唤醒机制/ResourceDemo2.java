package 等待唤醒机制;

/*
 * 2017年7月16日13:21:20
 * 
 * 多线程通信：等待/唤醒机制
 * 
 * 涉及的方法：	1.wait();	让线程处于冻结状态，被wait线程，会被存储到 线程池 (容器)里	使用时 锁名.wait(); (监视器 -> 锁名)
 * 				2.notify();	唤醒线程池中的一个线程（任意的）。
 * 				3.notifyAll();	唤醒线程池中的所有线程，让线程具备了执行资格
 * 
 * 	这些方法都定义在同步中。
 * 	因为这些方法是用于操作线程状态的方法
 * 	必须要明确到底操作的是哪个锁上的线程
 * 	
 * */

class Resource{
	public String name;
	public String sex;
	public boolean flag = false;	//标记
}

class Input implements Runnable{
	Resource r;
	
	Input(Resource r){
		this.r = r;
	}
	
	public void run(){
		int x = 0;
		while(true){
			synchronized(r){	//同步代码块 锁为r
				if( r.flag )	//如果 Resource中有值，就冻结此线程
					try {r.wait();} catch (InterruptedException e){}
				
				if(x==0){	//如果flag为false，赋值。
					r.name = "make";
					r.sex = "nan";
				}else{
					r.name = "丽丽";
					r.sex = ("女女女女女");
				}
				r.flag = true;	//并把flag设为true
				r.notify();		//并唤醒输出线程
			}
			x = (x+1)%2;
		}
	}
}

class Output implements Runnable{
	Resource r;
	
	Output(Resource r){
		this.r = r;
	}
	public void run(){
		while(true){
			synchronized(r){	// 同步代码块 锁为r
				if( !r.flag )	// 如果 Resource中没有值，冻结
					try {r.wait();} catch (InterruptedException e){}
				System.out.println(r.name+"....."+r.sex);
				r.flag = false;
				r.notify();
			}
		}
	}
}

public class ResourceDemo2 {
	public static void main(String[] args) {
		//创建资源
		Resource r = new Resource();
		//创建任务,把资源的引用放进去
		Input in = new Input(r);
		Output out = new Output(r);
		//创建线程（路径）
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		t1.start();
		t2.start();
	}
}

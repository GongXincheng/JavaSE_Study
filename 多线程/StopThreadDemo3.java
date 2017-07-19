package 多线程;
/*
 * 2017年7月19日11:00:43
 * 
 * 	停止线程：
 * 		1.stop方法（已过时）
 * 
 * 		2.run()方法结束。
 * 			(1)怎么控制线程的任务结束呢？	
 * 				任务中都会有循环结构，只要控制住循环就可以结束任务，从而结束该线程，
 *				 控制循环通常就用定义标记来完成，
 *			但是：如果线程处于了冻结状态，无法读取标记。如何结束呢？
 * 			
 * 			(2)可以使用interrupt()方法将线程从冻结状态强制恢复到运行状态中来，
 * ‘			让线程具备CPU的执行资格
 * 			但是，强制动作会发生InterruptedException异常，记得处理
 * 
 *			(3)使用守护线程(后台线程)：当 前台线程 都结束的时候，守护线程自动结束
 * 			使用  : setDaemon(true)方法，把该线程定义为守护线程
 * */



/*方法2： 使用interrupt()方法将线程从冻结状态强制恢复到运行状态中来*/
class StopThread2 implements Runnable{
	private boolean flag = true;
	
	public synchronized void run(){	//若使用同步函数
		while(flag)
		{
			try { wait(); } 	//当线程被冻结，使用interrupt()方法将线程从冻结状态 强制 恢复到运行状态中来
			catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()+".......catch......"+e);
				flag = false;	//标记关闭
			}
			
			System.out.println(Thread.currentThread().getName()+"....+ + + +........");
		}	
	}
	
	public void setFlag(){
		this.flag = false;
	}
}

public class StopThreadDemo3 {
	public static void main(String[] args) {
		StopThread2 st = new StopThread2();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		t1.start();
		t2.setDaemon(true);	//将t2线程设置为 守护线程
		t2.start();
		
//		for(int i=1; i<=50; i++){
//			System.out.println("main.........."+i);
//			if(i==50){
//				st.setFlag();
//				break;
//			}
//		}
		
		int num = 1;
		for(;;){
			if(++num==50){
//				st.setFlag();
				t1.interrupt();	//使用interrupt()方法将线程从冻结状态强制恢复到运行状态中来
//				t2.interrupt();
				break;
			}
			System.out.println("main.........."+num);
		}
		
		System.out.println("over");
	}
}

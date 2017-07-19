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
 *				 控制循环通常就用定义标记来完成
 * 			
 * */



/*方法1：  此方法可能会出问题*/
class StopThread implements Runnable{
	private boolean flag = true;
	
	public void run(){
		while(flag)
			System.out.println(Thread.currentThread().getName()+".................");
	}
	
	public void setFlag(){
		this.flag = false;
	}
}

public class StopThreadDemo1 {
	public static void main(String[] args) {
		StopThread st = new StopThread();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		t1.start();
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
				st.setFlag();
				break;
			}
			System.out.println("main.........."+num);
		}
		
		System.out.println("over");
	}
}

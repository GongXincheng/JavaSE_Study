package 练习;

/*
 * 2017年7月18日16:28:25
 * 
 * 复习 多线程卖票示例，发现线程安全问题
 * 并运用    同步代码块 (锁为任意对象)
 * 和运用    同步函数 (锁为 this)  解决线程的安全问题
 * 
 * */

class Ticket implements Runnable{
	private int num = 50;
	
	public void run(){
		while(true){
			show();
			if(num<=0){
				System.out.println("票已售空！");
				break;
			}
		}
	}
	
	public synchronized void show(){	//同步函数 解决线程安全问题, 他的锁为 this
		if(num>0){
			try { Thread.sleep(10); } catch (InterruptedException e) {}	//检测线程安全问题 sleep();
			System.out.println("["+Thread.currentThread().getName()+"]售出："+num--+"号门票");
		}
	}
	
//	public void run(){
//		while(true){
//			synchronized(this){		// 同步代码块
//				if(num>0){
//					try { Thread.sleep(10); } catch (InterruptedException e) {}	//检测线程安全问题 sleep();
//					System.out.println("["+Thread.currentThread().getName()+"]售出："+num--+"号门票");
//				}else{
//					System.out.println("票已售空！");
//					break;
//				}	
//			}		
//		}
//	}
}

public class SaleTicket {
	public static void main(String[] args) {
		Ticket t = new Ticket();
		Thread t1 = new Thread(t, "一号窗口");
		Thread t2 = new Thread(t, "二号窗口");
		Thread t3 = new Thread(t, "三号窗口");
		Thread t4 = new Thread(t, "四号窗口");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

/*
 * 运行结果
 * --------------------
 * 
	[一号窗口]售出：50号门票
	[一号窗口]售出：49号门票
	[四号窗口]售出：48号门票
	[四号窗口]售出：47号门票
	[四号窗口]售出：46号门票
	[四号窗口]售出：45号门票
	[四号窗口]售出：44号门票
	[四号窗口]售出：43号门票
	[四号窗口]售出：42号门票
	[四号窗口]售出：41号门票
	[四号窗口]售出：40号门票
	[四号窗口]售出：39号门票
	[四号窗口]售出：38号门票
	[四号窗口]售出：37号门票
	[四号窗口]售出：36号门票
	[四号窗口]售出：35号门票
	[四号窗口]售出：34号门票
	[四号窗口]售出：33号门票
	[四号窗口]售出：32号门票
	[四号窗口]售出：31号门票
	[四号窗口]售出：30号门票
	[四号窗口]售出：29号门票
	[四号窗口]售出：28号门票
	[四号窗口]售出：27号门票
	[四号窗口]售出：26号门票
	[四号窗口]售出：25号门票
	[四号窗口]售出：24号门票
	[四号窗口]售出：23号门票
	[四号窗口]售出：22号门票
	[三号窗口]售出：21号门票
	[三号窗口]售出：20号门票
	[三号窗口]售出：19号门票
	[三号窗口]售出：18号门票
	[三号窗口]售出：17号门票
	[三号窗口]售出：16号门票
	[三号窗口]售出：15号门票
	[三号窗口]售出：14号门票
	[三号窗口]售出：13号门票
	[三号窗口]售出：12号门票
	[三号窗口]售出：11号门票
	[三号窗口]售出：10号门票
	[三号窗口]售出：9号门票
	[三号窗口]售出：8号门票
	[三号窗口]售出：7号门票
	[三号窗口]售出：6号门票
	[三号窗口]售出：5号门票
	[三号窗口]售出：4号门票
	[三号窗口]售出：3号门票
	[三号窗口]售出：2号门票
	[三号窗口]售出：1号门票
	票已售空！
	票已售空！
	票已售空！
	票已售空！
 * */

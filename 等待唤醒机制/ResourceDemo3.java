package 等待唤醒机制;
/*
 * 2017年7月16日14:40:19
 * 
 * 代码优化
 * 
 * */
class Resource1{
	private String name;
	private String sex;
	private boolean flag = false;	//标记
	
	public synchronized void set(String name, String sex){
		if(flag)
			try { this.wait();} catch (InterruptedException e) {}
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();
	}
	
	public synchronized void out(){
		if(!flag)
			try { this.wait();} catch (InterruptedException e) {}
		System.out.println(name+"...+..."+sex);
		flag = false;
		this.notify();
	}
}

class Input1 implements Runnable{
	Resource1 r;
	
	Input1(Resource1 r){
		this.r = r;
	}
	
	public void run(){
		int x = 0;
		while(true){
			if(x==0){	//如果flag为false，赋值。
				r.set("make", "nan");
			}else{
				r.set("丽丽", "女女女女女");
			}
			x = (x+1)%2;
		}
	}
}

class Output1 implements Runnable{
	Resource1 r;
	
	Output1(Resource1 r){
		this.r = r;
	}
	
	public void run(){
		while(true){
			r.out();
		}
	}
}

public class ResourceDemo3 {
	public static void main(String[] args) {
		//创建资源
		Resource1 r = new Resource1();
		//创建任务,把资源的引用放进去
		Input1 in = new Input1(r);
		Output1 out = new Output1(r);
		//创建线程（路径）
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		t1.start();
		t2.start();
	}
}

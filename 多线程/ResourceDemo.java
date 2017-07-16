package 多线程;

/*
 * 2017年7月16日09:48:32
 * 
 * 线程间通信：
 * 		1.多个线程在处理同一资源，任务却不同
 * 		此时没有等待唤醒机制
 */

//资源
class Resource
{
	public String name;
	public String sex;
	public boolean flag = false;
}
//输入
class input implements Runnable
{
	Resource s;
	input(Resource s){	//创建时，就有资源
		this.s = s;
	}
	
	public void run(){
		int x = 0;
		while(true){
			synchronized(s){
				if( x==0 ){
					s.name = "mick";
					s.sex = "nan";
				}
				else{
					s.name = "丽丽";
					s.sex = "女女女女女女女";
				}
			}
			x = (x+1)%2;
		}
	}
}
//输出
class output implements Runnable{
	Resource s;
	output(Resource s){	//创建时，就有资源
		this.s = s;
	}
	
	public void run(){
		while(true){
			synchronized(s){
				System.out.println(s.name+"....."+s.sex);
			}
		}
	}
}

public class ResourceDemo {
	public static void main(String[] args) {
		//创建资源
		Resource r = new Resource();
		//创建任务,把资源的引用放进去
		input in = new input(r);
		output out = new output(r);
		//创建线程（路径）
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		t1.start();
		t2.start();
	}
}

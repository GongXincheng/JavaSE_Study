package 异常;
/* 	
 * 		2017年7月15日 10:22:01
 * 需求：
 * 		毕老师用电脑上课	
 * 		老师上课笔记本随时携带
 * 		涉及两个对象
 * 
 * 分析问题：
 * 	比如： 电脑蓝屏了，冒烟了
 */
class LanPingException extends Exception	//蓝屏异常
{	
	LanPingException(String msg){
		super(msg);
	}
}

class MaoYanException extends Exception		//冒烟异常
{	
	MaoYanException(String msg){
		super(msg);
	}
}
class NoPlanException extends Exception
{
	NoPlanException(String msg){
		super(msg);
	}
}

class Computer
{
	private int state = 2;   //刻意的设置的电脑状态：0为正常，1为蓝屏，2为冒烟
	
	public void run() throws LanPingException,MaoYanException{
		if(state==1){
			throw new LanPingException("蓝屏啦！");
		}
		if(state==2){
			throw new MaoYanException("冒烟啦！");
		}
		System.out.println("电脑运行..");
	}
	public void reset()	{	//电脑重启
		state = 0;
		System.out.println("电脑重启.......");
	}
}

class Teacher
{
	private String name;
	private Computer comp;	//老师有电脑
	
	Teacher(String name){
		this.name = name;
		comp = new Computer();	//电脑随身携带
	}
	
	public void prelect() throws NoPlanException{
		try{
			comp.run();
			System.out.println(name+"讲课...");
		}
		catch(LanPingException e){
			System.out.println(e.toString());
			comp.reset();	//重启
			prelect();	//讲课
		}
		catch(MaoYanException e){
			System.out.println(e.toString());
			test();
			//可以对电脑进行维修
			throw new NoPlanException("课时进度无法完成："+e.getMessage());
		}
	}
	
	public void test(){
		System.out.println("大家练习...");
	}
}

public class ExceptionTest {
	public static void main(String[] args) {
		Teacher t = new Teacher("毕老师");
		try {
			t.prelect();
		} catch (NoPlanException e) {
			System.out.println(e.toString()+"......");
			System.out.println("换人...");
		}
	}
}

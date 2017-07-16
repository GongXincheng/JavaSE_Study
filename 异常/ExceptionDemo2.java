package 异常;
/*
 * 	异常处理的捕捉形式
 * 
 * 	格式：
 * 	try
 *	{
 * 		//需要被检测的异常代码
 * 	}
 * 	catch(异常类 变量)	//该变量用于接收发生的异常对象
 *	{
 * 		//处理异常的代码。
 * 	}
 * 	finally
 * 	{
 * 		一定会被执行的代码。
 * 	}
 * 
 */

class FuShuIndexExpetion1 extends Exception // 自定义的异常类
{
	private static final long serialVersionUID = 1L;

	FuShuIndexExpetion1()
	{}	
	FuShuIndexExpetion1(String msg)
	{
		super(msg);
	}
}

class Demo1
{
	public int method(int[] arr, int index)throws FuShuIndexExpetion1,NullPointerException
	{
		if( index<0 )
			throw new FuShuIndexExpetion1("数组角标为负数,"+index);
		if(arr == null){
			throw new NullPointerException("空指针异常");
		}
		
		return arr[index];
	}
}

public class ExceptionDemo2 {
	public static void main(String[] args){
		int[] arr = new int[3];
		Demo1 d = new Demo1();
		
		try{
			int num = d.method(null, 30);
			System.out.println("num = "+num);
		}
		catch(FuShuIndexExpetion1 e){
			System.out.println("数组角标为负数!.....");
		}
		catch(NullPointerException e){
			System.out.println("空指针异常.....");
		}
		catch(Exception e){
			System.out.println("其他异常.....");
		}
		finally{
			System.out.println("必须执行的语句...");
		}
		
		System.out.println("over");
	}
}

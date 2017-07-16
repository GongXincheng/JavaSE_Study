/*	
 * 2017年7月14日 17:27:08
 * 	自定义异常类  
 *  注意声明异常
 *  
 *  1.编译时被检测异常：只要是Exception和其子类都是，除了特殊子类 RuntimeException 体系
 *  	这种问题一旦出现，希望在编译时就进行检测，让这种问题有对应的处理方式
 *  	这样的问题都可以针对性的处理
 *  
 *  2.编译时不检测异常（运行时异常）：Exception中的 RuntimeException 和其子类
 *  	这种问题的发生，无法让功能继续，运算无法进行，更多是因为调用者的原因导致的，或者引发了内部状态的改变导致的
 *  	这种问题一般不处理，直接编译通过，在运行时，让调用者调用的程序强制停止，让调用者对代码进行修正。
 *  
 */		
package 异常;

class FuShuIndexExpetion extends Exception 
{
	private static final long serialVersionUID = 1L;

	FuShuIndexExpetion()
	{}	
	FuShuIndexExpetion(String msg)
	{
		super(msg);
	}
}
class Demo
{
	public int method(int[] arr, int index) throws FuShuIndexExpetion {
		if(arr == null)
			throw new NullPointerException("数字的引用不能为空！");
		if( index>=arr.length )
			throw new ArrayIndexOutOfBoundsException("数组角标越界,"+index);
		if( index<0 )
			throw new FuShuIndexExpetion("数组角标为负数,"+index);	//"数组角标为负数,"+index
		
		return arr[index];
	}
}

public class ExceptionDemo {
	public static void main(String[] args) throws FuShuIndexExpetion {
		int[] arr = new int[3];
		Demo d = new Demo();
		int num = d.method(arr, -30);
		System.out.println("num = "+num);
	}
}

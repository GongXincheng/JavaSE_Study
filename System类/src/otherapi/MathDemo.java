package otherapi;
/*
 * 2017年7月26日 14:12:47
 */
public class MathDemo {

	public static void main(String[] args) {
		
		/*
		 * Math：提供了操作数学运算的方法。都是静态的
		 * 
		 * 常用方法：
		 * double ceil(double a)	 返回大于参数的最小整数
		 * double floor(double a) 	 返回小于参数的最大整数
		 * double round(float a) 		 返回四舍五入的整数
		 * 
		 * double pow(double a, double b)  返回第一个参数的第二个参数次幂的值。
		 * 
		 * 
		 */
		double d1 = Math.ceil(12.46);
		double d2 = Math.floor(12.56);
		double d3 = Math.round(12.56);
		double d4 = Math.pow(10, 2);
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(d4);
		
		for (int i = 0; i < 5; i++) {
			double b = Math.ceil( Math.random()*10 );		//  1-10
//			double b1 = Math.floor( Math.random()*10 );		//  0-9
			System.out.println(b);
			
		}
		
	}
	
}

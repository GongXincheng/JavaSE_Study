package otherapi.demo;
/*
 * 2017年7月26日 15:06:07
 * 
	 * 日期对象和毫秒值之间的转换
	 * 
	 * 毫秒值 -> 日期对象 
	 * 		1.Date对象的构造方法  new Date(毫秒值);
	 * 		2.还可以通过 setTime() 设置
	 * 因为可以通过Date对象的方法对该日期中的各个字段（年月日等）进行操作
	 * 		
	 * 
	 * 日期对象 -> 毫秒值
	 * 		2.Date对象的 getTime();
	 * 因为可以通过具体的数值进行运算	
	 * 
 */
import java.util.Date;

public class DateDemo1 {

	public static void main(String[] args) {

//获取毫秒值
//		long time = System.currentTimeMillis();	//1501050972857
//		System.out.println(time);

//将当前日期和时间封装成对象
		Date date = new Date();
		System.out.println(date);	// Wed Jul 26 14:37:21 CST 2017

//毫秒值 -> 日期对象 
		Date date2 = new Date(1501050972857l);	//将指定毫秒值封装成对象
		System.out.println(date2);
		date2.setTime(1501050972857l);
		System.out.println(date2);
		
//日期对象 -> 毫秒值
		Date date3 = new Date();
		long time = date3.getTime();
		System.out.println(time);	//1501055842694
		
		System.out.println(date3.after(date2));	//测试此日期是否在指定日期之后。
		System.out.println(date3.compareTo(date2));	// 1
	
	}
	
	
}

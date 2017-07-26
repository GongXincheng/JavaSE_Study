package otherapi;

import java.util.Properties;
import java.util.Set;

/*
 * 2017年7月26日 12:21:42
 */
public class SystemDemo {
	public static void main(String[] args) {
		
//		long l1 = 1501042895455l;
//		System.out.println(l1);//1501042895455
//		
//		long l2 = System.currentTimeMillis();
//		System.out.println(l2-l1);
		
//		demo_1();	
		
		System.out.println("hello-"+System.getProperty("line.separator")+" world");
		System.out.println("操作系统："+System.getProperty("os.name"));
		System.out.println("系统版本："+System.getProperty("os.version"));
		System.out.println("系统架构："+System.getProperty("os.arch"));
		System.out.println("用户姓名："+System.getProperty("user.name"));
		System.out.println("java版本："+System.getProperty("java.version"));
		//给系统设置属性信息，全局的，其他程序也可以使用
	}

	public static void demo_1() {
		// TODO Auto-generated method stub
		//获取系统的属性信息，并存储了Properties集合中
		/*
		 * Properties集合中存储的都是String类型的键和值
		 * 最好使用他自己的存储和取出的方法来完成
		 * setProperty(String key, String value) 
		 */
		Properties prop = System.getProperties();
		Set<String> nameSet = prop.stringPropertyNames();
		for(String name : nameSet){
			String value = prop.getProperty(name);
			System.out.println(name+" ---- "+value);
		}
	}
}

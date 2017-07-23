package p2.generic.define.demo;
/*
 * 2017年7月23日 12:59:23
  
 	自定义泛型类:
	在1.5后，使用泛型来接收类中要操作的引用数据类型
	泛型类。 什么时候用？  当类中操作的引用数据类型不确定的时候，就用泛型来表示。
*/
public class Tool<QQ> {
	private QQ q;

	public QQ getObject() {
		return q;
	}

	public void setObject(QQ object) {
		this.q = object;
	}
	
	/**
	 * 将泛型定义在方法上
	 * @param str
	 */
	public <W> void show(W str){
		System.out.println("show : " + str);
	}
	
	public void print(QQ str){
		System.out.println("print : " + str);
	}
	
	
	/**
	 * 当方法静态时，能不能访问类上定义的泛型
	 * 如果静态方法使用泛型，只能将泛型定义在方法上！
	 * @param obj
	 */
	public static <Y> void method( Y obj ){
		System.out.println("method : " + obj);
	}
	
}


/*
public class Tool {
	
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}
*/
	


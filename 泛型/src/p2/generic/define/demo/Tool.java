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
	


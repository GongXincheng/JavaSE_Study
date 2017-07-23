package p2.generic.define.demo;

public class GenericDefineDemo3 {
	
	public static void main(String[] args) {
		
		InterImpl2<Integer> in2 = new InterImpl2<Integer>();
		in2.show(5);
		
//		InterImpl in = new InterImpl();
//		in.show("abc");
	}
	
}

//泛型接口，将泛型定义在接口上
interface Inter<T>{
	public void show(T t);
}


class InterImpl2<Q> implements Inter<Q>{
	@Override
	public void show(Q q) {
		// TODO Auto-generated method stub
		System.out.println("show :" + q);
	}
}

/*
class InterImpl implements Inter<String>{
	public void show(String str){
		System.out.println(str);
	}
}
*/
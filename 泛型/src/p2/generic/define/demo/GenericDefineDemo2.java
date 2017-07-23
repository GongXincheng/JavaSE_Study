package p2.generic.define.demo;

public class GenericDefineDemo2 {
	public static void main(String[] args) {
		
		Tool<String> tool = new Tool<String>();
		
		tool.show(new Integer(4));
		tool.show("abc");
		tool.print("hahaah");
		
		Tool.method("hahaah");
		Tool.method(new Integer(9));
	}
}

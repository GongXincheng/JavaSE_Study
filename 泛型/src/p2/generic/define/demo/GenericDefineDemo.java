package p2.generic.define.demo;
//	2017年7月23日 12:58:26
import p.bean.Student;
import p.bean.Worker;

public class GenericDefineDemo {
	public static void main(String[] args) {
		
		Tool<Student> tool = new Tool<Student>();
		
		tool.setObject(new Student());
		Student stu = tool.getObject();
		
//		Tool tool = new Tool();
//		tool.setObject(new Worker());
//		Student stu = (Student)tool.getObject();
		
	}
}

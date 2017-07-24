package p.bean;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {		//按照年龄排序
		// TODO Auto-generated method stub
		int temp = this.age - o.age;
		
		return temp==0 ? this.name.compareTo(o.name) : temp;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person: "+name+": "+age;
	}
	
	
}

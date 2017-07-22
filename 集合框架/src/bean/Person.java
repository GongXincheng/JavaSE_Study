package bean;

public class Person {
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
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		System.out.println(this+".....hashcode方法..");
		
		return name.hashCode()+age;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if(this == obj)		//如果传同一个对象
			return true;
		if(! (obj instanceof Person))	//如果类型不同 抛出异常
			throw new ClassCastException("类型不对~");
			
		System.out.println(this +".....equals方法...." +obj);
		Person p = (Person)obj;	
		
		return this.name.equals(p.name) && this.age == p.age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+":"+age;
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

	
	
	
}

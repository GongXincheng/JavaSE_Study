package bean;

public class Person implements Comparable{
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
	

 // HashSet的时候需要重写这个方法
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
//		System.out.println(this+".....hashcode方法..");
		
		return name.hashCode()+age;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if(this == obj)		//如果传同一个对象
			return true;
		if(! (obj instanceof Person))	//如果类型不同 抛出异常
			throw new ClassCastException("类型不对~");
			
//		System.out.println(this +".....equals方法...." +obj);
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
//		System.out.println("------compareTo------");
		Person p = (Person)o;
		
		
		int temp = this.age - p.getAge() ;	//如果年龄相同比较名字
		return temp==0 ? this.name.compareTo(p.getName()) : temp ;
		
//		int temp = this.name.compareTo(p.getName());//如果名字相同比较年龄
//		return temp==0 ? this.age-p.getAge() : temp;
		
/*		
		if(this.age>p.age)
			return -1;
		if(this.age<p.age)
			return 1;
		if(this.age == p.age)
			return this.name.compareTo(p.name);
	
		return 0;
*/	
	}

	
	
	
}

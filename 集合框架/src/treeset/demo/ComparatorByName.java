package treeset.demo;

import java.util.Comparator;
import bean.Person;
/**
 * 	创建了一个根据Person类的name进行排序的比较器
 */
public class ComparatorByName implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		
		Person p1 = (Person)o1;
		Person p2 = (Person)o2;
		
		int temp = p1.getName().compareTo(p2.getName());
		
		return temp==0 ? p1.getAge()-p2.getAge() : temp;
		
//		return 1;  //有序输出     return -1; 逆序输出
	}

}

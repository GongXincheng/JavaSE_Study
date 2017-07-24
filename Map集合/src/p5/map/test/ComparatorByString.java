package p5.map.test;

import java.util.Comparator;

public class ComparatorByString implements Comparator<Character>{

	@Override
	public int compare(Character o1, Character o2) {
		// TODO Auto-generated method stub
		int temp = o1.compareTo(o2);
		return temp;
	}

}

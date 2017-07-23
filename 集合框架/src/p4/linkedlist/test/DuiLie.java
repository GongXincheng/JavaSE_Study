package p4.linkedlist.test;
/*
 * 	2017年7月21日19:18:51
 */
import java.util.LinkedList;

public class DuiLie{
	private LinkedList link;
	
	public DuiLie(){
		link = new LinkedList();
	}
	
	public void myAdd(Object obj){
		link.addLast(obj);
	}
	
	public Object myGet(){
		return link.removeFirst();
	}
	
	public boolean isNull(){
		return link.isEmpty();
	}
}

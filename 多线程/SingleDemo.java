package ���߳�;
/*
 * 2017��7��16�� 09:30:12
 * 
 * ���߳��µĵ������ģʽ��
 * ����ʽЧ�ʺͰ�ȫ�Ľ��
 */

//����ʽ
class Single
{
	private static final Single s = new Single();
	private Single(){}
	public static Single getInstance(){
		return s;
	}
}

/*����ʽ*/
class Single1
{
	private static Single1 s = null;
	private Single1(){}
	public static Single1 getInstance(){
		if(s==null){
			synchronized(Single1.class){
				if(s == null){
					s = new Single1();
				}
			}
		}
		return s;
	}
}

public class SingleDemo {

}

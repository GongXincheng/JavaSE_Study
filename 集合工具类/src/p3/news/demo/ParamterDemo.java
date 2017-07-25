package p3.news.demo;

public class ParamterDemo {
	public static void main(String[] args) {
		
		int sum = add(1,2,3);
		System.out.println(sum);
		
		int[] arr = {1,2,3,4,5,6,7,8,9};
		sum = add(arr);
		System.out.println(sum);
		
		sum = newAdd(1,2,3,5,7,8);
		System.out.println(sum);
	}
	
	public static int newAdd(int... arr){	
		/*
		 *	 	函数的可变参数，其实就是数组，但是接受的是数组中的元素
		 * 		自动将这些元素封装成数组，简化了调用者的书写。
		 * 注意事项：可变参数类型，必须定义在参数列表的结尾。
		 * 
		 */
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	
	
	public static int add(int[] arr){
		int sum = 0;;
		for(int a : arr){
			sum+=a;
		}
		return sum;
	}
	
	
	
	public static int add(int a, int b, int c){
		return a+b+c;
	}
}

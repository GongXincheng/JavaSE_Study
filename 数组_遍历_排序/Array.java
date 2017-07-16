package 数组_遍历_排序;

/*
 *	2017年5月27日 22:14:50 
 *
 *	关于数组的逆序、排序、最大值、折半（二分）查询、普通查询
 *	折半（二分）查询需要对数组排序（从小到大）后使用
 */

import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入创建数组的长度：");
		int length = sc.nextInt();		//用户从键盘输入数据
		int[] arr = new int[length];	//创建指定长度的数组
		
		arr_input(arr,sc);	//为数组各个元素赋值
		
		//把数组逆序
		arr_nixu(arr);	
		System.out.print("逆序为：");
		arr_output(arr);//输出数组的各元素
		
		//求最大值
		int max = getMax(arr); 
		System.out.println("最大值："+max);
		
		//输出排序前的数组
		System.out.print("排序前：");
		arr_output(arr);
		
		//进行排序
		arr_sort2(arr);	
//		Arrays.sort(arr);	等价于
		System.out.print("排序后：");
		arr_output(arr);
		
		//查询
		System.out.print("请输入要查询的数：");
		int key = sc.nextInt();
		int index = halfSearch3(arr, key);
//		int index = Arrays.binarySearch(arr, key);  等价于
		System.out.println("arr["+index+"]="+key);
		
		sc.close();
	}
	
	//为数组初始化
	public static void arr_input(int[] arr,Scanner sc){
		System.out.print("请输入"+arr.length+"位整数：");
		for(int i=0;i<arr.length;i++){
			arr[i] = sc.nextInt();
		}
		return;
	}
	
	//输出数组的值
	public static void arr_output(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		return;
	}
	
	//数组逆序排列
	public static void arr_nixu(int[] arr){
		for(int i=0,j=arr.length-1; i<j; i++,j--){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return;
	}
	
	//获取最大值
	public static int getMax(int[] arr){
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max){
				max = arr[i];
			}
		}
		return max;	
	}
	
	//选择排序
	public static void arr_sort1(int arr[]){
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	//冒泡排序
	public static void arr_sort2(int arr[]){
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return;
	}
	
	//step1：二分法折半查找
	public static int halfSearch1(int[] arr, int key){
		int max,mid,min;
		min = 0;
		max = arr.length-1;
		mid = (min+max)>>1;
		
		while(arr[mid]!=key){
			if(key>arr[mid]){
				min = mid+1;
			}
			else if(key<arr[mid]){
				max = mid-1;
			}
			
			if(max<min)
				return -1;
			
			mid = (max+min)>>1;
		}
		return mid;
	}
	
	//step2：二分法折半查找
	public static int halfSearch2(int[] arr, int key){
		int max,mid,min;
		min = 0;
		max = arr.length-1;
		mid = (min+max)/2;
		
		while(min<=max){
			mid = (max+min)>>1;
		
			if(key>arr[mid])
				min = mid + 1;
			else if(key<arr[mid])
				max = mid - 1;
			else
				return mid;
		}
		return -1;
	}
	
	//step3：普通的查询
	public static int halfSearch3(int[] arr, int key){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==key){
				return i;
			}
		}
		return -1;
	}
}

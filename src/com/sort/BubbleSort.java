package com.sort;

public class BubbleSort {
	
	public static void main(String[] args) {
		Integer[] a = new Integer[]{12,9,11,5,8,43};
		
		bubble(a);
		
		printResult(a);
	}
	
	public static void printResult(Integer[] a) {
		for (int i = 0; i < a.length; i++) {
			
			if (i == a.length-1) {
				System.out.print(a[i]);
			}else{
				System.out.print(a[i]+",");
			}
			
		}
	}

	public static void bubble(Integer[] arr){
		
		//外层循环控制排序趟数
		for(int i=0;i<arr.length-1;i++){
			//内层循环控制每一趟排序多少次
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		} 
	}
	
	
}

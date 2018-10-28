package com.sort;

public class FastSort {

	public static void main(String[] args) {

		Integer[] a = new Integer[] { 12, 9, 11, 5, 8, 43 };

		fastSort(a, 0, a.length - 1);
		printResult(a);
	}

	private static void fastSort(Integer[] a, int first, int end) {
		// TODO Auto-generated method stub

		if (first >= end) {
			return;
		}
		int index = partion(a, first, end);
		fastSort(a, first, index - 1);
		fastSort(a, index + 1, end);
	}

	// private static int partion(Integer[] a, int first, int end) {
	//
	//// int key = a[first];
	// int i = first;
	// int j = end;
	// while (i<j) {
	// //从右边往左边扫描
	// while((i<j)&&(a[i]<a[j])){
	// j--;
	// }
	// //交换
	// if (i < j) {
	// int temp = a[i];
	// a[j] = a[i];
	// a[i] = temp;
	// i++;
	// }
	// //从左边往右边扫描
	// while((i<j)&&(a[i]<a[j])){
	// i++;
	// }
	// //交换
	// if (i < j) {
	// int temp = a[i];
	// a[j] = a[i];
	// a[i] = temp;
	// j--;
	// }
	// }
	// return i;
	// }

	private static int partion(Integer[] r, int first, int end) {

		int i = first;
		int j = end; // 初始化
		while (i < j) {
			while (i < j && r[i] < r[j]){
				j--; // 右侧扫描
			}
			if (i < j) {
				// 将较小记录交换到前面
				// r[i]←→r[j];
				Integer temp = r[j];
				r[j] = r[i];
				r[i] = temp;
				i++; 
			}
			while (i < j && r[i] < r[j]){
				i++; // 左侧扫描
			}
				
			if (i < j) {
				// 将较大记录交换到后面
				// r[j]←→r[i];
				Integer temp = r[j];
				r[j] = r[i];
				r[i] = temp;
				j--; 
			}
		}
		return i; // i为轴值记录的最终位置
	}

	public static void printResult(Integer[] a) {
		for (Integer i = 0; i < a.length; i++) {
			if (i == a.length - 1) {
				System.out.print(a[i]);
			} else {
				System.out.print(a[i] + ",");
			}
		}
	}
}

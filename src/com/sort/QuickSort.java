package com.sort;

public class QuickSort {

	public static void main(String[] args) {

		Integer[] a = new Integer[] { 12, 9, 11, 5, 8, 43 };

		sort(a,0,a.length-1);

		printResult(a);
	}

	public static void printResult(Integer[] a) {
		for (Integer i = 0; i < a.length; i++) {
			if (i == a.length-1) {
				System.out.print(a[i]);
			}else{
				System.out.print(a[i]+",");
			}
		}
	}
	
	public static Integer partition(Integer[] array, Integer lo, Integer hi) {
		//固定的切分方式
		//以第一个元素为轴值
		Integer key = array[lo];
		while (lo < hi) {
			
			while (array[hi] > key && hi > lo) {// 从后半部分向前扫描
				hi--;
			}
			
			if (lo<hi) {
				array[lo] = array[hi];
			}
			
			while (array[lo] < key && hi > lo) {// 从前半部分向后扫描
				lo++;
			}
			
			if (lo<hi) {
				array[hi] = array[lo];
			}
		}
		array[hi] = key;
		return hi;
	}

	public static void sort(Integer[] array, Integer lo, Integer hi) {
		if (lo >= hi) {
			return;
		}
		Integer index = partition(array, lo, hi);
		sort(array, lo, index - 1);
		sort(array, index + 1, hi);
	}
}

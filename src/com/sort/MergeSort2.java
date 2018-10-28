package com.sort;

import java.util.Arrays;

public class MergeSort2 {

	public static void main(String[] args) {
		int a[] = { 51, 46,20, 18, 65, 97, 82, 30, 77, 50 };
		MergeSort(a);
		System.out.println("排序结果：" + Arrays.toString(a));
		
		
//		int[] b = new int[10];
//		b[0]=1;
//		b[1]=1;
//		b[2]=1;
//		b[3]=1;
//		
//		for (int i = 0; i < b.length; i++) {
//			System.out.println(b[i]);
//		}
//		
		
	}

	public static void MergeSort(int[] arr) {
		// 使用非递归的方式来实现归并排序
		int len = arr.length;
		int k = 1;

		while (k < len) {
			MergePass(arr, k, len);
			System.out.println("k="+k+"排序结果：" + Arrays.toString(arr));
			k *= 2;
			
		}
	}

	// MergePass方法负责将数组中的相邻的有k个元素的字序列进行归并
	private static void MergePass(int[] arr, int k, int n) {
		int i = 0;

		// 从前往后,将2个长度为k的子序列合并为1个
		while (i < n - 2 * k + 1) {
			merge(arr, i, i + k - 1, i + 2 * k - 1);
			i += 2 * k;
		}

		// 这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。
		if (i < n - k) {
			merge(arr, i, i + k - 1, n - 1);
		}


	}


	// merge函数实际上是将两个有序数组合并成一个有序数组
	// 因为数组有序，合并很简单，只要维护几个指针就可以了
	private static void merge(int[] arr, int low, int mid, int high) {
		// temp数组用于暂存合并的结果
		int[] temp = new int[high - low + 1];
		// 左半边的指针
		int i = low;
		// 右半边的指针
		int j = mid + 1;
		// 合并后数组的指针
		int k = 0;

//		for (; i <= mid && j <= high; k++) {
//			if (arr[i] < arr[j])
//				temp[k] = arr[i++];
//			else
//				temp[k] = arr[j++];
//		}

		// 将记录由小到大地放进temp数组
		while(i <= mid && j <= high){
			if (arr[i] < arr[j])
				temp[k] = arr[i++];
			else
				temp[k] = arr[j++];
			k++;
		}

		// 接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
		while (i <= mid)
			temp[k++] = arr[i++];

		while (j <= high)
			temp[k++] = arr[j++];

		// 将temp数组中的元素写入到待排数组中
		for (int l = 0; l < temp.length; l++)
			arr[low + l] = temp[l];
	}
}

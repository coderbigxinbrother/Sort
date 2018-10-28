package com.sort;

import java.util.Arrays;

public class MyMergeSort {

	public static void main(String[] args) {
		int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
		MergeSort(a);
		System.out.println("排序结果：" + Arrays.toString(a));
	}


	private static void MergeSort(int[] a) {
		
		int n = a.length;
		int k = 1;
		while(k<n){
			
			MergePass(a, k, n);
			System.out.println("k="+k+"排序结果：" + Arrays.toString(a));
			k = k*2;
		}

	}
	
	// MergePass方法负责将数组中的相邻的有k个元素的字序列进行归并
	//归并排序还有一个重要的步骤就是 归并的过程
	// 当i<n+1-2k,k为长度
	// 当i<n-k时
	private static void MergePass(int[] arr, int k, int n) {
		
		int i = 0;
		while (i<n+1-2*k) {
			Merge(arr, i, i+k-1, i+2*k-1);
			i += 2 * k;
		}
		
		if(i<n-k){
			Merge(arr, i, i+k-1, n-1);
		}
	}

	// 将两个序列合并一个序列
	// 参数 arr low mid high
	private static void Merge(int[] arr, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int[] temp = new int[high - low + 1];

		int i = low;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= high) {

			if (arr[i] < arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= high) {
			temp[k++] = arr[j++];
		}

		for (int n = 0; n < temp.length; n++) {
			arr[low + n] = temp[n];
		}
	}
}

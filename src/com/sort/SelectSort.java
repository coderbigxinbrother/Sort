package com.sort;

public class SelectSort {

	public static void main(String[] args) {

		int[] a = new int[] { 12, 9, 11, 5, 8, 43 };

		selectSort(a);
		printResult(a);
	}

	public static void printResult(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (i == a.length - 1) {
				System.out.print(a[i]);
			} else {
				System.out.print(a[i] + ",");
			}
		}
	}

	public static void selectSort(int r[]) {

		int index = 0;
		for (int i = 0; i < r.length - 1; i++) {

			index = i;
			for (int j = (i + 1); j < r.length - 1; j++) {
				if (r[j] < r[index]) {
					index = j;
				}
			}

			if (index != i) {
				int temp = r[index];
				r[index] = r[i];
				r[i] = temp;
			}
		}

	}

}

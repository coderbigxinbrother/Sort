package com.sort;

public class BestBubbleSort {

	public static void main(String[] args) {
		Integer[] a = new Integer[] { 12, 9, 11, 5, 8, 43 };

		bubble(a);

		printResult(a);
	}

	public static void printResult(Integer[] a) {
		for (int i = 0; i < a.length; i++) {

			if (i == a.length - 1) {
				System.out.print(a[i]);
			} else {
				System.out.print(a[i] + ",");
			}

		}
	}
	
	private static void bubble(Integer[] a) {

		int exchange = a.length-1;
		int bound = 0;
		while(exchange != 0){
			bound = exchange;
			exchange = 0;
			for (int i = 0; i < bound; i++) {
				if (a[i]>a[i+1]) {
					int temp = a[i+1];
					a[i+1] = a[i];
					a[i] = temp;
				}
				exchange = i;
			}
			
		}
	}

}

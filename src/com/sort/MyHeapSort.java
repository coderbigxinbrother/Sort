package com.sort;

public class MyHeapSort {

	public void toString(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void main(String args[]) {
		MyHeapSort hs = new MyHeapSort();
		int[] array = { 87, 45, 78, 32, 17, 65, 53, 9, 122 };
		System.out.print("构建大根堆：");
		hs.toString(hs.buildMaxHeap(array));
		System.out.print("\n" + "删除堆顶元素：");
		hs.toString(hs.deleteMax(array));
		System.out.print("\n" + "插入元素63:");
		hs.toString(hs.insertData(array, 63));
		System.out.print("\n" + "大根堆排序：");
		hs.toString(hs.heapSort(array));
	}

	private int[] heapSort(int[] array) {

		for (int i = array.length - 1; i > 1; i--) {
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			adjustDownToUp(array, 0, i);
		}
		return array;
	}
	
	public  static int[] insertData1(int[] array, int data){
		
		array[array.length-1] = data;
		
		int k = array.length-1;
		
		int parent = (k-1)/2;
		
		while (parent >= 0 && data> array[parent]) {
			array[k]=array[parent];
			k = parent;
			if (parent != 0) {
				parent = (parent - 1) /2;
			}else{
				break;
			}
		}
		
		array[k] = data;
		
		return array;
		
	}

	private int[] insertData(int[] array, int data) {
		array[array.length - 1] = data; // 将新节点放在堆的末端
		int k = array.length - 1; // 需要调整的节点
		int parent = (k - 1) / 2; // 双亲节点
		while (parent >= 0 && data > array[parent]) {
			array[k] = array[parent]; // 双亲节点下调
			k = parent;
			if (parent != 0) {
				parent = (parent - 1) / 2; // 继续向上比较
			} else { // 根节点已调整完毕，跳出循环
				break;
			}
		}
		array[k] = data; // 将插入的结点放到正确的位置
		return array;
	}

	// 删除堆顶元素操作
	private int[] deleteMax(int[] array) {
		// TODO Auto-generated method stub
		// 将堆的最后一个元素与堆顶元素交换，堆底元素值设为-99999
		array[0] = array[array.length - 1];
		array[array.length - 1] = -99999;
		// 对此时的根节点进行向下调整
		adjustDownToUp(array, 0, array.length);
		return array;

	}

	private int[] buildMaxHeap(int[] array) {

		int n = array.length - 2;
		for (int i = n / 2; i >= 0; i--) {
			adjustDownToUp(array, i, n + 2);
		}
		return array;
	}

	// 将元素array[k]自下往上逐步调整树形结构
	private void adjustDownToUp(int[] array, int k, int length) {

		int temp = array[k];

		for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1) {
			if (i + 1 < length && array[i] < array[i + 1]) {
				i++;
			}
			if (array[i] < temp) {
				break;
			} else {
				array[k] = array[i];
				k = i; // 父节点往下探 ,子节点已经 2*i+1的方式往下探，父子节点有这层关系
			}
		}
		array[k] = temp;
	}

	// 调整堆的结构 数组为r 编号为k的元素要调整 元素的总数为m
	public static void shift(int[] r, int k, int m) {

		int i = k;
		int j = 2 * i + 1;
		int temp = r[k];
		while (j <= m - 1) {
			if (r[j] < r[j + 1])
				j++;
			if (temp > r[j])
				break;
			else {
				r[i] = r[j];
				i = j;
				j = 2 * i;
			}
		}

		r[i] = temp;
	}
}

package com.sort;

public class DirectInsertSort {

	public static void main(String[] args) {
		
		
		Integer[] a = new Integer[]{12,9,11,5,8,43};
		insertSort3(a);
		
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
	
	 /**
	    * 不带哨所
	    * 
	    * @param sortList
	    */
	public static void insertSort2(Integer[] sortList) {
        int len = sortList.length;
        //n-1趟 下表元素从sortList[1]开始插入
        for (int i = 1; i < len; i++) {
        	
            if (sortList[i] < sortList[i - 1]) {
                int j = i - 1;
                //临时存要插入的数据sortList[i]
                int temp = sortList[i];
                while (j >= 0 && temp < sortList[j]) {
                    sortList[j + 1] = sortList[j];
                    j--;
                }
                sortList[j + 1] = temp;
            }
        }
    }
	
	
	/**
	    * 带哨所
	    * 
	    * @param sortList
	    */
	    public static void insertSort1(Integer[] sortList) {
	        int len = sortList.length;
	        for (int i = 2; i < len; i++) {
	            if (sortList[i] < sortList[i - 1]) {
	                int j = i - 1;
	                sortList[0] = sortList[i];// 设置哨所
	                while (sortList[0] < sortList[j]) {
	                    sortList[j + 1] = sortList[j];
	                    j--;
	                }
	                sortList[j + 1] = sortList[0];
	            }
	        }
	    }
	    
	    /**
	     * 二分查找插入排序
	     * @param sortList
	     */
	     public static void insertSort3(Integer[] sortList) {
	         int len = sortList.length;
	         for (int i = 1; i < len; i++) {
	             if (sortList[i] < sortList[i - 1]) {
	                 //二分查找在有序区寻找插入的位置 
	                 int index = binarySearchIndex(sortList, i-1, sortList[i]);
	                 if (i != index)
	                 {
	                     int temp = sortList[i];
	                     // 后移元素，腾出arr[index]位置
	                     for (int j = i - 1; j >= index; j--)
	                         sortList[j + 1] = sortList[j];
	                     // 将 arr[i] 放到正确位置上 
	                     sortList[index] = temp;
	                 }
	             }
	         }
	     }
	     
	     /**
	      * 二分查找要插入的位置得index
	      * @param sortList
	      * @param maxIndex
	      * @param data
	      * @return
	      * 
	      * 
	      * 5,8,9,11,12,43  10
	      */
	      private static int binarySearchIndex(Integer[] sortList, int maxIndex, int data)
	      {
	          int iBegin = 0;
	          int iEnd = maxIndex;
	          int middle = -1;
	          while (iBegin <= iEnd)
	          {
	              middle = (iBegin + iEnd) / 2;
	              if (sortList[middle] > data)
	              {
	                  iEnd = middle - 1;
	              }
	              else
	              {
	                  iBegin = middle + 1;// 如果是相同元素，也是插入在后面的位置
	              }
	          }
	          return iBegin;
	      }
}

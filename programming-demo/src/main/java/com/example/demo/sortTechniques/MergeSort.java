package com.example.demo.sortTechniques;

public class MergeSort {
	
	
	private static int[] merge( int[] LeftArray, int[] RightArray) {
		int n1 = LeftArray.length;
        int n2 = RightArray.length;
        int i =0, j=0;
        int actualArray[] = new int[n1+n2];
        int k = 0;
        while (i<n1 && j<n2) {
        	if (LeftArray[i] <= RightArray[j]) {
        		actualArray[k] = LeftArray[i];
        		i++;
        	} else {
        		actualArray[k] = RightArray[j];
        		j++;
        	}
        	k++;
        }
        
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
        	actualArray[k] = LeftArray[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
        	actualArray[k] = RightArray[j];
            j++;
            k++;
        }
		return actualArray;
		
	}
	
	
	private static int[] mergeSort(int[] arr) {
		int length = arr.length ;
		if (length == 1) {
			return arr;
		}
			int first = length/2;
			int second = length - first;
		 int a1[] = new int[first];
		 int a2[] = new int[second];
		 int j =0 ;
		 for (int i = 0; i < arr.length; i++) {
			if (i < first) {
				a1[i] = arr[i];
			} else {
				
				a2[j] = arr[i];
				j++;
			}
		 }
		 
		 a1 = mergeSort(a1);
		 a2 = mergeSort(a2);
		 
//		 for (int i = 0; i < a1.length; i++) {
//			 System.out.print(a1[i] + ", ");
//		 }
//		 System.out.println(">>>>");
//		 for (int i = 0; i < a2.length; i++) {
//			 System.out.print(a2[i] + ",");
//		 }
		 
		
		return merge( a1, a2);
	}
	
	public static void main(String[] args) {
		 int[] arr= new int[]{70, 43,21, 422,0, 9,3,1,6,13, 32};
		 
		 //int[] arr= new int[]{70, 43};

		int finallARR[] = mergeSort(arr);
		
		for (int i = 0; i < finallARR.length; i++) {
			 System.out.println(finallARR[i] + ",");
		 }
		
	}

}

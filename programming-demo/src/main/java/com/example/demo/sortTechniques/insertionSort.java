package com.example.demo.sortTechniques;

public class insertionSort {

	private static int[] arr= new int[]{9,3,1,6,13};
	
	public static void main(String[] args) {
		
		for (int i=1; i<arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while ( j >= 0 && key > arr[j] ) {
				arr[j+1] = arr[j];
				--j;
			}
			arr[j+1] = key;
		}
		
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
		
}

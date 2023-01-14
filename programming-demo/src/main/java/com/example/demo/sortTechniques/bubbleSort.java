package com.example.demo.sortTechniques;

public class bubbleSort {

	private static int[] arr= new int[]{9,3,1,6,13};
	public static void main(String[] args) {
		
		for (int i=0; i<arr.length-1; i++) {
			
			for (int j=0; j<arr.length-i-1; j++) {

				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}

				
			}
		}
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
}

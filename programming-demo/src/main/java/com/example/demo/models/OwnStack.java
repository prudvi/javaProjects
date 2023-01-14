package com.example.demo.models;

public class OwnStack {

	private static int top = -1;
	private static int size = 10;
	private static int arr[] = new int[size];

	
	private static void push(int value) {
		if (top == size-1) {
			System.out.println("OVerFlow");
		} else {
			top++;
			arr[top] = value;
		}
	}

	private static <T> int pop() {
		if (top == -1) {
			System.out.println("No Elements in Stack");
			return 0;
		} else {
			return arr[top--];
		}
	}
	
	private static void print() {
		System.out.println(top + "::::::TOP:::::::");
		while (top != -1) {
			System.out.println(arr[top]);
			top--;
		}
	}
	public static void main(String[] args) {
		OwnStack own = new OwnStack();
		own.push(99);
		own.push(199);
		own.push(10);
		own.push(64);
		System.out.println(own);
		//
		own.pop();
		print();
		
	}
}

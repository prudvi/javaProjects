package com.example.demo.models;

import java.util.Arrays;
import java.util.Stack;

public class OwnQueue {
	private static int front = -1;
	private static int rear = -1;
	private static int size = 10;
	private static int arr[] = new int[size];
	
	private static void insert(int value) {
		if (rear == size-1) {
			System.out.println(" OwnQueue OVerFlow");
		} else {
			rear++;
			arr[rear] = value;
		}
	}

	private static <T> int delete() {
		 if (front == - 1 || front > rear)  {
			System.out.println("No Elements in Stack");
			return 0;
		} else {
			front++;
			System.out.println("delete Elements in Stack"+arr[front+1]);
			/*
			 * for (int x=0;x<rear-1; x++) { arr[x] = arr[x+1]; }
			 * 
			 * if (rear < size) { arr[rear] = 0; }
			 */
			/* rear--; */
		}
		return 0;
	}
	
	private static void print() {
		System.out.println(front + "::::::front:::::::");
		Arrays.stream(arr)
        .forEach(e->System.out.print(e + " "));
		/*
		 * while (front != -1) { System.out.println(arr[front]); front--; }
		 */
	}
	
	public static void main(String[] args) {
		
		OwnQueue oq = new OwnQueue();
		oq.insert(100);
		oq.insert(54);
		oq.insert(12);
		oq.insert(1);
		
		System.out.println(oq);
		
		System.out.println(front + "::::::" + rear);
		//oq.delete();
		System.out.println(front + "::::::" + rear);
		
	}
}

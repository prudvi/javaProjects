package com.demo.inbuiltClasses;

import java.util.Iterator;
import java.util.Stack;

public class StackImplementation {
	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(100);
		st.push(54);
		st.push(12);
		st.push(1);
		
		Iterator it = st.iterator();
		while (it.hasNext()) {
			int type =  (int) it.next();
			System.out.println(type);
			
		}
		
		System.out.println(st);
		
		System.out.println("TOP: " + st.peek());
		
		System.out.println(st.pop());
		
		System.out.println("TOP: " + st.peek());
	}
}

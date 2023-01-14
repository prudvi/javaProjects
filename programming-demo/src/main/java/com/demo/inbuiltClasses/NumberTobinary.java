package com.demo.inbuiltClasses;

public class NumberTobinary {

	public static void main(String[] args) {
		int n = 8;
		String s1 = "";
		while (n>0) {
			//System.out.print(n%2);
			s1 = s1 + n%2;
			n = n/2;
		}
		
		
		System.out.println(s1);
		for (int i = s1.length()-1; i >= 0; i--) {
			System.out.print(s1.charAt(i));
		}
	}
}

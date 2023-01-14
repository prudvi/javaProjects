package com.example.demo.models;

public class LinkListImplementation {
	
	static Node head = null;
	static class Node {
		Node next;
		int data;
		Node( int data) {
		 this.data = data;
		}
	}
	
	private static void pushAtBegin(int element) {
		if (head == null) {
			Node n1 = new Node(element);
			n1.next = null;
			head = n1;
		} else {
			Node na1 = new Node(element);
			Node temp = head;
			head = na1;
			head.next =temp;
		}
	}
	
	private static void pushAfterElement(int afterVal, int newValue) {
		if (head == null) {
			Node n1 = new Node(newValue);
			n1.next = null;
			head = n1;
		} else {
			Node last = head;
			Node prev = head;
			Node n1 = new Node(newValue);
			while (last != null && last.data != afterVal) {
				prev = last;
				last = last.next;
			}
			 //System.out.println(" FISHY:::" + prev.data);
			
			// Probability that afterVal is not exist then add at the end
			 if (last != null ) {
				 System.out.println(" FISHY:::" + last.data);
				 Node nextVal ;
				 if (last.data == afterVal) {
					 nextVal = last.next;
					 last.next = n1;
					 n1.next = nextVal;
					 System.out.println("::::" + last.data);
					 while (last != null) {
						 last = last.next;
					}
				 } else {
					 System.out.println("Not Found add at end" );
					
				 }
			 } else {
				 
				 prev.next = n1;
			 }
			
		}
	}
	
	private static void pushAtEnd(int element) {
		if (head == null) {
			Node n1 = new Node(element);
			n1.next = null;
			head = n1;
		} else {
			Node na1 = new Node(element);
			Node last = head;
			Node prev = head;
			while (last != null) {
				prev = last;
				last = last.next;
				
			}
		
			last = na1;
			prev.next = last;
			
		}
	}
	
	
	private static void display() {
		Node n1 = head;
		while (n1 != null) {
			System.out.print( +n1.data + ",");
			n1 = n1.next;
		}
	} 
	public static void main(String[] args) {
		

		System.out.println("PUSH BEGIN STATES");
		pushAtBegin(190);
		pushAtBegin(435);
		pushAtBegin(05);
		pushAtBegin(546);
		pushAtBegin(92);
		
		System.out.println("PUSH BEGIN END");
		pushAfterElement(546, 980);
		System.out.println("PUSHed 980 after 546");
		
		System.out.println("PUSH at END started");
		pushAtEnd(645);
		pushAtEnd(43);
		pushAtEnd(21);
		pushAtEnd(32);
		display();
		System.out.println();
		System.out.println("Before PopBEGIN PERFORMATOM");
		popAtBegin();
		popAtBegin();
		display();
		System.out.println();
		System.out.println("Before PopEnd PERFORMATOM");
		popAtEnd();
		popAtEnd();
		display();
	}
	
	private static void popAtBegin() {
		if (head != null) {
			Node temp  = head.next;
			head = temp;
		}
	}
	
	private static void popAtEnd() {
		if (head != null) {
			Node temp  = head;
			Node last  = head;
			while(temp != null) {
				last = temp;
				if (temp.next.next == null) {
					last.next = null;
				}
				temp = temp.next;
			}
			
			System.out.println(":>>>>>:::"+ last.data);
		}
	}

}

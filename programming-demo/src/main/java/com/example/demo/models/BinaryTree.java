package com.example.demo.models;

public class BinaryTree {

	TreeNodeW root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(int data) {
		root = new TreeNodeW(data);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		TreeNodeW t1 = new TreeNodeW(10);
		bt.root = t1;
		
		TreeNodeW t2 = new TreeNodeW(20);
		TreeNodeW t3 = new TreeNodeW(30);
		
		TreeNodeW t4 = new TreeNodeW(40);
		
		TreeNodeW t5 = new TreeNodeW(50);
		t1.left = t2;
		t1.right = t3;
		
		t2.left = t4;
		t3.right = t5;
		
	}
}

package com.example.demo.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
/*
 * CONCEPT UNDERSTANDING
 * 2 concepts: 

1. Visiting a vertex
2. Exploration of a Vertex


BFS: 
Step 1: Select any Verticx, 
and Visit all Adjacent to that Vertex and Selct the First Visited one and visited the all Adjacent vertex,
Binary Search=Level Order

DFS:
Select any Verticx[A] and have [B, C, D] arr adjacent Vertices, 
and Visit any one adjacent Vertex[B] and from there visit adjacent of B of any One Vetex untilt that vertex is empty then back Track
Binary Search=Inorder


https://www.youtube.com/watch?v=pcKY4hjDrxk
 */
public class DFSImplementation {

	private LinkedList[] adjacenyResultList = null;

	private static int vertices = 8;
	private static boolean visited[] = new boolean[0];
	public DFSImplementation() {
		super();
		adjacenyResultList = new LinkedList[vertices];
		visited = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacenyResultList[i] = new LinkedList<Integer>();
		}
	}

	private void insertEdge(int start, int end) {
		adjacenyResultList[start].add(end);
	}
	
	private void traversal(int startingVertex) {
		 visited[startingVertex] = true;
		 System.out.print(startingVertex + " ");
		 Iterator adjacentVertexList = adjacenyResultList[startingVertex].iterator();
		 while (adjacentVertexList.hasNext()) {
			 int n =  (int) adjacentVertexList.next();
			 if (!visited[n])  
				 traversal(n); 
			
		}
	}
	public static void main(String args[]) {  
			DFSImplementation graph = new DFSImplementation();  
	  
	        graph.insertEdge(0, 1);    
	        graph.insertEdge(0, 2);    
	        graph.insertEdge(0, 3);    
	        graph.insertEdge(1, 3);    
	        graph.insertEdge(2, 4);  
	        graph.insertEdge(3, 5);       
	        graph.insertEdge(3, 6);    
	        graph.insertEdge(4, 7);    
	        graph.insertEdge(4, 5);    
	        graph.insertEdge(5, 2);    
	          
			
			  System.out.println("Depth First Traversal for the graph is:");
			  graph.traversal(4);
			  
			  System.out.println();
			  System.out.println("Depth First Traversal for the graph is:"); 
			  visited = new boolean[vertices];
			  graph.traversal(1);
			  System.out.println();
			  System.out.println("Depth First Traversal for the graph is:");
			  visited = new boolean[vertices];
			  graph.traversal(0);				     
	  }
}

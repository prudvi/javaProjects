package com.example.demo.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSImplementation {

	int vertexCount;
	LinkedList<Integer> adsjList[];
	Queue<Integer> que;
	boolean nodes[] = new boolean[vertexCount];
	public BFSImplementation(int vertex) {
		vertexCount = vertex;
		nodes = new boolean[vertexCount];
		adsjList = new LinkedList[vertexCount];
		for (int x=0; x<vertexCount; x++)
			adsjList[x] = new LinkedList<Integer>();
		
		que = new LinkedList<Integer>();
	}
	
	void insertEdge(int v,int w) {
		adsjList[v].add(w);
	}
	
	void BFSTravel(int startvertex) {
		nodes[startvertex] = true;
		que.add(startvertex);
		while (que.size() !=0 ) {
			int queueVal = que.peek();
			System.out.print("queuValue:::"+queueVal);
			for (int y=0; y<adsjList[startvertex].size(); y++) {
				int adjacentLink = adsjList[startvertex].get(y);
				if (!nodes[adjacentLink]) {
					nodes[adjacentLink] = true;
					que.add(adjacentLink);
				}
			}
		}
	}
	
}

package com.progra.graphs;

import java.util.LinkedList;
import java.util.List;

public class Graph {

	private int V;
	private LinkedList<Integer> adj[];

	public Graph(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v - 1].add(w - 1);
		// adj[w].add(v); bidireccional
	}

	public int getQuantityNodes() {
		return V;
	}

	public List<Integer> getAdjacent(int v) {
		return adj[v];
	}

}

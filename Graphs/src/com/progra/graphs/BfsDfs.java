package com.progra.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class BfsDfs {

	private Graph graph;

	public BfsDfs() {
		graph = new Graph(4);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
	}

	public void BFS(int s) {
		boolean visited[] = new boolean[graph.getQuantityNodes()];
		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);
		while (!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s + " ");
			Iterator<Integer> i = graph.getAdjacent(s).listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

	}

	public void DFS(int v) {
		boolean visited[] = new boolean[graph.getQuantityNodes()];
		DfsUtil(v, visited);
	}

	public void DfsUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.println(v + " ");
		Iterator<Integer> i = graph.getAdjacent(v).listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				DfsUtil(n, visited);
			}
		}
	}
}

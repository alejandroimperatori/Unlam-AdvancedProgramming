package com.progra.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

	private List<List<Node<Integer>>> adjList = new ArrayList<List<Node<Integer>>>();
	private int distance[];
	private boolean visited[];
	private int previous[];
	private PriorityQueue<Node<Integer>> queue = new PriorityQueue<Node<Integer>>();
	private int V;
	private List<Integer> shortestPath = new ArrayList<Integer>();

	public Dijkstra(int V) {
		this.V = V;
		distance = new int[V];
		visited = new boolean[V];
		previous = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		Arrays.fill(previous, -1);
		for (int i = 0; i <= V; ++i) {
			adjList.add(new ArrayList<Node<Integer>>());
		}
	}

	void dijkstra(int initial, List<Integer> dragons) {
		queue.add(new Node<Integer>(initial, 0));
		distance[initial] = 0;
		int current, adj, weight;
		while (!queue.isEmpty()) {
			current = queue.remove().id;
			if (visited[current - 1] || dragons.contains(current)) {
				continue;
			}
			visited[current - 1] = true;
			for (int i = 0; i < adjList.get(current).size(); ++i) {
				adj = adjList.get(current).get(i).id;
				weight = adjList.get(current).get(i).weigth;
				if (!visited[adj - 1] && !dragons.contains(adj)) {
					relajacion(current, adj, weight);
				}
			}

		}

	}

	public void relajacion(int current, int adj, int weight) {
		if (distance[current - 1] + weight < distance[adj - 1]) {
			distance[adj - 1] = distance[current - 1] + weight;
			previous[adj - 1] = current;
			queue.add(new Node<Integer>(adj, distance[adj - 1]));
		}
	}

	public void addEdge(int origin, int destination, int weight) {
		adjList.get(origin).add(new Node<Integer>(destination, weight));
	}

	public void calculateShortestPath(int destination) {
		if (previous[destination - 1] != -1) {
			calculateShortestPath(previous[destination - 1]);
		}
		this.shortestPath.add(destination);
	}

	public List<Integer> getShortestPath() {
		return shortestPath;
	}

	public int getVertices() {
		return this.V;
	}

	public void setVertices(int v) {
		this.V = v;
	}

}

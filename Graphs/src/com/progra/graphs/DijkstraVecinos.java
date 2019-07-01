package com.progra.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraVecinos {

	private List<List<Node<Integer>>> adjList;

	private boolean[] visited;
	private int[] distance;

	private int nodes;

	private PriorityQueue<Node<Integer>> queue;

	Map<Integer, String> citiesId;

	public DijkstraVecinos(int nodes) {
		this.nodes = nodes;
		adjList = new ArrayList<List<Node<Integer>>>();
		queue = new PriorityQueue<>();
		citiesId = new HashMap<>();
		visited = new boolean[nodes];
		distance = new int[nodes];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for (int i = 0; i <= nodes; ++i) {
			adjList.add(new ArrayList<Node<Integer>>());
		}
	}

	public int[] resolverDijkstra(int initial) {
		queue.add(new Node<Integer>(initial, 0));
		distance[initial - 1] = 0;
		int current, adj, weight;
		while (!queue.isEmpty()) {
			current = queue.remove().id;
			if (visited[current - 1]) {
				continue;
			}
			visited[current - 1] = true;
			for (int i = 0; i < adjList.get(current).size(); ++i) {
				adj = adjList.get(current).get(i).id;
				weight = adjList.get(current).get(i).weigth;
				if (!visited[adj - 1]) {
					relajacion(current, adj, weight);
				}
			}

		}
		return distance;
	}

	public void relajacion(int current, int adj, int weight) {
		if (distance[current - 1] + weight < distance[adj - 1]) {
			distance[adj - 1] = distance[current - 1] + weight;
			queue.add(new Node<Integer>(adj, distance[adj - 1]));
		}
	}

	public void addEdge(int v1, int v2, int weight) {
		adjList.get(v1).add(new Node<Integer>(v2, weight));
		adjList.get(v2).add(new Node<Integer>(v1, weight));
	}

	public void clearDistanceArray() {
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
	}

}

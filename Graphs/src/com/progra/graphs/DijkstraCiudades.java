package com.progra.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.PriorityQueue;

public class DijkstraCiudades {

	private List<List<Node<Integer>>> adjList;

	private boolean[] visited;
	private int[] previous;
	private int[] distance;

	private int nodes;

	private PriorityQueue<Node<Integer>> queue;
	private List<String> shortestPath;

	Map<Integer, String> citiesId;

	public DijkstraCiudades(int nodes) {
		this.nodes = nodes;
		adjList = new ArrayList<List<Node<Integer>>>();
		queue = new PriorityQueue<>();
		shortestPath = new ArrayList<>();
		citiesId = new HashMap<>();
		visited = new boolean[nodes];
		previous = new int[nodes];
		distance = new int[nodes];
		Arrays.fill(previous, -1);
		Arrays.fill(distance, Integer.MAX_VALUE);
		for (int i = 0; i <= nodes; ++i) {
			adjList.add(new ArrayList<Node<Integer>>());
		}
	}

	public void resolverDijkstra(String origin) {
		int originId = getCityId(origin);
		queue.add(new Node<Integer>(originId, 0));
		distance[originId] = 0;
		int current, adj, weight;
		while (!queue.isEmpty()) {
			current = queue.poll().id;
			if (visited[current]) {
				continue;
			}
			visited[current] = true;
			for (Node<Integer> node : adjList.get(current)) {
				adj = node.id;
				weight = node.weigth;
				if (!visited[adj]) {
					if (distance[current] + weight < distance[adj]) {
						distance[adj] = distance[current] + weight;
						previous[adj] = current;
						queue.add(new Node<Integer>(adj, distance[adj]));
					}
				}
			}
		}
	}

	public void addEdge(String origin, String destination, int weight) {
		int originId = getCityId(origin);
		int destinationId = getCityId(destination);
		adjList.get(originId).add(new Node<Integer>(destinationId, weight));
		adjList.get(destinationId).add(new Node<Integer>(originId, weight));
	}

	public void calculateShortestPath(String destination) {
		int id = getCityId(destination);
		if (previous[id] != -1) {
			calculateShortestPath(getCityName(previous[id]));
		}
		this.shortestPath.add(destination);
	}

	public List<String> getShortestPath() {
		return shortestPath;
	}

	public int getShortestDistance(String destination) {
		return distance[getCityId(destination)];
	}

	private int getCityId(String name) {
		Optional<Entry<Integer, String>> city = citiesId.entrySet().stream().filter(c -> c.getValue().equals(name))
				.findFirst();
		if (city.isPresent()) {
			return city.get().getKey();
		}
		int newId = citiesId.keySet().size();
		citiesId.putIfAbsent(newId, name);
		return newId;
	}

	private String getCityName(int id) {
		Optional<Entry<Integer, String>> city = citiesId.entrySet().stream().filter(c -> c.getKey().equals(id))
				.findFirst();
		if (city.isPresent()) {
			return city.get().getValue();
		}
		return "";
	}

}

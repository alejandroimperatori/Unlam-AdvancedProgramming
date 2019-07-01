package com.progra.graphs;

public class Node<T> implements Comparable<Node<T>> {
	T id;
	int weigth;

	public Node(T id, int weight) {
		this.id = id;
		this.weigth = weight;
	}

	@Override
	public int compareTo(Node<T> other) {
		if (weigth > other.weigth) {
			return 1;
		}
		if (weigth == other.weigth) {
			return 0;
		}
		return -1;
	}
}
package com.progra.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Reserva {

	private Graph graph;
	private String path;
	private int cantPath;

	public Reserva(String path) {
		this.path = path;
		this.cantPath = 0;
		leerArchivo();
	}

	public void leerArchivo() {
		try {
			Scanner sc = new Scanner(new FileReader(new File(this.path + ".in")));
			sc.useLocale(Locale.ENGLISH);
			int vertices = sc.nextInt();
			int aristas = sc.nextInt();
			graph = new Graph(vertices);
			for (int i = 0; i < aristas; i++) {
				int origin = sc.nextInt();
				int destination = sc.nextInt();
				graph.addEdge(origin, destination);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void escribirArchivo(int cant) {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(this.path + ".out"));
			salida.print(cant);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void DFS(int v) {
		boolean visited[] = new boolean[graph.getQuantityNodes()];
		DfsUtil(v, graph.getQuantityNodes() - 1, visited);
		this.escribirArchivo(cantPath);
	}

	public void DfsUtil(int v, int f, boolean[] visited) {
		visited[v] = true;
		if (v == f) {
			this.cantPath++;
		} else {
			for (Integer i : graph.getAdjacent(v)) {
				if (!visited[i]) {
					DfsUtil(i, f, visited);
				}
			}
		}
		visited[v] = false;
	}

}

package com.progra.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Princess {
	private String path;
	private Dijkstra graph;
	private int initialPrince;
	private int finalPrincess;
	private List<Integer> dragonsPosition = new ArrayList<Integer>();

	public Princess(String path) {
		this.path = path;
		this.leerArchivo();
	}

	public void leerArchivo() {
		try {
			Scanner sc = new Scanner(new FileReader(new File(this.path + ".in")));
			sc.useLocale(Locale.ENGLISH);
			int vertices = sc.nextInt();
			int aristas = sc.nextInt();
			int dragonsQuantity = sc.nextInt();
			finalPrincess = sc.nextInt();
			initialPrince = sc.nextInt();
			this.graph = new Dijkstra(vertices);
			for (int i = 0; i < dragonsQuantity; i++) {
				dragonsPosition.add(sc.nextInt());
			}
			for (int i = 0; i < aristas; i++) {
				int origin = sc.nextInt();
				int destination = sc.nextInt();
				int weight = sc.nextInt();
				graph.addEdge(origin, destination, weight);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void escribirArchivo() {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(this.path + ".out"));
			for (Integer node : this.graph.getShortestPath()) {
				salida.print(node);
				salida.print(" ");
			}
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void resolverCamino() {
		this.graph.dijkstra(initialPrince, dragonsPosition);
		this.graph.calculateShortestPath(finalPrincess);
	}

}
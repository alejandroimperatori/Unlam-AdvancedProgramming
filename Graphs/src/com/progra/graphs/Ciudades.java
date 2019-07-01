package com.progra.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Ciudades {

	private String path;
	private DijkstraCiudades graph;

	public Ciudades(String path) {
		this.path = path;
		this.leerArchivo();
	}

	public void leerArchivo() {
		try {
			Scanner sc = new Scanner(new FileReader(new File(this.path + ".in")));
			sc.useLocale(Locale.ENGLISH);
			int vertices = sc.nextInt();
			graph = new DijkstraCiudades(vertices);
			while (sc.hasNext()) {
				String origin = sc.next();
				String destination = sc.next();
				int weight = sc.nextInt();
				graph.addEdge(origin, destination, weight);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void escribirArchivo(String destination) {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(this.path + ".out"));
			for (String city : this.graph.getShortestPath()) {
				salida.print(city);
				salida.print(" - ");
			}
			salida.print(this.graph.getShortestDistance(destination));
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void resolverCamino(String origin, String destination) {
		this.graph.resolverDijkstra(origin);
		this.graph.calculateShortestPath(destination);
		this.escribirArchivo(destination);
	}

}

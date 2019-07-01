package com.progra.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Vecinos {

	private String path;
	private DijkstraVecinos graph;

	public Vecinos(String path) {
		this.path = path;
		this.leerArchivo();
	}

	public void leerArchivo() {
		try {
			Scanner sc = new Scanner(new FileReader(new File(this.path + ".in")));
			sc.useLocale(Locale.ENGLISH);
			int vertices = sc.nextInt();
			int aristas = sc.nextInt();
			int vecino1 = sc.nextInt();
			int vecino2 = sc.nextInt();
			graph = new DijkstraVecinos(vertices);
			for (int i = 0; i < aristas; i++) {
				int origin = sc.nextInt();
				int destination = sc.nextInt();
				int weight = sc.nextInt();
				graph.addEdge(origin, destination, weight);
			}
			sc.close();

			this.resolverCamino(vecino1, vecino2);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void escribirArchivo(int cantV1, int cantV2) {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(this.path + ".out"));
			salida.print(cantV1 + " " + cantV2);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void resolverCamino(int vecino1, int vecino2) {
		int[] v1;
		int[] v2;
		int cantV1 = 0;
		int cantV2 = 0;
		int[] distance = this.graph.resolverDijkstra(vecino1);
		v1 = distance.clone();
		this.graph.clearDistanceArray();
		distance = this.graph.resolverDijkstra(vecino2);
		v2 = distance.clone();
		for (int i = 0; i < v1.length; i++) {
			if (i != vecino1 - 1 && i != vecino2 - 1) {
				if (v1[i] > v2[i]) {
					cantV1++;
				} else if (v1[i] < v2[i]) {
					cantV2++;
				}
			}
		}

		this.escribirArchivo(cantV1, cantV2);
	}

}

package com.progra.luchadores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EscribirConPrintWriter {

	public void write(List<Integer> dominadores) throws IOException {
		
		PrintWriter salida = new PrintWriter(new FileWriter("sumo.out"));  
	     
		dominadores.stream().forEach(n -> salida.println(n));

		salida.close(); 

	}

}

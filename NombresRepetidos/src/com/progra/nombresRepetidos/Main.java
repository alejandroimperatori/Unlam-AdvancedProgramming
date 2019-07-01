package com.progra.nombresRepetidos;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		String basePath = "D:\\Documentos\\Programacion avanzada\\NombresRepetidos\\";
		
		RepeatedNames repeatedNames = new RepeatedNames();
		
		try {
			long startTime = System.currentTimeMillis();
			repeatedNames.processFile(basePath + "400milNombres.in", basePath + "400milNombres.out");
			long endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

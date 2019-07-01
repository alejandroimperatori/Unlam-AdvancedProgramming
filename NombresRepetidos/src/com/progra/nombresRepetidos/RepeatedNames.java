package com.progra.nombresRepetidos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class RepeatedNames {
	
	public void processFile(String inputPath, String outputPath) throws IOException {
		Names repeatedNames = readFile(inputPath);
		TreeMap<String, Integer> moreRepeatedNames = new TreeMap<>();
		Entry<String, Integer> moreRepeated = null;
		for(int i = 0; i < repeatedNames.getQuantity(); i++) {
			moreRepeated = repeatedNames.getRepeatedNames().entrySet().stream().findFirst().orElse(null);
			for(Entry<String, Integer> entry : repeatedNames.getRepeatedNames().entrySet()) {
				if(entry.getValue() > moreRepeated.getValue()) {
					moreRepeated = entry;
				}
			}
			repeatedNames.getRepeatedNames().remove(moreRepeated.getKey());
			moreRepeatedNames.put(moreRepeated.getKey(), moreRepeated.getValue());
		}
		
		writeFile(outputPath, moreRepeatedNames);
	}
	
	public Names readFile(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		int size = sc.nextInt();
		int quantity = sc.nextInt();
		HashMap<String, Integer> repeatedNames = new HashMap<>();
		for (int i = 0; i < size ; i++) {
			String key = sc.next();
			repeatedNames.computeIfPresent(key, (k,v) -> v + 1);
			repeatedNames.putIfAbsent(key, 1);
		}
		sc.close();
		return new Names(repeatedNames, quantity);
	}
	
	public void writeFile(String path, TreeMap<String, Integer> repeatedNames) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(path)); 
		for(Entry<String, Integer> entry : repeatedNames.entrySet()) {
			salida.println(entry.getKey() + " " + entry.getValue());
		}
		salida.close();
	}
	
}

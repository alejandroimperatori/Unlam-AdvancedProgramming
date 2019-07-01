package com.progra.luchadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LeerConScanner{

	public Torneo read() throws FileNotFoundException{

		List<Luchador> luchadorList = new ArrayList<>();
		
		Scanner sc = new Scanner(new File("sumo.in"));
		sc.useLocale(Locale.ENGLISH);
		
		for (int i = 0; i < sc.nextInt() ; i++) {
			Double peso = sc.nextDouble();
			Double altura = sc.nextDouble();
			luchadorList.add(new Luchador(peso, altura));
		}
		
		sc.close();
		
		return new Torneo(luchadorList);
	}
	
}

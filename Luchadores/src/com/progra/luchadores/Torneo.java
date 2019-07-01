package com.progra.luchadores;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
	
	private List<Luchador> luchadores;
	
	public Torneo(List<Luchador> luchadores) {
		this.luchadores = luchadores;
	}
	
	public List<Luchador> getLuchadores() {
		return luchadores;
	}

	public void setLuchadores(List<Luchador> luchadores) {
		this.luchadores = luchadores;
	}

	public void resolver() throws FileNotFoundException {
		
		Torneo torneo = new LeerConScanner().read();
		
		List<Integer> dominadores = new ArrayList<>();
		int count;
		for(Luchador luchador: torneo.getLuchadores()) {
			count = 0;
			for(Luchador luchadorCompare: getLuchadores()) {
				if(luchador.domina(luchadorCompare))
					count ++;
					
			}
			dominadores.add(count);
		}
		
	}
	
}

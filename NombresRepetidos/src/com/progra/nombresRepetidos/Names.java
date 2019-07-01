package com.progra.nombresRepetidos;

import java.util.HashMap;

public class Names {
	
	private HashMap<String, Integer> repeatedNames;
	
	private Integer quantity;
	
	public Names(HashMap<String, Integer> repeatedNames, Integer quantity) {
		this.repeatedNames = repeatedNames;
		this.quantity = quantity;
	}

	public HashMap<String, Integer> getRepeatedNames() {
		return repeatedNames;
	}

	public void setRepeatedNames(HashMap<String, Integer> repeatedNames) {
		this.repeatedNames = repeatedNames;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}

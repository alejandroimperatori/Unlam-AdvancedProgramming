package com.progra;

import java.util.ArrayList;
import java.util.List;

public class Pluralizador {
	
	private static final List<Character> VOCALS = new ArrayList<Character>() {{
		add('a');
		add('e');
		add('i');
		add('o');
		add('u');
	}}; 
	
	public void pluralizador(int quantity, String[] words, int[] ruleQuantity) {
		
		for(int i = 0; i < words.length; i++) {
			if(endsWithVocal(words[i])) {
				words[i] = words[i].concat("s");
				ruleQuantity[0]++;
			} else if(words[i].endsWith("z")) {
				words[i] = words[i].replace("z", "ces");
				ruleQuantity[2]++;
			} else if(!words[i].endsWith("s") && !words[i].endsWith("x")) {
				words[i] = words[i].concat("es");
				ruleQuantity[3]++;
			} else {
				ruleQuantity[1]++;
			}
		}
		System.out.println(words);
	}
	
	private boolean endsWithVocal(String word) {
		return VOCALS.contains(word.charAt(word.length() - 1 ));
	}
}

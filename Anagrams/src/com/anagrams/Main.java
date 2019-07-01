package com.anagrams;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		System.out.println(new Anagrams().anagrams(new ArrayList<String>() {{
			add("cava");
			add("empresa");
			add("pote");
			add("torta");
			add("tope");
			add("trota");
			add("vaca");
		}}));

	}

}

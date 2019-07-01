package com.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Anagrams {

	public HashMap<String, Set<String>> anagrams(List<String> dictionary){
		
		HashMap<String, Set<String>> result = new HashMap<>();
		
		for(String word : dictionary) {
			char[] charArr = word.toCharArray();
			Arrays.sort(charArr);
			String wordSorted = new String(charArr); 
			result.putIfAbsent(wordSorted, new TreeSet<>());
			for(String word2 : dictionary) {
				char[] charArr2 = word2.toCharArray();
				Arrays.sort(charArr2);
				String word2Sorted = new String(charArr2);
				if(word.length() == word2.length()) {
					if(wordSorted.equals(word2Sorted)) {
						result.computeIfPresent(wordSorted, (k,v) -> {
							v.add(word2);
							return new TreeSet<>(v);
						});
					}
				}
				
			}
		}
		
		return result;
	}
	
}

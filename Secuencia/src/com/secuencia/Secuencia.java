package com.secuencia;

import java.util.ArrayList;
import java.util.List;

public class Secuencia {
	
	private int lof;
	private int i;
	private int p;
	private int n;
	
	public void secuencia(int s, int l) {

		List<Integer> list = new ArrayList<>();
		
		int num = s;
		int cont = 0;
		
		list.add(num); // first number
		
		while(num != 1 && cont <= l) {
			if(isEven(num)) {
				num /= 2;
				p++;
			} else if(isOdd(num)) {
				num = num*3 + 1;
				i++;
			}
			cont++;
			list.add(num);
			
			
		} 
		
		if(num == 1) {
			i++;
		}
		
		lof = !list.get(list.size()-1).equals(1) ? 1 : list.size();
	}
	
	private boolean isOdd(int n) {
		return n%2 != 0;
	}
	
	private boolean isEven(int n) {
		return n%2 == 0;
	}
}

package com.zapatos;

public class Zapatos {
	
	public int calculateMovements(int quantity, int[] boxes) {
		
		int cantMovs = 0;
		
		int higher = 0;
		int less = 0;
		
		for(int i = 0; i < quantity; i++) {
			higher = i;
			less = i;
			for(int j = 0; j < quantity; j++) {
				if(boxes[j] > boxes[higher]) {
					higher = j;
				}
				if(boxes[j] < boxes[less]) {
					less = j;
				}
			}
			
			if(boxes[less] != boxes[higher]) {
				boxes[less]++;
				boxes[higher]--;
				cantMovs++;
			}
			
		}
		
		return cantMovs;
	}
	
}

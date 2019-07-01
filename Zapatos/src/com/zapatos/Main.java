package com.zapatos;

public class Main {

	public static void main(String[] args) {
		
		Zapatos zapatos = new Zapatos();
		
		// System.out.println(zapatos.calculateMovements(8, new int[] {0,1,2,1,3,4,2,3}));
		
		System.out.println(zapatos.calculateMovements(7, new int[] {3,6,4,8,6,6,2}));

	}

}

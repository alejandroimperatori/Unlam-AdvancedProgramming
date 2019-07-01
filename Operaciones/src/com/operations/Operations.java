package com.operations;

public class Operations {

	public int operacionesRecursivo(int n) {
		return n == 1 ? 1 : operacionesRecursivo(n % 2 == 0 ? n / 2 : n - 1) + 1;
	}

	/*
	 * public int operaciones(int n) { int c = 0; while (n != 0) { n = n % 2 == 0 ?
	 * n / 2 : n - 1; c++; } return c;
	 * 
	 * }
	 */
	public int operaciones(int n) {
		return n == 1 ? 1 : operaciones(n / 2) + 1 + n % 2;
	}
}

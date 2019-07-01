package com.operations.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.operations.Operations;

public class OperationTest {

	@Test
	public void cantidadOperacionesRecursivo() {
		Operations operations = new Operations();

		assertEquals(2, operations.operacionesRecursivo(2));
		assertEquals(5, operations.operacionesRecursivo(10));
		assertEquals(5, operations.operacionesRecursivo(16));
		assertEquals(17, operations.operacionesRecursivo(2017));
	}

	@Test
	public void cantidadOperaciones() {
		Operations operations = new Operations();

		assertEquals(2, operations.operaciones(2));
		assertEquals(5, operations.operaciones(10));
		assertEquals(5, operations.operaciones(16));
		assertEquals(17, operations.operaciones(2017));
	}

}

package com.progra.luchadores.test;

import org.junit.Assert;
import org.junit.Test;

import com.progra.luchadores.Luchador;

public class TorneoTest {

	@Test
	public void queUnLuchadorDominaAOtroPorAmbasPropeidades() {
		Luchador l1 = new Luchador(100, 100);
		Luchador l2 = new Luchador(105, 120);
		Assert.assertEquals(true, l2.domina(l1));
	}
	
	@Test
	public void queUnLuchadorDominaAOtroPorPeso() {
		Luchador l1 = new Luchador(105, 100);
		Luchador l2 = new Luchador(100, 120);
		Assert.assertEquals(true, l2.domina(l1));
	}
	
	@Test
	public void queUnLuchadorDominaAOtroPorAltura() {
		Luchador l1 = new Luchador(100, 100);
		Luchador l2 = new Luchador(105, 120);
		Assert.assertEquals(true, l2.domina(l1));
	}
	
	
}

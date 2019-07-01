package com.orquesta.entities;

public abstract class InstrumentoDeCuerdas extends Instrumento {
	private int cuerdas;

	@Override
	public abstract String tocar();

	public int getCuerdas() {
		return cuerdas;
	}

	public void setCuerdas(int cuerdas) {
		this.cuerdas = cuerdas;
	}
}

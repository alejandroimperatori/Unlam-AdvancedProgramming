package com.orquesta.entities;

import java.util.List;

public class Orquesta {
	private List<InstrumentoDeCuerdas> cuerdas;
	private List<InstrumentoDeViento> vientos;

	public List<InstrumentoDeCuerdas> getCuerdas() {
		return cuerdas;
	}

	public void setCuerdas(List<InstrumentoDeCuerdas> cuerdas) {
		this.cuerdas = cuerdas;
	}

	public List<InstrumentoDeViento> getVientos() {
		return vientos;
	}

	public void setVientos(List<InstrumentoDeViento> vientos) {
		this.vientos = vientos;
	}

	public boolean add(InstrumentoDeViento instrumentoDeViento) {
		return this.vientos.add(instrumentoDeViento);
	}

	public boolean add(InstrumentoDeCuerdas instrumentoDeCuerdas) {
		return this.cuerdas.add(instrumentoDeCuerdas);
	}

	public void tocarVientos() {
	}

	public void tocarCuerdas() {
	}

	public void tocar() {
	}

}

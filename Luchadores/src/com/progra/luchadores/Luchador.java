package com.progra.luchadores;

public class Luchador {
	
	private double peso;
	private double altura;
	
	public Luchador(double peso, double altura) {
		this.peso = peso;
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public boolean domina(Luchador luchador) {

		if(this.peso == luchador.peso)
			return this.altura > luchador.altura;
		else if(this.altura == luchador.altura)
			return this.peso > luchador.peso;
		
		return this.peso > luchador.peso && this.altura > luchador.altura;
	}
	
	
}

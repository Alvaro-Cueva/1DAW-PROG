package com.gsd.daw.prog.figuras;

public class Contenedor {
	private Integer ancho;
	private Integer alto;
	public Contenedor(Integer ancho, Integer alto) {
		if(ancho==null||alto==null) {
			throw new IllegalArgumentException("Los argumentos no pueden ser null");
		}
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public void addCirculo(Circulo figura) {
		if(figura==null) {
			throw new IllegalArgumentException("Los argumentos no pueden ser null");
		}
		//figura.add(contenedor);
	}
	
	
}

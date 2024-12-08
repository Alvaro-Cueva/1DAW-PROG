package com.gsd.daw.prog.figuras;

public class Punto {
	private Integer x;
	private Integer y;
	public Punto(Integer x, Integer y) {
		if(x==null||y==null) {
			throw new IllegalArgumentException("Los valores no pueden ser null");
		}
		this.x = x;
		this.y = y;
	}
	public Integer getX() {
		return x;
	}
	public Integer getY() {
		return y;
	}
	
	
}

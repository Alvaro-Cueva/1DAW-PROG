package com.gsd.daw.prog.figuras;

public class Linea {
	private Punto punto1;
	private Punto punto2;
	private Stroke stroke;
	public Linea(Punto punto1, Punto punto2) {
		if(punto1==null||punto2==null) {
			throw new IllegalArgumentException("Los parámetros no pueden ser null");
		}
		this.punto1 = punto1;
		this.punto2 = punto2;
		this.stroke = new Stroke(new Color((byte)0,(byte)0,(byte)0),1);
	}
	public void setStroke(Stroke stroke) {
		if(stroke == null) {
			throw new IllegalArgumentException("Los parámetros no pueden ser null");
		}
		this.stroke = stroke;
	}
	
	
	
}

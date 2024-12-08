package com.gsd.daw.prog.figuras;

public class LineaPoligonal {
	private Punto [] puntos;
	private Stroke stroke;
	public LineaPoligonal(Punto[] puntos) {
		if(puntos==null) {
			throw new IllegalArgumentException("Los argumentos no pueden ser null");
		}
		this.puntos = puntos;
		this.stroke= new Stroke(new Color((byte)0,(byte)0,(byte)0),1);
	}
	public void setStroke(Stroke stroke) {
		if(stroke==null) {
			throw new IllegalArgumentException("Los argumentos no pueden ser null");
		}
		this.stroke = stroke;
	}
	
	
	
	
}

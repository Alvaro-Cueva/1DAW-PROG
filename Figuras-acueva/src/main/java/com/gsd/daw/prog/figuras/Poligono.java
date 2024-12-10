package com.gsd.daw.prog.figuras;

public class Poligono {
	private Punto [] puntos;
	private Stroke stroke;
	public Poligono(Punto[] puntos) {
		this.puntos = puntos;
		this.stroke = new Stroke(new Color((byte)0,(byte)0,(byte)0),1);
	}
	public void setStroke(Stroke stroke) {
		if(stroke==null) {
			throw new IllegalArgumentException("Los argumentos no pueden ser null");
		}
		this.stroke = stroke;
	}
	
	public String toSvg(){
		String points = "";
		for (int i = 0; i < puntos.length; i++) {
	        points += puntos[i].getX() + "," + puntos[i].getY() + " ";
	    }
	    points = points.trim();
		return "<polygon points=\""+points+"\" "+stroke.toSvg()+" fill=\"none\"/>";
	}
	
}

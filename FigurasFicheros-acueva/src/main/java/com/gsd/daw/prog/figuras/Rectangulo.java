package com.gsd.daw.prog.figuras;

public class Rectangulo {
	private Punto origen;
	private Integer ancho;
	private Integer alto;
	private Stroke stroke;
	public Rectangulo(Punto origen, Integer ancho, Integer alto) {
		if(origen==null||ancho==null||alto==null) {
			throw new IllegalArgumentException();
		}
		this.origen = origen;
		this.ancho = ancho;
		this.alto = alto;
		this.stroke = new Stroke(new Color((byte)0,(byte)0,(byte)0),1);
	}
	
	public void setStroke(Stroke stroke) {
		if(stroke==null) {
			throw new IllegalArgumentException();
		}
		this.stroke = stroke;
	}
	
	public String toSvg() {
		return "<rect x=\""+this.origen.getX()+"\" y=\""+origen.getY()+"\" width=\""+ancho+"\" height=\""+alto+"\" "+stroke.toSvg()+" fill=\"none\"/>";
	}
}

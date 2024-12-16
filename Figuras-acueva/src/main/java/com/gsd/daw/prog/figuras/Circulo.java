package com.gsd.daw.prog.figuras;

public class Circulo {
	private Punto centro;
	private Integer radio;
	private Stroke stroke;
	public Circulo(Punto centro, Integer radio) {
		if(centro==null||radio==null) {
			throw new IllegalArgumentException();
		}
		this.centro = centro;
		this.radio = radio;
		this.stroke= new Stroke(new Color((byte)0,(byte)0,(byte)0),1);
	}
	

	
	public void setStroke(Stroke stroke) {
		if(stroke == null) {
			throw new IllegalArgumentException();
		}
		this.stroke = stroke;
	}



	public String toSvg() {
		return "<circle cx=\""+centro.getX()+"\" cy=\""+centro.getY()+"\" r=\""+this.radio+"\" "+stroke.toSvg()+" fill=\"none\"/>";
	}
}

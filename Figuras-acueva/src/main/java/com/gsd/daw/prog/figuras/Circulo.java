package com.gsd.daw.prog.figuras;

public class Circulo {
	private Punto centro;
	private Integer radio;
	private Stroke stroke;
	public Circulo(Punto centro, Integer radio) {
		if(centro==null||radio==null) {
			throw new IllegalArgumentException("Los parámetros no pueden ser null");
		}
		this.centro = centro;
		this.radio = radio;
		this.stroke= new Stroke(new Color((byte)0,(byte)0,(byte)0),1);
	}
	

	
	public void setStroke(Stroke stroke) {
		if(stroke == null) {
			throw new IllegalArgumentException("Los parámetros no pueden ser null");
		}
		this.stroke = stroke;
	}



	public String toSvg() {
		return "<circle cx=\""+centro.getX()+"\" cy=\""+centro.getY()+"\" r=\""+this.radio+"\" "+stroke.toSvg();
	}
	//defaul final revisar 
	//"<ellipse cx=\""+centro.getX()+"\" cy=\""+centro.getY()+"\" rx=\""+this.radio1+"\" ry=\""+this.radio2+"\" "+stroke.toSvg();
	//<circle cx="157" cy="497" r="410" stroke="rgb(79,191,2)" stroke-width="16" fill="none"/>
}

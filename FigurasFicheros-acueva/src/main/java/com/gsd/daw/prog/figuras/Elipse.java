package com.gsd.daw.prog.figuras;

public class Elipse {
	private Punto centro;
	private Integer radio1;
	private Integer radio2;
	private Stroke stroke;
	public Elipse(Punto centro, Integer radio1, Integer radio2) {
		if(centro==null||radio1==null||radio2==null) {
			throw new IllegalArgumentException();
		}
		this.centro = centro;
		this.radio1 = radio1;
		this.radio2 = radio2;
		this.stroke= new Stroke(new Color((byte)0,(byte)0,(byte)0),1);
	}
	public void setStroke(Stroke stroke) {
		if(stroke==null) {
			throw new IllegalArgumentException();
		}
		this.stroke = stroke;
	}
	
	public String toSvg() {
		return "<ellipse cx=\""+centro.getX()+"\" cy=\""+centro.getY()+"\" rx=\""+this.radio1+"\" ry=\""+this.radio2+"\" "+stroke.toSvg()+" fill=\"none\"/>";
				
	}
	
}
	
	


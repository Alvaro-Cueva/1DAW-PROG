package com.gsd.daw.prog.figuras;

public class Linea {
	private Punto punto1;
	private Punto punto2;
	private Stroke stroke;
	public Linea(Punto punto1, Punto punto2) {
		if(punto1==null||punto2==null) {
			throw new IllegalArgumentException();
		}
		this.punto1 = punto1;
		this.punto2 = punto2;
		this.stroke = new Stroke(new Color((byte)0,(byte)0,(byte)0),1);
	}
	public void setStroke(Stroke stroke) {
		if(stroke == null) {
			throw new IllegalArgumentException();
		}
		this.stroke = stroke;
	}
	
	public String toSvg() {
		
		return "<line x1=\""+punto1.getX()+"\" y1=\""+punto1.getY()+"\" x2=\""+punto2.getX()+"\" y2=\""+punto2.getY()+"\" "+stroke.toSvg()+"/>";
	}
	
	
}

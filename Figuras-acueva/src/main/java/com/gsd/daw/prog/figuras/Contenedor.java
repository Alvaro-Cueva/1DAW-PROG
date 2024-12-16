package com.gsd.daw.prog.figuras;

public class Contenedor {
	private Integer ancho;
	private Integer alto;
	private String Svg="";
	
	
	public Contenedor(Integer ancho, Integer alto) {
		if(ancho==null||alto==null) {
			throw new IllegalArgumentException();
		}
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public void addCirculo(Circulo figura) {
		if(figura==null) {
			throw new IllegalArgumentException();
		}
		Svg+=figura.toSvg()+"\n";
	}
	
	public void addElipse(Elipse figura) {
		if(figura==null) {
			throw new IllegalArgumentException();
		}
		Svg+=figura.toSvg()+"\n";
	}
	
	public void addLinea(Linea figura) {
		if(figura==null) {
			throw new IllegalArgumentException();
		}
		Svg+=figura.toSvg()+"\n";
	}
	
	public void addLineaPoligonal(LineaPoligonal figura) {
		if(figura==null) {
			throw new IllegalArgumentException();
		}
		Svg+=figura.toSvg()+"\n";
	}
	
	public void addPoligono(Poligono figura) {
		if(figura==null) {
			throw new IllegalArgumentException();
		}
		Svg+=figura.toSvg()+"\n";
	}
	
	public void addRectangulo(Rectangulo figura) {
		if(figura==null) {
			throw new IllegalArgumentException();
		}
		Svg+=figura.toSvg()+"\n";
	}
	
	public String toSvg() {
		return "<svg viewBox=\"0 0 "+ancho+" "+alto+"\" xmlns=\"http://www.w3.org/2000/svg\">"+"\n"+Svg+"</svg>";	
	}
	
}

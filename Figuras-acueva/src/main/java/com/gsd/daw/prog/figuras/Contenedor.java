package com.gsd.daw.prog.figuras;

public class Contenedor {
	private Integer ancho;
	private Integer alto;
	private String circuloSvg;
	private String elipseSvg;
	private String poligonoSvg;
	private String lineaPoligonalSvg;
	private String lineaSvg;
	private String rectanguloSvg;
	
	
	public Contenedor(Integer ancho, Integer alto) {
		if(ancho==null||alto==null) {
			throw new IllegalArgumentException("Los argumentos no pueden ser null");
		}
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public void addCirculo(Circulo figura) {
		if(figura==null) {
			throw new IllegalArgumentException("Los argumentos no pueden ser null");
		}
		this.circuloSvg+=figura.toSvg();
	}
	
	public void addElipse(Elipse figura) {
		if(figura==null) {
			throw new IllegalArgumentException("Los argumentos no pueden ser null");
		}
		this.elipseSvg+=figura.toSvg();
	}
	
	public void addLinea(Linea figura) {
		if(figura==null) {
			throw new IllegalArgumentException("Los argumentos no pueden ser null");
		}
		this.lineaSvg+=figura.toSvg();
	}
	
	public void addLineaPoligonal(LineaPoligonal figura) {
		if(figura==null) {
			throw new IllegalArgumentException("Los argumentos no pueden ser null");
		}
		this.lineaPoligonalSvg+=figura.toSvg();
	}
	
	public void addPoligono(Poligono figura) {
		if(figura==null) {
			throw new IllegalArgumentException("Los argumentos no pueden ser null");
		}
		this.poligonoSvg+=figura.toSvg();
	}
	
	public void addRectangulo(Rectangulo figura) {
		if(figura==null) {
			throw new IllegalArgumentException("Los argumentos no pueden ser null");
		}
		this.rectanguloSvg+=figura.toSvg();
	}
	
	public String toSvg() {
		return "<svg viewBox=\"0 0 "+ancho+" "+alto+"\" xmlns=\"http://www.w3.org/2000/svg\">"+"\n"+elipseSvg+"\n"+circuloSvg+"\n"+lineaSvg+"\n"+lineaPoligonalSvg+"\n"+poligonoSvg+"\n"+rectanguloSvg+"\n"+"</svg>";	
	}
	
}

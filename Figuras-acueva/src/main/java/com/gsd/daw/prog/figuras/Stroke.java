package com.gsd.daw.prog.figuras;

public class Stroke {
	private Color color;
	private Integer width;
	public Stroke(Color color, Integer width) {
		if(color==null || width== null) {
			throw new IllegalArgumentException("Los valores de los argumentos no pueden ser null");
		}
		this.color = color;
		this.width = width;
	}
	
	public String toSvg() {
		return "stroke=\""+color.toSvg()+" stroke-width=\""+width+"\" fill=\"none\"/>";
	}
	
}

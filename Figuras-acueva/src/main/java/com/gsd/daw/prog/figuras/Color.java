package com.gsd.daw.prog.figuras;

public class Color {
	private Byte red;
	private Byte green;
	private Byte blue;
	public Color(Byte red, Byte green, Byte blue) {
		
		if (red==null || green== null || blue==null) {
			throw new IllegalArgumentException("Los parámetros no pueden ser null");
		}
		if (red < 0 || red > 255) {
	        throw new IllegalArgumentException("El componente rojo debe estar entre 0 y 255");
	    }
	    if (green < 0 || green > 255) {
	        throw new IllegalArgumentException("El componente verde debe estar entre 0 y 255");
	    }
	    if (blue < 0 || blue > 255) {
	        throw new IllegalArgumentException("El componente azul debe estar entre 0 y 255");
	    }
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public String toSvg() {
		 return "rgb("+this.red+","+this.green+","+this.blue+")\"";
	}
	
}

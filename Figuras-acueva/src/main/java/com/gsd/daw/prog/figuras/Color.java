package com.gsd.daw.prog.figuras;

public class Color {
	private Byte red;
	private Byte green;
	private Byte blue;
	public Color(Byte red, Byte green, Byte blue) {
		
		if (red==null || green== null || blue==null) {
			throw new IllegalArgumentException();
		}
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public String toSvg() {
		int redRgb= this.red & 0xFE;
		int greenRgb= this.green & 0xFE;
		int blueRgb= this.blue & 0xFE;
		if(redRgb>255||redRgb<0||greenRgb>255||greenRgb<0||blueRgb>255||blueRgb<0) {
			throw new IllegalArgumentException();
		}
		 return "rgb("+redRgb+","+greenRgb+","+blueRgb+")\"";
	}
	
}

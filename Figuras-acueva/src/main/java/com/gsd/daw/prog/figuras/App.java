package com.gsd.daw.prog.figuras;

import com.gsd.daw.prog.api.UnApi;

public class App {
	public static void main(String [] args) {
	 Color c =  new Color ((byte)122,(byte)122,(byte)122);
	 Stroke s = new Stroke(c,1);
	 
	 Punto p = new Punto(12,12);
	 Circulo c1 = new Circulo(p,7);
	 
	 Elipse e = new Elipse(p,7,12);
	 System.out.println(e.toSvg());
	 System.out.println(c1.toSvg());
	}
}

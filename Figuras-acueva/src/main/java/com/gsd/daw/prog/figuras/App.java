package com.gsd.daw.prog.figuras;

public class App {
	public static void main(String [] args) {
	 Color c =  new Color ((byte)122,(byte)122,(byte)122);
	 Stroke s = new Stroke(c,1);
	 
	 Punto p = new Punto(12,12);
	 Punto pp = new Punto(12,12);
	 Circulo c1 = new Circulo(p,7);
	 Linea l = new Linea(p,pp);
	 
	 
	 Punto p1 = new Punto(100, 100);
     Punto p2 = new Punto(200, 100);
     Punto p3 = new Punto(200, 200);
     Punto p4 = new Punto(100, 200);
     Punto[] puntos = {p1, p2, p3, p4};
     Poligono poligono = new Poligono(puntos);
	 
     LineaPoligonal LineaPoli= new LineaPoligonal(puntos);
	 
     
     Rectangulo rectangulo = new Rectangulo(p,1,1);
     
     
     Contenedor contenedor = new Contenedor(1024, 768);
     
	 
	 Elipse e = new Elipse(p,7,12);
	 System.out.println(e.toSvg());
	 System.out.println(c1.toSvg());
	 System.out.println(l.toSvg());
	 System.out.println(poligono.toSvg());
	 System.out.println(LineaPoli.toSvg());
	 System.out.println(rectangulo.toSvg());
	 System.out.println(contenedor.toSvg());
	}
}

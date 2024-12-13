package com.gsd.daw.prog.figuras;

public class App {
	public static void main(String [] args) {
	 Color c =  new Color ((byte)122,(byte)202,(byte)122);
	 Stroke s = new Stroke(c,7);
	 
	 Punto p = new Punto(12,12);
	 Punto pp = new Punto(12,12);
	 Circulo c1 = new Circulo(p,7);
	 Linea l = new Linea(p,pp);
	 
	 
	 Punto p1 = new Punto(100, 100);
     Punto p2 = new Punto(200, 100);
     Punto p3 = new Punto(200, 200);
     Punto p4 = new Punto(100, 200);
     Punto[] puntos = {};
     Punto[] puntos2 = {p3, p2, p1, p4};
     Poligono poligono = new Poligono(puntos);
	 
     LineaPoligonal LineaPoli= new LineaPoligonal(puntos2);
	 
     
     Rectangulo rectangulo = new Rectangulo(p,1,1);
     
     
     Contenedor contenedor = new Contenedor(1024, 768);
     
	 Elipse elipse = new Elipse(p2,12,20);
	 
	 elipse.setStroke(s);
     
	 Elipse e = new Elipse(p,7,12);
	 System.out.println(e.toSvg());
	 System.out.println(c1.toSvg());
	 System.out.println(l.toSvg());
	 System.out.println(poligono.toSvg());
	 System.out.println(LineaPoli.toSvg());
	 System.out.println(rectangulo.toSvg());
	 System.out.println(contenedor.toSvg());
	 contenedor.addCirculo(c1);
	 contenedor.addPoligono(poligono);
	 contenedor.addRectangulo(rectangulo);
	 contenedor.addElipse(e);
	 contenedor.addElipse(elipse);
	 contenedor.addLineaPoligonal(LineaPoli);
	 System.out.println(contenedor.toSvg());
	}
}

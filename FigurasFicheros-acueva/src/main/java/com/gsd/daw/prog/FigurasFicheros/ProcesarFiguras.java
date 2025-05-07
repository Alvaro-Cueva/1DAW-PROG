package com.gsd.daw.prog.FigurasFicheros;

import java.util.*;
import com.gsd.daw.prog.figuras.*;

public class ProcesarFiguras {
    private final List<String> figuras;
    private final List<String> strokes;
    private final Map<String, Stroke> strokeMap = new HashMap<>();

    public ProcesarFiguras(List<String> figuras, List<String> strokes) {
        this.figuras = figuras;
        this.strokes = strokes;
    }

    public Contenedor construirContenedorFiguras() throws ExceptionFigurasFicheros {
        Contenedor contenedor = null;

        for (String strokeLine : strokes) {
            String[] partes = strokeLine.split("\\s+");
            if (partes.length != 6 || !partes[0].equals("ST")) {
                throw new ExceptionFigurasFicheros("Stroke inválido: " + strokeLine);
            }

            String nombre = partes[1];
            int r = Integer.parseInt(partes[2]);
            int g = Integer.parseInt(partes[3]);
            int b = Integer.parseInt(partes[4]);
            int ancho = Integer.parseInt(partes[5]);

            strokeMap.put(nombre, new Stroke(new Color((byte) r, (byte) g, (byte) b), ancho));
        }

        for (int i = 0; i < figuras.size(); i++) {
            String linea = figuras.get(i);
            String[] partes = linea.split("\\s+");

            switch (partes[0]) {
                case "CO":
                    if (partes.length != 3) throw new ExceptionFigurasFicheros("Contenedor inválido en línea: " + linea);
                    int ancho = Integer.parseInt(partes[1]);
                    int alto = Integer.parseInt(partes[2]);
                    contenedor = new Contenedor(ancho, alto);
                    break;

                case "CI":
                    Punto centro = parsePunto(partes[1]);
                    int radio = Integer.parseInt(partes[2]);
                    Stroke strokeCI = getStroke(partes[3], linea);
                    Circulo circulo = new Circulo(centro, radio);
                    circulo.setStroke(strokeCI);
                    contenedor.addCirculo(circulo);
                    break;

                case "EL":
                    Punto centroElipse = parsePunto(partes[1]);
                    int r1 = Integer.parseInt(partes[2]);
                    int r2 = Integer.parseInt(partes[3]);
                    Stroke strokeEL = getStroke(partes[4], linea);
                    Elipse elipse = new Elipse(centroElipse, r1, r2);
                    elipse.setStroke(strokeEL);
                    contenedor.addElipse(elipse);
                    break;

                case "LI":
                    Punto p1 = parsePunto(partes[1]);
                    Punto p2 = parsePunto(partes[2]);
                    Stroke strokeLI = getStroke(partes[3], linea);
                    Linea lineaFigura = new Linea(p1, p2);
                    lineaFigura.setStroke(strokeLI);
                    contenedor.addLinea(lineaFigura);
                    break;

                case "LP":
                    Stroke strokeLP = getStroke(partes[partes.length - 1], linea);
                    Punto[] puntosLP = parsePuntos(partes, 1, partes.length - 1);
                    LineaPoligonal lineaPoligonal = new LineaPoligonal(puntosLP);
                    lineaPoligonal.setStroke(strokeLP);
                    contenedor.addLineaPoligonal(lineaPoligonal);
                    break;

                case "PO":
                    Stroke strokePO = getStroke(partes[partes.length - 1], linea);
                    Punto[] puntosPO = parsePuntos(partes, 1, partes.length - 1);
                    Poligono poligono = new Poligono(puntosPO);
                    poligono.setStroke(strokePO);
                    contenedor.addPoligono(poligono);
                    break;

                case "RE":
                    Punto esquina = parsePunto(partes[1]);
                    int w = Integer.parseInt(partes[2]);
                    int h = Integer.parseInt(partes[3]);
                    Stroke strokeRE = getStroke(partes[4], linea);
                    Rectangulo rectangulo = new Rectangulo(esquina, w, h);
                    rectangulo.setStroke(strokeRE);
                    contenedor.addRectangulo(rectangulo);  
                    break;

                default:
                    throw new ExceptionFigurasFicheros("Tipo de figura desconocido en línea: " + linea);
            }
        }

        if (contenedor == null) {
            throw new ExceptionFigurasFicheros("No se ha definido contenedor.");
        }

        return contenedor;
    }

    private Punto parsePunto(String texto) throws ExceptionFigurasFicheros {
        String[] coords = texto.split(",");
        if (coords.length != 2) throw new ExceptionFigurasFicheros("Punto inválido: " + texto);
        return new Punto(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
    }

    private Punto[] parsePuntos(String[] partes, int inicio, int fin) throws ExceptionFigurasFicheros {
        List<Punto> puntos = new ArrayList<>();
        for (int i = inicio; i < fin; i++) {
            puntos.add(parsePunto(partes[i]));
        }
        return puntos.toArray(new Punto[0]);
    }

    private Stroke getStroke(String nombre, String linea) throws ExceptionFigurasFicheros {
        Stroke s = strokeMap.get(nombre);
        if (s == null) throw new ExceptionFigurasFicheros("Stroke no encontrado [" + nombre + "] en línea: " + linea);
        return s;
    }
}

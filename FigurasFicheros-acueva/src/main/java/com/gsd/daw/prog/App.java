package com.gsd.daw.prog;

import java.io.*;
import java.util.*;

import com.gsd.daw.prog.FigurasFicheros.*;
import com.gsd.daw.prog.figuras.Contenedor;

public class App {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("USO: <fichero-entrada> <fichero-salida>");
            return; 
        }

        String ficheroEntrada = args[0];
        String ficheroSalida = args[1];

        List<String> figuras = new ArrayList<>();
        List<String> strokes = new ArrayList<>();
        Scanner inputScannerFromFile = null;

        try {
            inputScannerFromFile = new Scanner(new File(ficheroEntrada));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: no se puede abrir [" + ficheroEntrada + "]\n" + e.getMessage());
            return;
        }

        while (inputScannerFromFile.hasNextLine()) {
            String line = inputScannerFromFile.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            if (line.startsWith("ST")) {
                strokes.add(line);
            } else {
                figuras.add(line);
            }
        }

        inputScannerFromFile.close();
        
        try {
            ProcesarFiguras procesador = new ProcesarFiguras(figuras, strokes);
            Contenedor contenedor = procesador.construirContenedorFiguras();

            try (PrintWriter out = new PrintWriter(ficheroSalida)) {
                out.println(contenedor.toSvg());
            }

        } catch (ExceptionFigurasFicheros | FileNotFoundException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
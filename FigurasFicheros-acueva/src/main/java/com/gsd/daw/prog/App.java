package com.gsd.daw.prog;

import java.io.*;
import java.util.*;

import com.gsd.daw.prog.FigurasFicheros.*;
import com.gsd.daw.prog.figuras.Contenedor;

public class App {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("USO: <comando> <fichero-entrada> <fichero-salida>");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        List<String> figuras = new ArrayList<>();
        List<String> strokes = new ArrayList<>();
        Scanner inputScannerFromFile = null;

        try {
            inputScannerFromFile = new Scanner(new File(inputFileName));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: no se puede abrir [" + inputFileName + "]\n" + e.getMessage());
            return;
        }

        int lineNumber = 1;
        while (inputScannerFromFile.hasNextLine()) {
            String line = inputScannerFromFile.nextLine().trim();
            if (line.isEmpty()) {
                lineNumber++;
                continue;
            }

            if (line.startsWith("ST")) {
                strokes.add(line);
            } else {
                figuras.add(line);
            }

            lineNumber++;
        }

        inputScannerFromFile.close();

        try {
            ProcesarFiguras procesador = new ProcesarFiguras(figuras, strokes);
            Contenedor contenedor = procesador.construirContenedorFiguras();

            try (PrintWriter out = new PrintWriter(outputFileName)) {
                out.println(contenedor.toSvg());
            }

        } catch (ExceptionFigurasFicheros | FileNotFoundException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
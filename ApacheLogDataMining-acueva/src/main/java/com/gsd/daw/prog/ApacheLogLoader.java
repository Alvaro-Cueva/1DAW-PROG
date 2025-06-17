package com.gsd.daw.prog;

import com.gsd.daw.data.DatabaseConnector;
import com.gsd.daw.file.LogFileReader;
import com.gsd.daw.model.ApacheLogEntry;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ApacheLogLoader {
    public static void main(String[] args) {
        if (args.length != 5) {
            System.err.println("Uso: <IP_BBDD> <Nombre_Instancia> <Usuario> <Password> <Fichero_CSV>");
            System.exit(1);
        }

        try {
            Connection connection = DatabaseConnector.getConnection(args[0], args[1], args[2], args[3]);
            System.out.println("INFO: conectado a BBDD.");


            String[][] logLines = LogFileReader.readLogFile(args[4], 40000);
            System.out.println("INFO: leidas [" + logLines.length + "] lineas del fichero.");


            ApacheLogEntry[] logEntries = new ApacheLogEntry[logLines.length];
            for (int i = 0; i < logLines.length; i++) {
                String[] line = logLines[i];
                int bytes = line[4].equals("-") ? 0 : Integer.parseInt(line[4]);
                logEntries[i] = new ApacheLogEntry(line[0], line[1], line[2], line[3], bytes, line[5]);
            }
            System.out.println("INFO: creados [" + logEntries.length + "] objetos.");


            int rowsInserted = 0;
            for (ApacheLogEntry entry : logEntries) {
                entry.save(connection);
                rowsInserted++;
            }
            System.out.println("INFO: insertadas [" + rowsInserted + "] filas en BBDD.");

            connection.close();
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir bytes: " + e.getMessage());
        }
    }
}

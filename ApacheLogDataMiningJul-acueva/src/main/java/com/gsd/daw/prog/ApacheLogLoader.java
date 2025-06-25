package com.gsd.daw.prog;

import com.gsd.daw.data.DatabaseConnector;
import com.gsd.daw.file.LogFileReader;
import com.gsd.daw.model.ApacheLogEntry;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApacheLogLoader {

    private static final Logger LOGGER = Logger.getLogger(ApacheLogLoader.class.getName());

    private static void configurarLogging() {
        String logLevelEnv = System.getenv("LOG_LEVEL");
        if (logLevelEnv != null) {
            try {
                Level logLevel = Level.parse(logLevelEnv.toUpperCase());
                System.out.println("LogLevel forzado a [" + logLevel + "]");
                Logger rootLogger = Logger.getLogger("");
                rootLogger.setLevel(logLevel);
                for (Handler h : rootLogger.getHandlers()) {
                    h.setLevel(logLevel);
                }
            } catch (IllegalArgumentException ex) {
                System.err.println("Valor de LOG_LEVEL no válido: " + logLevelEnv + ". Se mantiene el nivel de log por defecto.");
            }
        }
    }

    
    public static void main(String[] args) {
        configurarLogging();
        if (args.length != 5) {
            LOGGER.severe("Uso: <IP_BBDD> <Nombre_Instancia> <Usuario> <Password> <Fichero_CSV>");
            System.exit(1);
        }
        try {
            Connection connection = DatabaseConnector.getConnection(args[0], args[1], args[2], args[3]);
            LOGGER.info("Conectado a BBDD.");

            String[][] logLines = LogFileReader.readLogFile(args[4], 40000);
            LOGGER.info("Leídas [" + logLines.length + "] líneas del fichero.");

            ApacheLogEntry[] logEntries = new ApacheLogEntry[logLines.length];
            for (int i = 0; i < logLines.length; i++) {
                String[] line = logLines[i];
                int bytes = line[4].equals("-") ? 0 : Integer.parseInt(line[4]);
                logEntries[i] = new ApacheLogEntry(line[0], line[1], line[2], line[3], bytes, line[5]);
            }
            LOGGER.info("Creados [" + logEntries.length + "] objetos.");

            int rowsInserted = 0;
            for (ApacheLogEntry entry : logEntries) {
                entry.save(connection);
                rowsInserted++;
                LOGGER.fine("Insertada fila " + rowsInserted + ": IP=" + entry.getIp() + ", Request=" + entry.getRequest());
            }
            LOGGER.info("Insertadas [" + rowsInserted + "] filas en BBDD.");

            connection.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error de base de datos: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error al leer el fichero: " + e.getMessage());
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Error al convertir bytes: " + e.getMessage());
        }
    }
}

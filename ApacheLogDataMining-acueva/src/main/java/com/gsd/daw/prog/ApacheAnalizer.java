package com.gsd.daw.prog;

import com.gsd.daw.analysis.LogAnalyzer;
import com.gsd.daw.data.DatabaseConnector;
import com.gsd.daw.model.ApacheLogEntry;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ApacheAnalizer {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.err.println("Uso:<IP_BBDD> <Nombre_Instancia> <Usuario> <Password>");
            System.exit(1);
        }

        try {
            Connection connection = DatabaseConnector.getConnection(args[0], args[1], args[2], args[3]);
            System.out.println("INFO: conectado a BBDD.");

            String[][] logLines = loadLogsFromDB(connection);
            System.out.println("INFO: leídas [" + logLines.length + "] líneas de BBDD.");

            ApacheLogEntry[] logEntries = new ApacheLogEntry[logLines.length];
            for (int i = 0; i < logLines.length; i++) {
                String[] line = logLines[i];
                int bytes = Integer.parseInt(line[4]);
                logEntries[i] = new ApacheLogEntry(line[0], line[1], line[2], line[3], bytes, line[5]);
            }
            System.out.println("INFO: creados [" + logEntries.length + "] objetos.");
            LogAnalyzer.analyzeLogs(logEntries);

            connection.close();
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir bytes: " + e.getMessage());
        }
    }

    private static String[][] loadLogsFromDB(Connection connection) throws SQLException {
        String query = "SELECT IP, TIMESTAMP, REQUEST, RESULT, BYTES, UA FROM APACHE_LOG_TBL";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
        	/**
        	 * Lee todas las entradas de la tabla APACHE_LOG_TBL y devuelve los datos como un array bidimensional de Strings.
        	 * Usamos una lista dinámica para evitar recorrer el ResultSet dos veces y así evitar el error ORA-17075,
        	 * que ocurre si se intenta retroceder en un ResultSet de solo avance (forward-only).
        	 */

            List<String[]> rows = new ArrayList<>();

            while (rs.next()) {
                String[] row = new String[6];
                row[0] = rs.getString("IP");
                row[1] = rs.getString("TIMESTAMP");
                row[2] = rs.getString("REQUEST");
                row[3] = rs.getString("RESULT");
                row[4] = rs.getString("BYTES");
                row[5] = rs.getString("UA");
                rows.add(row);
            }

            return rows.toArray(new String[0][6]);
        }
    }
}

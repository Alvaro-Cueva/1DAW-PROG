package com.gsd.daw.prog;

import com.gsd.daw.analysis.LogAnalyzer;
import com.gsd.daw.data.DatabaseConnector;
import com.gsd.daw.model.ApacheLogEntry;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            System.out.println("INFO: leidas [" + logLines.length + "] lineas de BBDD.");

 
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
            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
            }
            
            String[][] result = new String[rowCount][6];
            rs.beforeFirst();
            
            int i = 0;
            while (rs.next()) {
                result[i][0] = rs.getString("IP");
                result[i][1] = rs.getString("TIMESTAMP");
                result[i][2] = rs.getString("REQUEST");
                result[i][3] = rs.getString("RESULT");
                result[i][4] = rs.getString("BYTES");
                result[i][5] = rs.getString("UA");
                i++;
            }
            
            return result;
        }
    }
}
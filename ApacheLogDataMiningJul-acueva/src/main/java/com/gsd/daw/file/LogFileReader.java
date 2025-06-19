package com.gsd.daw.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFileReader {
    public static String[][] readLogFile(String filename, int maxLines) throws IOException {
        String[][] logData = new String[maxLines][6];
        int lineCount = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null && lineCount < maxLines) {
                String[] parsedLine = parseLogLineString(line);
                if (parsedLine != null) {
                    System.arraycopy(parsedLine, 0, logData[lineCount], 0, 6);
                    lineCount++;
                }
            }
        }
        

        if (lineCount < maxLines) {
            String[][] result = new String[lineCount][6];
            System.arraycopy(logData, 0, result, 0, lineCount);
            return result;
        }
        
        return logData;
    }

    
    private static String[] parseLogLineString( String line ) {
        String  LOG_ENTRY_PATTERN = "^(\\S+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\S+) \"(.*?)\" \"(.*?)\"$";
        Pattern pattern = Pattern.compile( LOG_ENTRY_PATTERN );     
        
        String[] res = new String[6];

        Matcher matcher = pattern.matcher( line );
        if ( matcher.matches() ) {
            res[0] = matcher.group( 1 );
            res[1] = matcher.group( 4 );
            res[2] = matcher.group( 5 );
            res[3] = matcher.group( 6 );
            res[4] = matcher.group( 7 );
            res[5] = matcher.group( 9 );
        }
        return res;
    }
}
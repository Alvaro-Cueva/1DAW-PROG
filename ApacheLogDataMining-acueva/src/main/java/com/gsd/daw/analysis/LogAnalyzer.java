package com.gsd.daw.analysis;

import com.gsd.daw.model.ApacheLogEntry;
import java.util.HashMap;
import java.util.Map;

public class LogAnalyzer {
    public static void analyzeLogs(ApacheLogEntry[] logs) {
        Map<String, Integer> ipCounts = new HashMap<>();
        for (ApacheLogEntry log : logs) {
            ipCounts.put(log.getIp(), ipCounts.getOrDefault(log.getIp(), 0) + 1);
        }

        System.out.println("Listado de las IPs que aparecen 10 o más veces");
        for (Map.Entry<String, Integer> entry : ipCounts.entrySet()) {
            if (entry.getValue() >= 10) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        
        
        
        Map<String, Integer> statusCounts = new HashMap<>();
        for (ApacheLogEntry log : logs) {
            statusCounts.put(log.getResult(), statusCounts.getOrDefault(log.getResult(), 0) + 1);
        }

        System.out.println("Listado de numero de veces que aparece cada Status Code");
        for (Map.Entry<String, Integer> entry : statusCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
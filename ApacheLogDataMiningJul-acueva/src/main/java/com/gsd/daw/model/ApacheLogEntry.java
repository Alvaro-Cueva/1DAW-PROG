package com.gsd.daw.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApacheLogEntry {
    private String ip;
    private String timestamp;
    private String request;
    private String result;
    private int bytes;
    private String userAgent;

    public ApacheLogEntry(String ip, String timestamp, String request, String result, int bytes, String userAgent) {
        this.ip = ip;
        this.timestamp = timestamp;
        this.request = request;
        this.result = result;
        this.bytes = bytes;
        this.userAgent = userAgent;
    }

    public void save(Connection connection) throws SQLException {
        String sql = "INSERT INTO APACHE_LOG_TBL (IP, TIMESTAMP, REQUEST, RESULT, BYTES, UA) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, ip);
            pstmt.setString(2, timestamp);
            pstmt.setString(3, request);
            pstmt.setString(4, result);
            pstmt.setInt(5, bytes);
            pstmt.setString(6, userAgent);
            pstmt.executeUpdate();
        }
    }

	public String getIp() {
		return ip;
	}

	public String getResult() {
		return result;
	}

	public String getRequest() {
		return request;
	}
	
}
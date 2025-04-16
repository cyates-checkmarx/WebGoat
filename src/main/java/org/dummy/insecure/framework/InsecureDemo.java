import java.sql.*;
import java.security.MessageDigest;
import java.io.*;

public class InsecureDemo {
    public static void main(String[] args) {
        // Hardcoded AWS credentials (DO NOT USE IN REAL CODE)
        String awsAccessKey = "AKIAIOSFODNN7EXAMPLE";
        String awsSecretKey = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";

        // Insecure SQL query (vulnerable to SQL injection)
        String userInput = "' OR '1'='1";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "pass");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Insecure hashing (MD5 is outdated and weak)
        try {
            String password = "supersecret";
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            System.out.println("Hash: " + new String(hash));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Command injection vulnerability
        try {
            String filename = "important.txt; rm -rf /"; // Simulates malicious input
            Runtime.getRuntime().exec("cat " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
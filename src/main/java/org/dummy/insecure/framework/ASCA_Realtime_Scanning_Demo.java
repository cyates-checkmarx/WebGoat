import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

package org.dummy.insecure.framework;


public class ASCA_Realtime_Scanning_Demo {
 
    public static void main(String[] args) {
        String filePath = System.getProperty("user.home") + "/file.txt"; // Dynamically derive the file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
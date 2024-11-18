import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("config.txt"));
            String url = reader.readLine();
            String user = reader.readLine();
            String password = "mypassword";
            reader.close();

            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            statement.setString(1, "admin");
            statement.executeQuery();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
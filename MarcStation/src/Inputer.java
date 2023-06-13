
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marc
 */
import java.sql.*;

public class Inputer {
    static String DbURL = "jdbc:mysql://127.0.0.1:3306/your_games";
    static String Username = "user";
    static String password = "4251";
    public static void main(){
        Add_Entry a = new Add_Entry();
        a.setVisible(true);
    }
    public static void adder(String portada, String name, String platform, String description, String rating, String hours, String percent){
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
              String sql = "INSERT INTO your_games_records (url, name, platform, description, hours, percent, rating)"
    + " values (?, ?, ?, ?, ?, ?, ?)";
            Connection connection = DriverManager.getConnection(DbURL, Username, password);
            
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
  preparedStmt.setString (1, portada);
  preparedStmt.setString (2, name);
  preparedStmt.setString   (3, platform);
  preparedStmt.setString(4, description);
  preparedStmt.setFloat    (5, Float.parseFloat(hours));
  preparedStmt.setFloat    (6, Float.parseFloat(percent));
  preparedStmt.setFloat    (7, Float.parseFloat(rating));
            preparedStmt.execute();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        selector s = new selector();
        s.setVisible(true);
    }
}

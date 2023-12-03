package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection connection = null;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectDB?useSSL=false","root","aayushverma2002#");
        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
//        System.out.println("Connection is completed");
        return connection;
    }
    
    public static void closeConnection(){
        if(connection != null){
            try{
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

}

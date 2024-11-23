package baseDatos;
import java.sql.*;

public class dbConnecion {
    static String url = "jdbc:mysql://82.197.82.62:3306/u984447967_op2024b";
    static String user = "u984447967_unipaz";
    static String pass = "estudiantesPoo2024B.*";
    
    public static Connection conectar(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion hecha");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}

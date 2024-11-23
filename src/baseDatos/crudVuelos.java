package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class crudVuelos {
//--------------------------------------------------------------------------------------------------------------    
    public void insertarDatos(int idVuelo, String identificador, String ciudadOrigen,
            String ciudadDestino, double precio, int numMaxpasajeros){
        String query = "insert into vuelos(idVuelo, identificador,"
                + " ciudadOrigen, ciudadDestino, precio, numMaxpasajeros) values(?, ?, ?, ?, ?, ?)";
        try{
            Connection con = dbConnecion.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, idVuelo);
            ps.setString(2, identificador);
            ps.setString(3, ciudadOrigen);
            ps.setString(4, ciudadDestino);
            ps.setDouble(5, precio);
            ps.setInt(6, numMaxpasajeros);
            
            ps.executeUpdate();
            System.out.println("Dato insertado👍");
            
        }catch (SQLException ex){
            System.out.println("ERROR al insertar datos");
            ex.printStackTrace();
        }  
    }
//--------------------------------------------------------------------------------------------------------------    
    public void leerDatos(){
            String query = "select * from vuelos";

            try{
            Connection con = dbConnecion.conectar();
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {                    
                int id = rs.getInt("idVuelo");
                String dato1 = rs.getString("identificador");
                String dato2 = rs.getString("ciudadOrigen");
                String dato3 = rs.getString("ciudadDestino");
                double dato4 = rs.getDouble("precio");
                int dato5 = rs.getInt("numMaxpasajeros");
                
                System.out.println(
                    "[ID: " + id + "]" +
                    " [Identificador: " + dato1 + "]" +
                    " [CiudadOrigen: " + dato2 + "]" +
                    " [CiudadDestino: " + dato3 + "]" +
                    " [Precio: " + dato4 + "]" +
                    " [NumMaxpasajeros: " + dato5 + "]");      
            }

        }catch (SQLException ex){
            System.out.println("ERROR al leer datos");
            ex.printStackTrace();
        }        
    }
//--------------------------------------------------------------------------------------------------------------    
    public void actualizarDato(int idVuelo, String identificador, String ciudadOrigen,
            String ciudadDestino, double precio, int numMaxpasajeros){
            //String query = "update pasajeros(nombre, pasaporte, nacionalidad) values(?, ?, ?) where pasajeros = ?";
            String query = "update vuelos set identificador = ?, ciudadOrigen = ?,"
                    + " ciudadDestino = ?, precio = ?, numMaxpasajeros = ? where idVuelo = ?";

            try{
            Connection con = dbConnecion.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, idVuelo);
            ps.setString(2, identificador);
            ps.setString(3, ciudadOrigen);
            ps.setString(4, ciudadDestino);
            ps.setDouble(5, precio);
            ps.setInt(6, numMaxpasajeros);
            
            ps.executeUpdate();
                System.out.println("Dato actualizado👍");
            }catch (SQLException ex){
                System.out.println("ERROR al actualizar datos");
                ex.printStackTrace();
            }
        }        
//--------------------------------------------------------------------------------------------------------------        
    public void elimianrDato(int idPasajero){
            String query = "delete from vuelos where idVuelo = ?";

            try{
            Connection con = dbConnecion.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, idPasajero);
            
            ps.executeUpdate();
                System.out.println("Dato elemidano👍");
            }catch (SQLException ex){
                System.out.println("ERROR al eliminar datos");
                ex.printStackTrace();
            }
        }        
//--------------------------------------------------------------------------------------------------------------  
   
}   




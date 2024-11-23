package baseDatos;
import java.sql.*;

public class crudPasajeros {
//--------------------------------------------------------------------------------------------------------------    
    public void insertarDatos(int idPasajero, String nombre, String pasaporte, String nacionalidad){
        String query = "insert into pasajeros(idPasajero, nombre, pasaporte, nacionalidad) values(?, ?, ?, ?)";
        try{
            Connection con = dbConnecion.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, idPasajero);
            ps.setString(2, nombre);
            ps.setString(3, pasaporte);
            ps.setString(4, nacionalidad);
            
            ps.executeUpdate();
            System.out.println("Dato insertado👍");
            
        }catch (SQLException ex){
            System.out.println("ERROR al insertar datos");
            ex.printStackTrace();
        }  
    }
//--------------------------------------------------------------------------------------------------------------    
    public void leerDatos(){
            String query = "select * from pasajeros";

            try{
            Connection con = dbConnecion.conectar();
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {                    
                int id = rs.getInt("idPasajero");
                String dato1 = rs.getString("nombre");
                String dato2 = rs.getString("pasaporte");
                String dato3 = rs.getString("nacionalidad");
                
                System.out.println(
                    "[ID: " + id + "]" +
                    " [Nombre: " + dato1 + "]" +
                    " [Pasaporte: " + dato2 + "]" +
                    " [Nacionalidad: " + dato3 + "]");
            }

        }catch (SQLException ex){
            System.out.println("ERROR al leer datos");
            ex.printStackTrace();
        }        
    }
//--------------------------------------------------------------------------------------------------------------    
    public void actualizarDato(int idPasajero, String nombre, String pasaporte, String nacionalidad){
            //String query = "update pasajeros(nombre, pasaporte, nacionalidad) values(?, ?, ?) where pasajeros = ?";
            String query = "UPDATE pasajeros SET nombre = ?, pasaporte = ?, nacionalidad = ? WHERE idPasajero = ?";

            try{
            Connection con = dbConnecion.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, idPasajero);
            ps.setString(2, nombre);
            ps.setString(3, pasaporte);
            ps.setString(4, nacionalidad);
            
            ps.executeUpdate();
                System.out.println("Dato actualizado👍");
            }catch (SQLException ex){
                System.out.println("ERROR al actualizar datos");
                ex.printStackTrace();
            }
        }        
//--------------------------------------------------------------------------------------------------------------        
    public void elimianrDato(int idPasajero){
            String query = "delete from pasajeros where idPasajero = ?";

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


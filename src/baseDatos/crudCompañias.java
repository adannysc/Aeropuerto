package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class crudCompañias {
//--------------------------------------------------------------------------------------------------------------    
    public void insertarDatos(int idCompania, String nombre){
        String query = "insert into companias(idCompania, nombre) values(?, ?)";
        try{
            Connection con = dbConnecion.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, idCompania);
            ps.setString(2, nombre);
            
            ps.executeUpdate();
            System.out.println("Dato insertado👍");
            
        }catch (SQLException ex){
            System.out.println("ERROR al insertar datos");
            ex.printStackTrace();
        }  
    }
//--------------------------------------------------------------------------------------------------------------    
    public void leerDatos(){
            String query = "select * from companias";

            try{
            Connection con = dbConnecion.conectar();
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {                    
                int id = rs.getInt("idCompania");
                String dato1 = rs.getString("nombre");
                
                System.out.println(
                    "[ID: " + id + "]" +
                    " [NombreCompañia: " + dato1 + "]");      
            }

        }catch (SQLException ex){
            System.out.println("ERROR al leer datos");
            ex.printStackTrace();
        }        
    }
//--------------------------------------------------------------------------------------------------------------    
    public void actualizarDato(int idCompania, String nombre){
            //String query = "update pasajeros(nombre, pasaporte, nacionalidad) values(?, ?, ?) where pasajeros = ?";
            String query = "update companias set nombre = ? where idCompania = ?";

            try{
            Connection con = dbConnecion.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, idCompania);
            ps.setString(2, nombre);
            
            ps.executeUpdate();
                System.out.println("Dato actualizado👍");
            }catch (SQLException ex){
                System.out.println("ERROR al actualizar datos");
                ex.printStackTrace();
            }
        }        
//--------------------------------------------------------------------------------------------------------------        
    public void elimianrDato(int idPasajero){
            String query = "delete from companias where idCompania = ?";

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

package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class crudVuelosYPasajeros {
//--------------------------------------------------------------------------------------------------------------    
    public void leerDatos(){
            String query = "select * from vuelos_pasajeros";

            try{
            Connection con = dbConnecion.conectar();
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {                    
                int id1 = rs.getInt("id");
                int id2 = rs.getInt("idVuelo");
                int id3 = rs.getInt("idPasajero");
                
                
                System.out.println(
                    "[ID: " + id1 + "]" +
                    " [ID-Vuelo: " + id2 + "]" +
                    " [ID-Pasajero: " + id3 + "]");      
            }

        }catch (SQLException ex){
            System.out.println("ERROR al leer datos");
            ex.printStackTrace();
        }        
    }
//--------------------------------------------------------------------------------------------------------------     
    
}

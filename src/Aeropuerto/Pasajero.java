package Aeropuerto;

import baseDatos.crudPasajeros;
import javax.swing.JOptionPane;

public class Pasajero {
    private String nombre;
    private String pasaporte;
    private String nacionalidad;

    public Pasajero(String nombre, String pasaporte, String nacionalidad) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
    }
    
    //Metodo para registrar pasajero
    public void registrarPasajero() {
        nombre = JOptionPane.showInputDialog(
                "Nombre");
        pasaporte = JOptionPane.showInputDialog(
                "Número de pasaporte");
        nacionalidad = JOptionPane.showInputDialog(
                "Nacionalidad");
        
        crudPasajeros operacion1 = new crudPasajeros();
        operacion1.insertarDatos(0, nombre, pasaporte, nacionalidad);
        operacion1.leerDatos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    

}

 package Aeropuerto;

import java.util.List;

public class Aeropuerto {
    private String nombre;
    private String ciudad;
    private String pais;
    private List<Vuelo> vuelos;

    public Aeropuerto(String nombre, String ciudad, String pais, List<Vuelo> vuelos) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.vuelos = vuelos;
    }
    /*
    public void consultarVuelos() {
        System.out.println("Consultando vuelos del aeropuerto " + nombre);
        // Mostrar lista de vuelos aquí
    }

    public void consultarVuelosCiudad(String ciudad) {
        System.out.println("Consultando vuelos hacia " + ciudad);
        // Mostrar vuelos que van hacia la ciudad indicada
    }
    */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
}

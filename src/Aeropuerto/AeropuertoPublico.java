package Aeropuerto;

import java.util.List;

public class AeropuertoPublico extends Aeropuerto {
    private float aporteGubernamental;

    public AeropuertoPublico(String nombre, String ciudad, String pais, List<Vuelo> vuelos, float aporteGubernamental) {
        super(nombre, ciudad, pais, vuelos);
        this.aporteGubernamental = aporteGubernamental;
    }
    /*
    public void mostrarInfo() {
        System.out.println(super.getNombre() + " | " + super.getCiudad() + " | " + super.getPais());
    }

    public void consultarAporteGubernamental() {
        System.out.println("Aporte gubernamental para el aeropuerto " + super.getNombre() + ": " + aporteGubernamental);
    }
    */
    public float getAporteGubernamental() {
        return aporteGubernamental;
    }

    public void setAporteGubernamental(float aporteGubernamental) {
        this.aporteGubernamental = aporteGubernamental;
    }
}

package Aeropuerto;

import java.util.List;

public class AeropuertoPrivado extends Aeropuerto {
    private List<String> empresasPatrocinadoras;

    public AeropuertoPrivado(String nombre, String ciudad, String pais, List<Vuelo> vuelos, List<String> empresasPatrocinadoras) {
        super(nombre, ciudad, pais, vuelos);
        this.empresasPatrocinadoras = empresasPatrocinadoras;
    }
    /*
    public void consultarEmpresasPatrocinadoras() {
        System.out.println("Empresas patrocinadoras del aeropuerto " + super.getNombre());
        for (String empresa : empresasPatrocinadoras) {
            System.out.println(empresa);
        }
    }
    */
    public List<String> getEmpresasPatrocinadoras() {
        return empresasPatrocinadoras;
    }

    public void setEmpresasPatrocinadoras(List<String> empresasPatrocinadoras) {
        this.empresasPatrocinadoras = empresasPatrocinadoras;
    }
}

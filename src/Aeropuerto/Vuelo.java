package Aeropuerto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

public class Vuelo {
    private String identificador;
    private String ciudadOrigen;
    private String ciudadDestino;
    private float precio;
    private int numPasajerosMaximos;
    private Set<Integer> asientosOcupados;

    public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, float precio, int numPasajerosMaximos) {
        this.identificador = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.numPasajerosMaximos = numPasajerosMaximos;
        this.asientosOcupados = new HashSet<>();
    }
    
    public static Vuelo precio(Vuelo vueloSeleccionado){
        boolean continuar = true;
        while (continuar) {
            float montoIngresado = Float.parseFloat(JOptionPane.showInputDialog(
                    "Ingrese el monto a pagar: (que son: "
                    + vueloSeleccionado.getPrecio() + ")"));

            if (montoIngresado > vueloSeleccionado.getPrecio()) {
                float excedente = montoIngresado
                        - vueloSeleccionado.getPrecio();
                JOptionPane.showMessageDialog(null,
                        "Pago exitoso. Su cambio es: " + excedente);
                JOptionPane.showMessageDialog(null,
                        "Reservación completada para el vuelo "
                        + vueloSeleccionado.getIdentificador() + " hacia "
                        + vueloSeleccionado.getCiudadDestino());
                //break;
                //System.exit(0);
                continuar = false;
            } else if (montoIngresado == vueloSeleccionado.getPrecio()) {
                JOptionPane.showMessageDialog(null, "Pago exitoso");
                JOptionPane.showMessageDialog(null,
                        "Reservación completada para el vuelo "
                        + vueloSeleccionado.getIdentificador() + " hacia "
                        + vueloSeleccionado.getCiudadDestino());
                //break;
                //System.exit(0);
                continuar = false;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Monto insuficiente. Por favor,"
                        + " ingrese el monto completo.");
            }
        }
        return null;
    }
    
    public Integer[] getAsientosDisponibles() {
        List<Integer> disponibles = new ArrayList<>();
        for (int i = 1; i <= numPasajerosMaximos; i++) {
            if (!asientosOcupados.contains(i)) {
                disponibles.add(i);
            }
        }
        return disponibles.toArray(new Integer[0]);
    }
    
    public static Vuelo seleccionarAsiento(Vuelo vueloSeleccionado){
        if (vueloSeleccionado != null) {
            boolean continuar = true;
            while (continuar) {
                // Crear la lista de asientos disponibles
                Integer[] asientosDisponibles = vueloSeleccionado.getAsientosDisponibles();
                
                if (asientosDisponibles.length == 0) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, no hay asientos disponibles.");
                    continuar = false;
                    break;
                }
                // Mostrar selección de asiento
                Object asientoSeleccionado = JOptionPane.showInputDialog(
                        null,
                        "Seleccione el asiento en el que quiere sentarse",
                        "Selección de asientos",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        asientosDisponibles,
                        asientosDisponibles[0]);

                if (asientoSeleccionado != null) {
                    int asiento = (int) asientoSeleccionado;
                    vueloSeleccionado.getAsientosOcupados().add(asiento);
                    JOptionPane.showMessageDialog(null, "Ha reservado el asiento: " + asiento);

                    // Preguntar si desea continuar
                    int opcion = JOptionPane.showConfirmDialog(
                            null,
                            "¿Desea realizar otra reserva?",
                            "Continuar",
                            JOptionPane.YES_NO_OPTION);
                    continuar = (opcion == JOptionPane.YES_OPTION);
                } else {
                    continuar = false;
                }
            }
        }
        return null;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getNumPasajerosMaximos() {
        return numPasajerosMaximos;
    }

    public void setNumPasajerosMaximos(int numPasajerosMaximos) {
        this.numPasajerosMaximos = numPasajerosMaximos;
    }

    public Set<Integer> getAsientosOcupados() {
        return asientosOcupados;
    }

    public void setAsientosOcupados(Set<Integer> asientosOcupados) {
        this.asientosOcupados = asientosOcupados;
    }
    
    
}

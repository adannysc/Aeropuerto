package Main;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Aeropuerto.Vuelo;
import Aeropuerto.AeropuertoPrivado;
import Aeropuerto.AeropuertoPublico;
import Aeropuerto.Pasajero;

public class Main {
    public static void main(String[] args) {
        //Crear algunos vuelos de ejemplo
        Vuelo vuelo1 = new Vuelo("A123", "CiudadA", "CiudadB", 150.0f, 110);
        Vuelo vuelo2 = new Vuelo("B456", "CiudadC", "CiudadD", 200.0f, 140);
        Vuelo vuelo3 = new Vuelo("C789", "CiudadE", "CiudadF", 120.0f, 150);
        Vuelo vuelo4 = new Vuelo("D901", "CiudadG", "CiudadH", 100.0f, 125);
        Vuelo vuelo5 = new Vuelo("E482", "CiudadI", "CiudadJ", 120.0f, 100);
        Vuelo vuelo6 = new Vuelo("F159", "CiudadK", "CiudadM", 100.0f, 115);
        Vuelo vuelo7 = new Vuelo("G753", "CiudadN", "CiudadL", 100.0f, 90);
        Vuelo vuelo8 = new Vuelo("H654", "CiudadO", "CiudadP", 100.0f, 120);

        //Crear listas de vuelos
        List<Vuelo> vuelosPublicos1 = new ArrayList<>();
        vuelosPublicos1.add(vuelo1);
        vuelosPublicos1.add(vuelo3);
        
        List<Vuelo> vuelosPublicos2 = new ArrayList<>();
        vuelosPublicos2.add(vuelo5);
        vuelosPublicos2.add(vuelo7);

        List<Vuelo> vuelosPrivados1 = new ArrayList<>();
        vuelosPrivados1.add(vuelo2);
        vuelosPrivados1.add(vuelo4);
        
        List<Vuelo> vuelosPrivados2 = new ArrayList<>();
        vuelosPrivados2.add(vuelo6);
        vuelosPrivados2.add(vuelo8);

        //Crear aeropuertos de ejemplo
        AeropuertoPublico aeropuertoPublico1 = new AeropuertoPublico("Aeropuerto Público 1", "CiudadA", "PaísA", vuelosPublicos1, 500000.0f);
        AeropuertoPublico aeropuertoPublico2 = new AeropuertoPublico("Aeropuerto Público 2", "CiudadB", "PaísC", vuelosPublicos2, 600000.0f);
        AeropuertoPrivado aeropuertoPrivado1 = new AeropuertoPrivado("Aeropuerto Privado 1", "CiudadC", "PaísB", vuelosPrivados1, List.of("Empresa1", "Empresa2"));
        AeropuertoPrivado aeropuertoPrivado2 = new AeropuertoPrivado("Aeropuerto Privado 2", "CiudadD", "PaísD", vuelosPrivados2, List.of("Empresa3", "Empresa4"));

        while (true) { 
            //menú de seleccion de tipos de aeropuestos 
            String[] tipoVuelos = {
                "Vuelos Públicos",
                "Vuelos Privados"};
            
            int seleccion = JOptionPane.showOptionDialog(
                null,
                "Elija el tipo de vuelo",
                "Selección de opción",
                0,
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipoVuelos,
                tipoVuelos[0]);
            
            //Salir si elige cerrar la ventana
            if (seleccion == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(
                    null,
                    "Gracias por usar el sistema de reserva de vuelos.");
                break;
            }
            
            switch (seleccion) {
            case 0:
                //seleccionar aeropuerto público
                String[] opcionesPublicas = {
                    aeropuertoPublico1.getNombre(),
                    aeropuertoPublico2.getNombre(),
                    "Aporte gubernamental"};

                seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Elija el aeropuerto público",
                    "Seleccionar aeropuerto público",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesPublicas,
                    opcionesPublicas[0]);

                if (seleccion == 0) {
                    System.out.println("aeropuerto 1");
                    //Seleccionar un vuelo en el aeropuerto 1
                    
                    StringBuilder mensajeVuelos = new StringBuilder();
                    for (Vuelo vuelo : vuelosPublicos1) {
                        mensajeVuelos.append(
                            "Vuelo " + vuelo.getIdentificador() +
                            " - Origen: " + vuelo.getCiudadOrigen() +
                            " - Destino: " + vuelo.getCiudadDestino() +
                            " - Precio: " + vuelo.getPrecio() + " USD\n");
                    }
    
                    String[] opcionesVuelos = new String[vuelosPublicos1.size()];
                    for (int i = 0; i < vuelosPublicos1.size(); i++) {
                        opcionesVuelos[i] = "Vuelo " + vuelosPublicos1.get(i).getIdentificador();
                    }

                    seleccion = JOptionPane.showOptionDialog(
                        null,
                        "Seleccione un vuelo disponible:\n" + mensajeVuelos.toString(),
                        "Vuelos Disponibles",
                        0,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opcionesVuelos,
                        opcionesVuelos[0]);


                    Vuelo vueloSeleccionado = vuelosPublicos1.get(seleccion);
                    System.out.println(vueloSeleccionado.getIdentificador());//Comprobante de que se guardo los datos

                    //registrar pasajero------------------------
                    Pasajero pasajero = new Pasajero(null, null, null);

                    pasajero.registrarPasajero();
//-----------------------------------------------------------------------------------------------------------------

                    Vuelo.seleccionarAsiento(vueloSeleccionado);
                            
//-------------------------------------------------------------------------------------------------------------------

                    Vuelo.precio(vueloSeleccionado);

                } else if (seleccion == 1){
                    System.out.println("aeropuerto 2");
                    //Seleccionar un vuelo en el aeropuerto 2
                    StringBuilder mensajeVuelos = new StringBuilder();
                    for (Vuelo vuelo : vuelosPublicos2) {
                        mensajeVuelos.append(
                            "Vuelo " + vuelo.getIdentificador() +
                            " - Origen: " + vuelo.getCiudadOrigen() +
                            " - Destino: " + vuelo.getCiudadDestino() +
                            " - Precio: " + vuelo.getPrecio() + " USD\n");
                    }

                    String[] opcionesVuelos = new String[vuelosPublicos2.size()];
                    for (int i = 0; i < vuelosPublicos2.size(); i++) {
                        opcionesVuelos[i] = "Vuelo " + vuelosPublicos2.get(i).getIdentificador();
                    }

                    seleccion = JOptionPane.showOptionDialog(
                        null,
                        "Seleccione un vuelo disponible:\n" + mensajeVuelos.toString(),
                        "Vuelos Disponibles",
                        0,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opcionesVuelos,
                        opcionesVuelos[0]);

                    Vuelo vueloSeleccionado = vuelosPublicos2.get(seleccion);
                    System.out.println(vueloSeleccionado.getIdentificador());

                    //registrar pasajero------------------------
                    Pasajero pasajero = new Pasajero(null, null, null);

                    pasajero.registrarPasajero();
                    System.out.println(pasajero.getNombre());//Comprobante de que se guardo los datos
//-----------------------------------------------------------------------------------------------------------------

                    Vuelo.seleccionarAsiento(vueloSeleccionado);
                            
//-------------------------------------------------------------------------------------------------------------------

                    Vuelo.precio(vueloSeleccionado);
                    
                } else if (seleccion == 2) {
                    //Mostrar el aporte gubernamental
                    String[] opcionesAporteGubernamental = {
                        aeropuertoPublico1.getNombre(),
                        aeropuertoPublico2.getNombre()};

                    seleccion = JOptionPane.showOptionDialog(
                        null,
                        "Ver aporte gubernamental",
                        "Seleccionar aeropuerto",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionesAporteGubernamental,
                        opcionesAporteGubernamental[0]);

                    if (seleccion == 0) {
                        JOptionPane.showMessageDialog(null,
                            "Aporte gubernamental para " + aeropuertoPublico1.getNombre() +
                            ": " + aeropuertoPublico1.getAporteGubernamental());
                    } else if (seleccion == 1) {
                        JOptionPane.showMessageDialog(null,
                            "Aporte gubernamental para " + aeropuertoPublico2.getNombre() +
                            ": " + aeropuertoPublico2.getAporteGubernamental());
                    }
                }
                break;
            case 1:
                //seleccionar un aeropuerto privado
                String[] opcionesPrivadas = {
                    aeropuertoPrivado1.getNombre(),
                    aeropuertoPrivado2.getNombre(),
                    "Empresas patrocinadoras"};

                seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Elija el aeropuerto privado",
                    "Seleccionar aeropuerto privado",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesPrivadas,
                    opcionesPrivadas[0]);

                if (seleccion == 0) {
                    System.out.println("aeropuerto 1");
                    //seleccion de un vuelo
                    StringBuilder mensajeVuelos = new StringBuilder();
                    for (Vuelo vuelo : vuelosPrivados1) {
                        mensajeVuelos.append(
                            "Vuelo " + vuelo.getIdentificador() +
                            " - Origen: " + vuelo.getCiudadOrigen() +
                            " - Destino: " + vuelo.getCiudadDestino() +
                            " - Precio: " + vuelo.getPrecio() + " USD\n");
                    }

                    String[] opcionesVuelos = new String[vuelosPrivados1.size()];
                    for (int i = 0; i < vuelosPrivados1.size(); i++) {
                        opcionesVuelos[i] = "Vuelo " + vuelosPrivados1.get(i).getIdentificador();
                    }

                    seleccion = JOptionPane.showOptionDialog(
                        null,
                        "Seleccione un vuelo disponible:\n" + mensajeVuelos.toString(),
                        "Vuelos Disponibles",
                        0,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opcionesVuelos,
                        opcionesVuelos[0]);

                    Vuelo vueloSeleccionado = vuelosPrivados1.get(seleccion);
                    System.out.println(vueloSeleccionado.getIdentificador());//Comprobante de que se guardo los datos

                    //registrar pasajero------------------------
                    Pasajero pasajero = new Pasajero(null, null, null);

                    pasajero.registrarPasajero();
                    System.out.println(pasajero.getNombre());//Comprobante de que se guardo los datos
//-----------------------------------------------------------------------------------------------------------------

                    Vuelo.seleccionarAsiento(vueloSeleccionado);
                            
//-------------------------------------------------------------------------------------------------------------------

                    Vuelo.precio(vueloSeleccionado);

                } else if (seleccion == 1){
                    System.out.println("aeropuerto 2");
                    //Seleccion de un vuelo
                    StringBuilder mensajeVuelos = new StringBuilder();
                    for (Vuelo vuelo : vuelosPrivados2) {
                        mensajeVuelos.append(
                            "Vuelo " + vuelo.getIdentificador() +
                            " - Origen: " + vuelo.getCiudadOrigen() +
                            " - Destino: " + vuelo.getCiudadDestino() +
                            " - Precio: " + vuelo.getPrecio() + " USD\n");
                    }

                    String[] opcionesVuelos = new String[vuelosPrivados2.size()];
                    for (int i = 0; i < vuelosPrivados2.size(); i++) {
                        opcionesVuelos[i] = "Vuelo " + vuelosPrivados2.get(i).getIdentificador();
                    }

                    seleccion = JOptionPane.showOptionDialog(
                        null,
                        "Seleccione un vuelo disponible:\n" + mensajeVuelos.toString(),
                        "Vuelos Disponibles",
                        0,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opcionesVuelos,
                        opcionesVuelos[0]);

                    Vuelo vueloSeleccionado = vuelosPrivados2.get(seleccion);
                    System.out.println(vueloSeleccionado.getIdentificador());

                    //registrar pasajero------------------------
                    Pasajero pasajero = new Pasajero(null, null, null);

                    pasajero.registrarPasajero();
                    System.out.println(pasajero.getNombre());//Comprobante de que se guardo los datos
//-----------------------------------------------------------------------------------------------------------------

                    Vuelo.seleccionarAsiento(vueloSeleccionado);
                            
//-------------------------------------------------------------------------------------------------------------------

                    Vuelo.precio(vueloSeleccionado);
                    
                } else if (seleccion == 2) {
                    //Mostrar las empresas patrocinadoras 
                    String[] opcionesEmpresasPatrocinadoras = {
                        aeropuertoPrivado1.getNombre(),
                        aeropuertoPrivado2.getNombre()};

                    seleccion = JOptionPane.showOptionDialog(
                        null,
                        "Ver empresas patrocinadoras",
                        "Seleccionar aeropuerto",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcionesEmpresasPatrocinadoras,
                        opcionesEmpresasPatrocinadoras[0]);

                    if (seleccion == 0) {
                        JOptionPane.showMessageDialog(null,
                            "Empresas patrocinadoras para " + aeropuertoPrivado1.getNombre()
                            + ": " + aeropuertoPrivado1.getEmpresasPatrocinadoras());
                    } else if (seleccion == 1) {
                        JOptionPane.showMessageDialog(null,
                            "Empresas patrocinadoras para " + aeropuertoPrivado2.getNombre()
                            + ": " + aeropuertoPrivado2.getEmpresasPatrocinadoras());
                    }
                }
                break;
            }   
        } 
    }  
    

    
}


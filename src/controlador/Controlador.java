package controlador;
import java.util.ArrayList;
import java.util.Scanner;

import Militar.Soldados.Coronel;
import Militar.Soldados.Soldado;
import Militar.Soldados.SoldadoRaso;
import modelo.Tipo_soldado;
import modelo.modelo_gestion_militar;
import Vista.VistaTerminal;
public class Controlador {

    static modelo_gestion_militar modelo = new modelo_gestion_militar();
    
    public void inicializacion(VistaTerminal vista){
        //Uso de try-with-resources para gestionar el Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            byte salir_de_sistema = 0;
            while (salir_de_sistema != 1) {
                vista.mostrarMenuPrincipal();
                byte opcion = vista.leerOpcion(scanner);

                switch (opcion) {
                    case 1:
                        vista.crearSoldado(scanner, ObtenerListaSoldados() , modelo.getMayorID());
                        break;
                    case 2:
                        vista.modificarSoldado(scanner, ObtenerListaSoldados());
                        break;
                    case 3:
                        vista.mostrar(scanner);
                        break;
                    case 4:
                        vista.ejecutarSaludo(scanner, ObtenerListaSoldados());
                        break;
                    case 5:
                        vista.ejecutarPatrullamiento(scanner, ObtenerListaSoldados());
                        break;
                    case 6:
                        vista.ejecutarRegaño(scanner, ObtenerListaSoldados());
                         break;
                    case 7:
                        vista.ejecutarAccionDelSoldado(scanner, ObtenerListaSoldados());
                        break;
                    case 8: 
                        vista.ejecutarAsignarMision(scanner, ObtenerListaSoldados());
                        break;
                    case 9: 
                        vista.ejecutarReportarEstado(scanner, ObtenerListaSoldados());
                        break;
                    case 10:
                        System.out.println("\nOperación finalizada.");
                        salir_de_sistema = 1;
                        break;
                    default:
                        System.out.println("\nError: Por favor, digite una opción válida.\n");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

    public static ArrayList<Soldado> ObtenerListaSoldados() { 
        return modelo.getLista_soldados();
    }

    public static void AñadirListaSoldados(Soldado soldado) { 
        modelo.addSoldado(soldado);
    }

    public static void mostrarMayorID() { 
        System.out.println("El id mayor en la lista de soldados es " + modelo.getMayorID());
    }
    
    public static void mostrarInformacionSoldado(Soldado soldado) { 
        System.out.println("Informacion del soldado: " + modelo.mostrarSoldados(soldado)); 
    }

    public static void mostrarListaSoldados() { 
        ArrayList<Soldado> lista = modelo.getLista_soldados();
        for (Soldado soldado : lista) {
            mostrarInformacionSoldado(soldado);
        }
    }

    public static void mostrarListaSoldadospordefecto() { 
        ArrayList<Soldado> lista = modelo.getLista_soldados_defecto();
        for (Soldado soldado : lista) {
            mostrarInformacionSoldado(soldado);
        }
    }

    public static void mostrarObtenermayorID() { 
        System.out.println("El id mayor en la lista de soldados es " + modelo.OptenerIDmayor()); 
    }

    public static void mostrarIDincremental(String id) { 
        System.out.println("Nuevo ID: " + modelo.IdIncremental(id)); 
    }

    public static void mostrarImostrarSoldadoID(String id){ 
        System.out.println("Informacion del soldado buscado: " + modelo.mostrarSoldadoID(id));
    }

    public static void mostrarCrearInstanciaSoldado(Tipo_soldado tipo , String nombre, String id){ 
        Soldado soldado = modelo.crearInstanciaSoldado(tipo , nombre, id);
        System.out.println("Soldado creado: " + soldado);
        modelo.addSoldado(soldado);
    }

    public static void mostrarmostrarSoldados() { 
        ArrayList<String> lista = modelo.mostrarSoldados();
        for (String info : lista) {
          System.out.println(info);
        }
    }

    public static void mostrarmostrarSoldadosRango(Tipo_soldado rango) { 
        ArrayList<String> lista = modelo.mostrarSoldadosRango(rango);
        for (String info : lista) {
          System.out.println(info);
        }
    }

    public static void mostrarOptenerSoldado(String id){ 
        System.out.println("Soldado obtenido: " +  modelo.Optener_soldado(id));
    }

    public static void mostrarOptener_soldado_clase(Soldado soldado){ 
        System.out.println("Soldado obtenido: " +  modelo.Optener_soldado_Clase(soldado));
    }

    public static void mostrarSubirRango(Soldado soldado){
        if (soldado instanceof Coronel) {
            System.out.println("Un coronel no puede subir de rango, no se mostrara al coronel porque ya es uno");
        }
        else {
         System.out.println("Soldado subido de rango: " + modelo.subirRango(soldado));
        }
    }

    public static void mostrarbajarRango(Soldado soldado){
        if (soldado instanceof SoldadoRaso) {
            System.out.println("El soldado ha sido eliminado de la lista por su bajo rango");
            modelo.bajarRango(soldado);
        }
        else {
            System.out.println("Soldado bajado de rango: " + modelo.bajarRango(soldado));
        }
    }

    public static void mostrarObtener_mensaje_regaño(Soldado soldado){
        System.out.println("Regaño al soldado: " + modelo.Obtener_mensaje_regaño(soldado));
    }

    public static void mostrarObtener_mensaje_saludo(Soldado soldado){
        System.out.println("Saludo del soldado: " + modelo.Obtener_mensaje_de_saludo(soldado));
    }

    public static void mostrarObtener_mensaje_patrulla(Soldado soldado, boolean accion){
        System.out.println("Patrullamiento del soldado: " + modelo.obtener_mensaje_de_patrulla(soldado, accion));
    }

    public static void mostrarObtener_mensaje_realizar_accion(Soldado soldado){
        System.out.println("Accion del soldado: " + modelo.obtener_mensaje_realizar_accion(soldado));
    }

    public static void mostrarObtener_mensaje_asignar_mision(Soldado soldado, String mision){
        System.out.println("Mision asignada al soldado: " + modelo.mensaje_asignar_mision(soldado, mision));
    }

    public static void mostrarObtener_mensaje_reporte_estado(Soldado soldado){
        System.out.println("Reporte del soldado: " + modelo.reporte_de_estado(soldado));
    }
}
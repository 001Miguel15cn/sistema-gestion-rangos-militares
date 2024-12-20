package vista;

import java.util.ArrayList;
import java.util.Scanner;

import Militar.Soldados.Soldado;
import Militar.misiones.Misiones;
import controlador.Accion_rango;
import controlador.Controlador;
import controlador.Operacion;
import controlador.Tipo_soldado;

public class Gestion_militar_terminal implements Gestion_militar_interfaz{
    ArrayList<String> lista = new ArrayList<String>();
    //valores recibidos por la gui
    String id="";
    String NombreSoldado="";
    String Unidad="";
    int SoldadosBajoMando=0;
    String Estregia="";
    Misiones Mision;
    Tipo_soldado tipo_soldado;
    Accion_rango Accion_rango;
        
        // Método para mostrar el menú principal
        public void inializar(Controlador controlador) {
            System.out.println("Sistema de gestión de Soldados");
            System.out.println();
            System.out.println("1. Crear soldado");
            System.out.println("2. Modificar soldado");
            System.out.println("3. Visualizar soldados");
            System.out.println("4. Ejecutar saludo de un soldado");
            System.out.println("5. Ordenar a un soldado que patrulle");
            System.out.println("6. Regañar a un soldado");
            System.out.println("7. Ordenar a un soldado que realice su accion");
            System.out.println("8. Asignarle una mision a un soldado");
            System.out.println("9. Reportar el estado de un soldado");
            System.out.println("10. Salir");
            System.out.println();
            System.out.print("Ingrese una opción: ");
            Scanner scanner = new Scanner(System.in);    
            String opcion = scanner.next();
            String operacion = "";
            switch(opcion){
                case "1": 
                    pedirdatosCrearsoldado();
                    controlador.setOperacion(Operacion.CREAR_SOLDADO);
                    System.out.println("el "+tipo_soldado+" ha sido creado y almacenado");
                break;
                case "2": 
                    controlador.setOperacion(Operacion.MODIFICAR_SOLDADO);
                    mostrarMenuModificarSoldado();
                break;
                case "3": controlador.setOperacion(Operacion.MOSTRAR_INFORMACION);
                    mostrarmenuInformacion();
                break;
                case "4":  
                    System.out.println("Dame el ID:");
                    id = scanner.next();
                    controlador.setOperacion(Operacion.SALUDAR);
                break;
                case "5": 
                    System.out.println("Dame el ID:");
                    id = scanner.next();
                    controlador.setOperacion(Operacion.PATRULLAR);
                break;
                case "6": 
                    System.out.println("Dame el ID:");
                    id = scanner.next();
                    controlador.setOperacion(Operacion.REGAÑAR);
                break;
                case "7": 
                    System.out.println("Dame el ID:");
                    id = scanner.next();
                    controlador.setOperacion(Operacion.REALIZAR_ACCION);
                break;
                case "8": 
                    System.out.println("Dame el ID:");
                    id = scanner.next();
                    controlador.setOperacion(Operacion.ASIGNAR_MISION);
                break;
                case "9": 
                    System.out.println("Dame el ID:");
                    id = scanner.next();
                    controlador.setOperacion(Operacion.REPORTAR_ESTADO);
                break;
                case "10":
                    break;
                default:
                System.out.println("Opcion invalida");
            } 
        continuar(scanner, controlador);
    }
    
    @Override
    public String getID() {
        return id;
    }
    @Override
    public String getNombreSoldado() {
        return NombreSoldado;
    }
    @Override
    public String getUnidad() {
        return Unidad;
    }
    @Override
    public int getSoldadosBajoMando() {
       return SoldadosBajoMando;
    }
    @Override
    public String getEstregia() {
        return Estregia;
    }
    @Override
    public Misiones getMision() {
        return Mision;
    }
    @Override
    public Tipo_soldado getTipo_soldado() {
        return tipo_soldado;
    }
    @Override
    public Accion_rango getAccion_rango() {
        return Accion_rango;
    }
    public void mostrarMenuCrearSoldado() {
        System.out.println("\nSeleccione el rango del soldado");
        System.out.println();
        System.out.println("1. Soldado Raso");
        System.out.println("2. Teniente");
        System.out.println("3. Capitan");
        System.out.println("4. Coronel");
        System.out.println("5. Salir");
        System.out.println();
        System.out.print("Ingrese una opción: ");
    }

    public void mostrarmenuInformacion(){
        System.out.println("\nSeleccione una opcion");
        System.out.println();
        System.out.println("1. Mostrar Todos los soldados");
        System.out.println("2. Mostrar un Soldado por ID");
        System.out.println("3. Mostrar Soldados por Rango");
        System.out.println("4. Salir");
        System.out.println();
        System.out.print("Ingrese una opción: ");
    }

    public void mostrarMenuModificarSoldado() {
        System.out.println("Opciones de Modificación:");
        System.out.println("1. Modificar Nombre");
        System.out.println("2. Modificar Unidad");
        System.out.println("3. Modificar Estrategia (solo para coroneles)"); // Solo para ciertos rangos
        System.out.println("4. Modificar soldados Bajo mando (solo para Capitanes)");
        System.out.println("5. Modificar rango");
        System.out.println("6. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public void pedirdatosCrearsoldado(){
        Scanner scanner2 = new Scanner(System.in);

        mostrarMenuCrearSoldado();
        int opcion = scanner2.nextInt();
        switch (opcion) {
            case 1:
                tipo_soldado = Tipo_soldado.Soldado_raso;
                crearTipoSoldado(scanner2);
                break;
            case 2:
                tipo_soldado = Tipo_soldado.Teniente;
                crearTipoSoldado(scanner2);
                break;
            case 3:
                tipo_soldado = Tipo_soldado.Capitan;
                crearTipoSoldado(scanner2);
                break;
            case 4:
                tipo_soldado = Tipo_soldado.Coronel;
                crearTipoSoldado(scanner2);
                break;
            case 5:          
                break;
            default:
                System.out.println("\nError: Por favor, digite una opción válida.\n");
                break;
            }

    }

    // Método genérico para crear diferentes tipos de soldados
    public void crearTipoSoldado(Scanner scanner) {
        System.out.println("\nIngrese el nombre del " + tipo_soldado + ": ");
        NombreSoldado = scanner.next();
    }

    @Override
    public void mostrarInformacion(ArrayList<String> lista) {
        System.out.println("La informacion " + lista);
    }

    @Override
    public void mensajeMision(String misionmensaje) {
        
        throw new UnsupportedOperationException("Unimplemented method 'mensajeMision'");
    }

    @Override
    public void mensajeRealizaraccion(String accion) {
        
        throw new UnsupportedOperationException("Unimplemented method 'mensajeRealizaraccion'");
    }

    @Override
    public void mensajesaludar(String mensaje) {
        System.out.println("Mensaje de saludo" + mensaje);
    }

    @Override
    public ArrayList<String> getReporte() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getReporte'");
    }

    @Override
    public void mensajepatrullar(String mensaje) {
        System.out.println("Patrullamiento del soldado: " + mensaje);
    }

    @Override
    public void mensajeregaño(String mensaje) {
        System.out.println("Regaño del soldado: " + mensaje);
    }

    public void continuar(Scanner scanner, Controlador controlador) {
        System.out.print("¿Deseas continuar en el programa? (1 = Sí, 2 = No): ");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            inializar(controlador);
        } else if (opcion == 2) {
            System.out.println("Gracias por usar el programa, adiós");
        } else {
            System.out.println("Opción no válida. Por favor ingresa '1' para continuar o '2' para salir.");
            continuar(scanner, controlador);
        }
    }
    
}

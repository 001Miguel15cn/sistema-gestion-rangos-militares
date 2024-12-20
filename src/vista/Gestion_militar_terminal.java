package vista;

import Militar.misiones.Misiones;
import controlador.Accion_rango;
import controlador.Controlador;
import controlador.Mostrar_tipo_informacion;
import controlador.Operacion;
import controlador.Tipo_soldado;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestion_militar_terminal implements Gestion_militar_interfaz {
    private ArrayList<String> lista = new ArrayList<>();
    private String id = "";
    private String nombreSoldado = "";
    private String unidad = "";
    private int soldadosBajoMando = 0;
    private String estrategia = "";
    private Misiones mision;
    private Tipo_soldado tipo_soldado;
    private Accion_rango accionRango;
    private Controlador controlador;

    private Scanner scanner = new Scanner(System.in);

    public void inicializar(Controlador controlador) {
        this.controlador = controlador;
        boolean continuar = true;

        while (continuar) {
            System.out.println("Sistema de gestión de Soldados");
            System.out.println("\n1. Crear soldado");
            System.out.println("2. Modificar soldado");
            System.out.println("3. Visualizar soldados");
            System.out.println("4. Ejecutar saludo de un soldado");
            System.out.println("5. Ordenar a un soldado que patrulle");
            System.out.println("6. Regañar a un soldado");
            System.out.println("7. Ordenar a un soldado que realice su acción");
            System.out.println("8. Asignarle una misión a un soldado");
            System.out.println("9. Reportar el estado de un soldado");
            System.out.println("10. Salir\n");
            System.out.print("Ingrese una opción: ");
            String opcion = scanner.next();

            switch (opcion) {
                case "1":
                    pedirdatosCrearsoldado(scanner);
                    controlador.setOperacion(Operacion.CREAR_SOLDADO);
                    System.out.println("El " + tipo_soldado + " ha sido creado y almacenado");
                    break;
                case "2":
                    controlador.setOperacion(Operacion.MODIFICAR_SOLDADO);
                    mostrarMenuModificarSoldado();
                    break;
                case "3":
                    mostrarmenuInformacion();
                    controlador.setOperacion(Operacion.MOSTRAR_INFORMACION);
                    break;
                case "4":
                    solicitarID();
                    controlador.setOperacion(Operacion.SALUDAR);
                    break;
                case "5":
                    solicitarID();
                    controlador.setOperacion(Operacion.PATRULLAR);
                    break;
                case "6":
                    solicitarID();
                    controlador.setOperacion(Operacion.REGAÑAR);
                    break;
                case "7":
                    solicitarID();
                    controlador.setOperacion(Operacion.REALIZAR_ACCION);
                    break;
                case "8":
                    solicitarID();
                    controlador.setOperacion(Operacion.ASIGNAR_MISION);
                    break;
                case "9":
                    solicitarID();
                    controlador.setOperacion(Operacion.REPORTAR_ESTADO);
                    break;
                case "10":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
            controlador.actionPerformed(null);
            if (continuar) {
                continuar(scanner);
            } else {
                System.out.println("Gracias por usar el programa, adiós");
            }
        }
    }

    public void continuar(Scanner scanner) {
        System.out.println("¿Deseas continuar? (1 para sí, 2 para salir):");
        int opcion = scanner.nextInt();
        if (opcion != 1) {
            System.exit(0);
        }
    }

    public void solicitarID() {
        System.out.print("Dame el ID: ");
        id = scanner.next();
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getNombreSoldado() {
        return nombreSoldado;
    }

    @Override
    public String getUnidad() {
        return unidad;
    }

    @Override
    public int getSoldadosBajoMando() {
        return soldadosBajoMando;
    }

    @Override
    public String getEstregia() {
        return estrategia;
    }

    @Override
    public Misiones getMision() {
        return mision;
    }

    @Override
    public Tipo_soldado getTipo_soldado() {
        return tipo_soldado;
    }

    @Override
    public Accion_rango getAccion_rango() {
        return accionRango;
    }

    @Override
    public ArrayList<String> getReporte() {
        return lista;
    }

    @Override
    public void mostrarInformacion(ArrayList<String> lista) {
        for (String i : lista) {
            System.out.println(i);
        }
    }

    @Override
    public void mensajeMision(String misionmensaje) {
        System.out.println("Misión asignada: " + misionmensaje);
    }

    @Override
    public void mensajeRealizaraccion(String accion) {
        System.out.println("Acción realizada: " + accion);
    }

    @Override
    public void mensajesaludar(String mensaje) {
        System.out.println("Mensaje de saludo: " + mensaje);
    }

    @Override
    public void mensajepatrullar(String mensaje) {
        System.out.println("Patrullamiento del soldado: " + mensaje);
    }

    @Override
    public void mensajeregaño(String mensaje) {
        System.out.println("Regaño del soldado: " + mensaje);
    }

    public void mostrarMenuCrearSoldado() {
        System.out.println("\nSeleccione el rango del soldado");
        System.out.println("1. Soldado Raso\n2. Teniente\n3. Capitán\n4. Coronel\n5. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public void mostrarmenuInformacion() {
        System.out.println("\nSeleccione una opción");
        System.out.println("1. Mostrar Todos los soldados\n2. Mostrar un Soldado por ID\n3. Mostrar Soldados por Rango\n4. Salir");
        System.out.print("Ingrese una opción: ");
        String opcion = scanner.next();
        switch (opcion) {
            case "1":
                controlador.setTipo_informacion(Mostrar_tipo_informacion.TODO);
                break;
            case "2":
                solicitarID();
                controlador.setTipo_informacion(Mostrar_tipo_informacion.POR_ID);
                break;
            case "3":
                controlador.setTipo_informacion(Mostrar_tipo_informacion.POR_RANGO);
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    public void mostrarMenuModificarSoldado() {
        System.out.println("Opciones de Modificación:");
        System.out.println("1. Modificar Nombre\n2. Modificar Unidad\n3. Modificar Estrategia\n4. Modificar soldados Bajo mando\n5. Modificar rango\n6. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public void pedirdatosCrearsoldado(Scanner scanner) {
        mostrarMenuCrearSoldado();
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                tipo_soldado = Tipo_soldado.Soldado_raso;
                crearTipoSoldado(scanner);
                break;
            case 2:
                tipo_soldado = Tipo_soldado.Teniente;
                crearTipoSoldado(scanner);
                break;
            case 3:
                tipo_soldado = Tipo_soldado.Capitan;
                crearTipoSoldado(scanner);
                break;
            case 4:
                tipo_soldado = Tipo_soldado.Coronel;
                crearTipoSoldado(scanner);
                break;
            case 5:
                System.out.println("Saliendo del menú de creación.");
                break;
            default:
                System.out.println("Error: Por favor, digite una opción válida.");
        }
    }

    public void crearTipoSoldado(Scanner scanner) {
        System.out.print("\nIngrese el nombre del " + tipo_soldado + ": ");
        nombreSoldado = scanner.next();
        System.out.print("Ingrese la unidad del soldado: ");
        unidad = scanner.next();
        if (tipo_soldado == Tipo_soldado.Capitan || tipo_soldado == Tipo_soldado.Coronel) {
            System.out.print("Ingrese la estrategia del soldado: ");
            estrategia = scanner.next();
        }
        if (tipo_soldado == Tipo_soldado.Capitan) {
            System.out.print("Ingrese el número de soldados bajo su mando: ");
            soldadosBajoMando = scanner.nextInt();
        }
    }
}

package Vista;
import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;
import controlador.Controlador;
import interfaz_grafica.ReportarEstadoCapitan_Interfaz;
import interfaz_grafica.ReportarEstadoCoronel;
import interfaz_grafica.ReportarEstadoSoldadoRaso_Interfaz;
import interfaz_grafica.ReportarEstadoTeniente_Interfaz;
import interfaz_grafica.interfaz_principal;
import modelo.Tipo_soldado;
import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;
import Militar.Soldados.Soldado;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class VistaTerminal {
    private Controlador controlador;

    public VistaTerminal(Controlador controlador) {
        this.controlador = controlador;
    }
    
    // Método para mostrar el menú principal
    public void mostrarMenuPrincipal() {
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
    }


    // Método para leer la opción del usuario con manejo de excepciones
    public byte leerOpcion(Scanner scanner) {
        byte opcion = 0;
        try {
            opcion = scanner.nextByte();
        } catch (Exception e) {
            System.out.println("\nEntrada inválida. Por favor, ingrese un número válido.\n");
            scanner.nextLine(); // Limpiar el buffer
        }
        return opcion;
    }

    // Método para crear un nuevo soldado
    public String crearSoldado(Scanner scanner, ArrayList<Soldado> soldados, String mayorIDInicial) {
        byte salir1 = 0;
        String mayorID = mayorIDInicial;

        while (salir1 != 1) {
            mostrarMenuCrearSoldado();
            byte opcion2 = leerOpcion(scanner);

            switch (opcion2) {
                case 1:
                    mayorID = crearTipoSoldado(scanner, soldados, mayorID, Tipo_soldado.Soldado_raso);
                    break;
                case 2:
                    mayorID = crearTipoSoldado(scanner, soldados, mayorID, Tipo_soldado.Teniente);
                    break;
                case 3:
                    mayorID = crearTipoSoldado(scanner, soldados, mayorID, Tipo_soldado.Capitan);
                    break;
                case 4:
                    mayorID = crearTipoSoldado(scanner, soldados, mayorID, Tipo_soldado.Coronel);
                    break;
                case 5:
                    salir1 = 1;
                    break;
                default:
                    System.out.println("\nError: Por favor, digite una opción válida.\n");
                    break;
            }
        }

        return mayorID;
    }

    // Método para mostrar el menú de creación de soldados
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

    // Método genérico para crear diferentes tipos de soldados
    public String crearTipoSoldado(Scanner scanner, ArrayList<Soldado> soldados, String mayorID, Tipo_soldado tipo) {
        System.out.println("\nIngrese el nombre del " + tipo + ": ");
        String nombre = scanner.next();

        // Actualizar MayorID
        for (Soldado soldado : soldados) {
            String idActual = soldado.getId();
            if (idActual.compareTo(mayorID) > 0) {
                mayorID = idActual;
            }
        }

        int numeroID = Integer.parseInt(mayorID.substring(1));
        int nuevoID = numeroID + 1;
        String nuevoIDString = String.format("S%03d", nuevoID);

        System.out.println("Se añadirá el " + tipo + " " + nombre + ", con ID: " + nuevoIDString);
        System.out.println();
        System.out.println("1. Confirmar");
        System.out.println("2. Cancelar");
        System.out.print("Ingrese una opción: ");
        byte opcion3 = leerOpcion(scanner);

        switch (opcion3) {
            case 1:
                Controlador.mostrarCrearInstanciaSoldado(tipo, nombre, nuevoIDString);
                break;
            case 2:
                System.out.println("\nNo se añadió el " + tipo + ".\n");
                break;
            default:
                System.out.println("\nOpción inválida. Volviendo al menú anterior.\n");
                break;
        }

        return mayorID;
    }

    // Meotdo para mostrar soldados total, por ID y Rango
    public void mostrar(Scanner scanner){
        byte salir1 = 0;
        while(salir1 != 1){
        System.out.println("\nSeleccione una opcion");
        System.out.println();
        System.out.println("1. Mostrar Todos los soldados");
        System.out.println("2. Mostrar un Soldado por ID");
        System.out.println("3. Mostrar Soldados por Rango");
        System.out.println("4. Salir");
        System.out.println();
        System.out.print("Ingrese una opción: ");
        byte opcion = scanner.nextByte();
        switch (opcion) {
            case 1:
                Controlador.mostrarmostrarSoldados();
                break;

            case 2:
                mostrarSoldadosID(scanner);
                
                break;
            case 3:
                mostrarSoldadosRango(scanner);
                break;
            case 4:
                salir1 = 1;
                break;
        
            default:
                break;
        }




        }
    }


    public void subirBajarRango(Scanner scanner, Soldado soldado) {
        System.out.println("\nSeleccione la opción de rango:");
        System.out.println("1. Subir rango");
        System.out.println("2. Bajar rango");
        byte opcion = scanner.nextByte();

        if (opcion == 1) {
            Controlador.mostrarSubirRango(soldado);
        } else if (opcion == 2) {
            Controlador.mostrarbajarRango(soldado);
        } else {
            System.out.println("Opción inválida.");
        }
    }

    // Método para mostrar la lista de soldados
    public void mostrarSoldados() {
        System.out.println("\nLista de Soldados:");
        Controlador.mostrarmostrarSoldados();
        System.out.println();
    }
    //Método Mostrar soldado por ID
    public void mostrarSoldadosID(Scanner scanner) {
       
        System.out.println("Ingrese el ID del soldado: ");
        String id = scanner.next();
        Controlador.mostrarImostrarSoldadoID(id);
    }
    //Metodo Mostrar por Rango
    public void mostrarSoldadosRango(Scanner scanner) {
       
        byte salir1 = 0;
        while(salir1 != 1){
        System.out.println();
        System.out.println("1. Soldado Raso");
        System.out.println("2. Teniente");
        System.out.println("3. Capitan");
        System.out.println("4. Coronel");
        System.out.println("5. Salir");
        System.out.println();
        System.out.println("Ingrese una opcion: ");
        byte opcion = scanner.nextByte();

        switch (opcion) {
            case 1:
                Controlador.mostrarmostrarSoldadosRango(Tipo_soldado.Soldado_raso);
                break;
            case 2:
                Controlador.mostrarmostrarSoldadosRango(Tipo_soldado.Teniente);
                break;
            case 3:
                Controlador.mostrarmostrarSoldadosRango(Tipo_soldado.Capitan);
                break;
            case 4:
                Controlador.mostrarmostrarSoldadosRango(Tipo_soldado.Coronel);
                break;
            default:
                break;
        }
    }
    }
   


    // Método para modificar un soldado existente
    public void modificarSoldado(Scanner scanner, ArrayList<Soldado> soldados) {
        if (soldados.isEmpty()) {
            System.out.println("\nNo hay soldados registrados para modificar.\n");
            return;
        }

        System.out.println("\nLista de Soldados:");
        for (Soldado soldado : soldados) {
            soldado.mostrarInformacion();
        }
        System.out.println();

        System.out.print("Ingrese el ID del soldado que desea modificar: ");
        String idBuscado = scanner.next();

        Soldado soldadoAModificar = null;
        for (Soldado soldado : soldados) {
            if (soldado.getId().equalsIgnoreCase(idBuscado)) {
                soldadoAModificar = soldado;
                break;
            }
        }

        if (soldadoAModificar == null) {
            System.out.println("\nSoldado con ID " + idBuscado + " no encontrado.\n");
            return;
        }

        boolean salir = false;
        while (!salir) {
            mostrarMenuModificarSoldado();
            byte opcionMod = leerOpcion(scanner);

            switch (opcionMod) {
                case 1:
                    System.out.print("\nIngrese el nuevo nombre: ");
                    String nuevoNombre = scanner.next();
                    soldadoAModificar.setNombre(nuevoNombre);
                    System.out.println("Nombre actualizado exitosamente.\n");
                    break;
                case 2:
                    System.out.print("\nIngrese la nueva unidad: ");
                    String nuevaUnidad = scanner.next();
                    if (soldadoAModificar instanceof SoldadoRaso) {
                        SoldadoRaso soldadoAmodificar2 = (SoldadoRaso) soldadoAModificar;
                        soldadoAmodificar2.setUnidad(nuevaUnidad);  
    
                    }
                    if (soldadoAModificar instanceof Teniente) {
                        Teniente soldadoAmodificar2 = (Teniente) soldadoAModificar;
                        soldadoAmodificar2.setUnidad(nuevaUnidad);  
    
                    }
                    if (soldadoAModificar instanceof Capitan) {
                        Capitan soldadoAmodificar2 = (Capitan) soldadoAModificar;
                        soldadoAmodificar2.setUnidad(nuevaUnidad);  
    
                    }
                    if (soldadoAModificar instanceof Coronel) {
                        Coronel soldadoAmodificar2 = (Coronel) soldadoAModificar;
                        soldadoAmodificar2.setUnidad(nuevaUnidad);  
    
                    }
                   
                    
                    System.out.println("Unidad actualizada exitosamente.\n");
                    break;


                case 3:
                    // Solo para Capitanes y Coroneles
                    if (soldadoAModificar instanceof Coronel) {
                        System.out.print("\nIngrese la nueva estrategia: ");
                        String nuevaEstrategia = scanner.next();
                        ((Coronel) soldadoAModificar).setEstrategia(nuevaEstrategia);
                        System.out.println("Estrategia actualizada exitosamente.\n");
                    } else if (soldadoAModificar instanceof Capitan) {
                        // Si Capitan tiene estrategias, adaptarlo. Si no, puedes omitir o adaptar según tu clase
                        System.out.println("\nCapitanes no tienen atributo 'estrategia' para modificar.\n");
                    } else {
                        System.out.println("\nEste soldado no tiene atributo 'estrategia' para modificar.\n");
                    }
                    break;
                case 4:
                   

                    if(soldadoAModificar instanceof Capitan) {
                        System.out.println("");
                        System.out.print("\nIngrese la nueva cantidad de soldados: ");
                        int mando = scanner.nextInt();
                        Capitan soldadoAmodificar2 = (Capitan) soldadoAModificar;
                        soldadoAmodificar2.setSoldadosBajoMando(mando);
                    }
                    else{
                        System.out.println("");
                        System.out.println("el soldado que intenta modificar no es un Capitan");
                        System.out.println("");
                    }
                    break;
                case 5:
                    subirBajarRango(scanner, soldadoAModificar);
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("\nOpción inválida. Por favor, seleccione una opción válida.\n");
                    break;
            }
        }

        System.out.println("Soldado modificado exitosamente:\n" + soldadoAModificar + "\n");
    }

    // Método para mostrar el menú de modificación de soldados
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

    // metodo para ejecutar el saludo de un soldado

    public void ejecutarSaludo(Scanner scanner, ArrayList<Soldado> soldados){
        Integer soldadoEncontrado = 0;
        System.out.print("Digite el ID del soldado que quiere que realice su saludo: ");
        String idSoldadoABuscar = scanner.next();
        System.out.println("");
        for(Soldado i:soldados){
            String idDelSoldado = i.getId();
            if(idDelSoldado.equals(idSoldadoABuscar)){
                Controlador.mostrarObtener_mensaje_reporte_estado(i);
                soldadoEncontrado += 1;
            }
        }
        if(soldadoEncontrado==0){
            System.out.println("El soldado con el id " + idSoldadoABuscar + " no existe");
        }
    }

    // metodo para ejecutar la forma de patrullar de un soldado

    public void ejecutarPatrullamiento(Scanner scanner, ArrayList<Soldado> soldados){
        Integer soldadoEncontrado = 0;
        System.out.print("Digite el ID del soldado que quiere que patrulle: ");
        String idSoldadoABuscar = scanner.next();
        System.out.println("");
        for(Soldado i:soldados){
            String idDelSoldado = i.getId();
            if(idDelSoldado.equals(idSoldadoABuscar)){
                Controlador.mostrarObtener_mensaje_patrulla(i, true);
                soldadoEncontrado += 1;
            }
        }
        if(soldadoEncontrado==0){
            System.out.println("El soldado con el id " + idSoldadoABuscar + " no existe");
        }
    }

    // metodo para ejecutar el regaño a un soldado

    public void ejecutarRegaño(Scanner scanner, ArrayList<Soldado> soldados){
        Integer soldadoEncontrado = 0;
        System.out.print("Digite el ID del soldado que quiere regañar: ");
        String idSoldadoABuscar = scanner.next();
        System.out.println("");
        for(Soldado i:soldados){
            String idDelSoldado = i.getId();
            if(idDelSoldado.equals(idSoldadoABuscar)){
                Controlador.mostrarObtener_mensaje_regaño(i);
                soldadoEncontrado += 1;
            }
        }
        if(soldadoEncontrado==0){
            System.out.println("El soldado con el id " + idSoldadoABuscar + " no existe");
        }
    }

    //metodo para ejecutar la accion de un soldado

    public void ejecutarAccionDelSoldado(Scanner scanner, ArrayList<Soldado> soldados){
        Integer soldadoEncontrado = 0;
        System.out.print("Digite el ID del soldado que quiere que realice su accion: ");
        String idSoldadoABuscar = scanner.next();
        System.out.println("");
        for(Soldado i:soldados){
            String idDelSoldado = i.getId();
            if(idDelSoldado.equals(idSoldadoABuscar)){
                Controlador.mostrarObtener_mensaje_realizar_accion(i);
                soldadoEncontrado += 1;
            }
        }
        if(soldadoEncontrado==0){
            System.out.println("El soldado con el id " + idSoldadoABuscar + " no existe");
        }
    }

    // metodo para asignarle una mision al soldado

    public void ejecutarAsignarMision(Scanner scanner, ArrayList<Soldado> soldados){
        Integer soldadoEncontrado = 0;
        System.out.print("Digite el ID del soldado que quiere asignarle una mision: ");
        String idSoldadoABuscar = scanner.next();
        System.out.println("");
        System.out.print("Digite la mision que desea asignarle al soldado: ");
        String mision = scanner.next();
        System.out.println("");
        for(Soldado i:soldados){
            String idDelSoldado = i.getId();
            if(idDelSoldado.equals(idSoldadoABuscar)){
                Controlador.mostrarObtener_mensaje_asignar_mision(i, mision);
                soldadoEncontrado += 1;
            }
        }
        if(soldadoEncontrado==0){
            System.out.println("El soldado con el id " + idSoldadoABuscar + " no existe");
        }
    }

    // metodo para reportar estado de un soldado

    public void ejecutarReportarEstado(Scanner scanner, ArrayList<Soldado> soldados){
        Integer soldadoEncontrado = 0;
        System.out.print("Digite el ID del soldado que quiere que reporte su estado: ");
        String idSoldadoABuscar = scanner.next();
        System.out.println("");
        for(Soldado i:soldados){
            String idDelSoldado = i.getId();
            if(idDelSoldado.equals(idSoldadoABuscar)){
                Controlador.mostrarObtener_mensaje_reporte_estado(i);
        }
        if(soldadoEncontrado==0){
            System.out.println("El soldado con el id " + idSoldadoABuscar + " no existe");
        }
        }
    }
}
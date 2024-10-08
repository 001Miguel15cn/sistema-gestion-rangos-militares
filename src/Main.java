import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;
import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;
import Militar.Soldados.Soldado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        SoldadoRaso soldado1 = new SoldadoRaso("Juan", "S001");
        SoldadoRaso soldado2 = new SoldadoRaso("Roberto", "S004");
        SoldadoRaso soldado3 = new SoldadoRaso("Albaro", "S005");
        Teniente teniente1 = new Teniente("Camilo", "S002");
        Capitan capitan1 = new Capitan("Miguel", "S003");
        Coronel coronel1 = new Coronel("Andrea", "S000");
        
        // Configuración de unidades y estrategias
        capitan1.setUnidad("Comando2");
        teniente1.setUnidad("Milicia del sur");
        soldado1.setUnidad("Milicia del sur");
        coronel1.setEstrategia("proteger una region clave");

        // Lista de soldados
        ArrayList<Soldado> soldados = new ArrayList<>();
        soldados.add(soldado1);
        soldados.add(soldado2);
        soldados.add(soldado3);
        soldados.add(teniente1);
        soldados.add(capitan1);
        soldados.add(coronel1);

        String mayorID = "S000";

        // Uso de try-with-resources para gestionar el Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            byte salir_de_sistema = 0;
            while (salir_de_sistema != 1) {
                mostrarMenuPrincipal();
                byte opcion = leerOpcion(scanner);

                switch (opcion) {
                    case 1:
                        mayorID = crearSoldado(scanner, soldados, mayorID);
                        break;
                    case 2:
                        modificarSoldado(scanner, soldados);
                        break;
                    case 3:
                        mostrar(scanner,soldados);
                        break;
                    case 4:
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

    // Método para mostrar el menú principal
    private static void mostrarMenuPrincipal() {
        System.out.println("Sistema de gestión de Soldados");
        System.out.println();
        System.out.println("1. Crear soldado");
        System.out.println("2. Modificar soldado");
        System.out.println("3. Visualizar soldados");
        System.out.println("4. Salir");
        System.out.println();
        System.out.print("Ingrese una opción: ");
    }

    // Método para leer la opción del usuario con manejo de excepciones
    private static byte leerOpcion(Scanner scanner) {
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
    private static String crearSoldado(Scanner scanner, ArrayList<Soldado> soldados, String mayorIDInicial) {
        byte salir1 = 0;
        String mayorID = mayorIDInicial;

        while (salir1 != 1) {
            mostrarMenuCrearSoldado();
            byte opcion2 = leerOpcion(scanner);

            switch (opcion2) {
                case 1:
                    mayorID = crearTipoSoldado(scanner, soldados, mayorID, "Soldado Raso");
                    break;
                case 2:
                    mayorID = crearTipoSoldado(scanner, soldados, mayorID, "Teniente");
                    break;
                case 3:
                    mayorID = crearTipoSoldado(scanner, soldados, mayorID, "Capitan");
                    break;
                case 4:
                    mayorID = crearTipoSoldado(scanner, soldados, mayorID, "Coronel");
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
    private static void mostrarMenuCrearSoldado() {
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
    private static String crearTipoSoldado(Scanner scanner, ArrayList<Soldado> soldados, String mayorID, String tipo) {
        System.out.println("\nIngrese el nombre del " + tipo.toLowerCase() + ": ");
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

        System.out.println("Se añadirá el " + tipo.toLowerCase() + " " + nombre + ", con ID: " + nuevoIDString);
        System.out.println();
        System.out.println("1. Confirmar");
        System.out.println("2. Cancelar");
        System.out.print("Ingrese una opción: ");
        byte opcion3 = leerOpcion(scanner);

        switch (opcion3) {
            case 1:
                Soldado soldadoNuevo = crearInstanciaSoldado(tipo, nombre, nuevoIDString);
                if (soldadoNuevo != null) {
                    soldados.add(soldadoNuevo);
                    System.out.println("\nEl " + tipo.toLowerCase() + " se añadió exitosamente.\n");
                }
                break;
            case 2:
                System.out.println("\nNo se añadió el " + tipo.toLowerCase() + ".\n");
                break;
            default:
                System.out.println("\nOpción inválida. Volviendo al menú anterior.\n");
                break;
        }

        return mayorID;
    }

    // Método para crear una instancia de soldado según el tipo
    private static Soldado crearInstanciaSoldado(String tipo, String nombre, String id) {
        switch (tipo) {
            case "Soldado Raso":
                return new SoldadoRaso(nombre, id);
            case "Teniente":
                return new Teniente(nombre, id);
            case "Capitan":
                return new Capitan(nombre, id);
            case "Coronel":
                return new Coronel(nombre, id);
            default:
                System.out.println("Tipo de soldado desconocido.");
                return null;
        }
    }
    // Meotdo para mostrar soldados total, por ID y Rango
    private static void mostrar(Scanner scanner, ArrayList<Soldado> soldados){
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
                mostrarSoldados(soldados);
                
                break;

            case 2:
                mostrarSoldadosID(scanner,soldados);
                
                break;
            case 3:
                mostrarSoldadosRango(scanner,soldados);
                break;
            case 4:
                salir1 = 1;
                break;
        
            default:
                break;
        }




        }
    }





    // Método para mostrar la lista de soldados
    private static void mostrarSoldados(ArrayList<Soldado> soldados) {
        if (soldados.isEmpty()) {
            System.out.println("\nNo hay soldados registrados.\n");
            return;
        }

        System.out.println("\nLista de Soldados:");
        for (Soldado soldado : soldados) {
            soldado.mostrarInformacion();
        }
        System.out.println();
    }
    //Método Mostrar soldado por ID
    private static void mostrarSoldadosID(Scanner scanner, ArrayList<Soldado> soldados) {
       
        int count = 0;
        System.out.println("Ingrese el ID del soldado: ");
        String ID = scanner.next();

        if (soldados.isEmpty()) {
            System.out.println("\nNo hay soldados registrados.\n");
            return;
        }

        System.out.println("\nLista de Soldados:");
        for (Soldado soldado : soldados) {
            if (ID.equals(soldado.getId())){
                soldado.mostrarInformacion();}
            else{
                count++;
                continue;
            }
        }
        if (count == soldados.size()){
            System.out.println("\n Error ID incorrecto.\n");
        }
        System.out.println();
    }
    //Metodo Mostrar por Rango
    private static void mostrarSoldadosRango(Scanner scanner, ArrayList<Soldado> soldados) {
       
        int count = 0;
        byte salir1 = 0;
        int cantidad = 0;
        boolean entry = false;
        String Rango = "";
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
                Rango = "Soldado Raso";
                entry = true;
                break;
            case 2:
                Rango = "Teniente";
                entry = true;
                break;
            case 3:
                Rango = "Capitan";
                entry = true;
                break;
            case 4:
                Rango = "Coronel";
                entry = true;
                break;
            case 5:
                salir1 = 1;
                entry = false;
                break;
        
            default:
                break;
        }
        
        if (entry) {
            
        boolean control = true;
        if (soldados.isEmpty()) {
            System.out.println("\nNo hay soldados registrados.\n");
            return;
        }

        System.out.println("\nLista de Soldados:");
        for (Soldado soldado : soldados) {
            if (Rango.equals(soldado.getRango())){
                soldado.mostrarInformacion();

                if (control){
                    if (soldado instanceof SoldadoRaso) {
                    SoldadoRaso new1 = (SoldadoRaso) soldado;
                    cantidad = new1.cantidad;  

                    }
               
                 if (soldado instanceof Teniente) {
                     Teniente new1 = (Teniente) soldado;
                      cantidad = new1.cantidad;  

                    }
                    if (soldado instanceof Capitan) {
                     Capitan new1 = (Capitan) soldado;
                    cantidad = new1.cantidad;  

                }
                    if (soldado instanceof Coronel) {
                      Coronel new1 = (Coronel) soldado;
                     cantidad = new1.cantidad;  

                    }
                control = false;
            }
               
        }

            
            else{
                count++;
                continue;
            }

        }
        
        if (count == soldados.size()){
            System.out.println("\n Error Rango incorrecto.\n");
        }
        System.out.println("\n Cantidad de soldados:" + cantidad +"\n");
        System.out.println();
            }
        }
    }
   


    // Método para modificar un soldado existente
    private static void modificarSoldado(Scanner scanner, ArrayList<Soldado> soldados) {
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
    private static void mostrarMenuModificarSoldado() {
        System.out.println("Opciones de Modificación:");
        System.out.println("1. Modificar Nombre");
        System.out.println("2. Modificar Unidad");
        System.out.println("3. Modificar Estrategia"); // Solo para ciertos rangos
        System.out.println("4. Modificar soldados Bajo mando (solo para Capitanes)");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
    }
}

import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;
import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;
import Militar.Soldados.Soldado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int ultimoID = 5;  // Inicia en el siguiente número disponible después del último soldado creado.

    public static void main(String[] args) {
        SoldadoRaso soldado1 = new SoldadoRaso("Juan", "S001");
        SoldadoRaso soldado2 = new SoldadoRaso("Roberto", "S004");
        SoldadoRaso soldado3 = new SoldadoRaso("Albaro", "S005");
        Teniente teniente1 = new Teniente("Camilo", "S002");
        Capitan capitan1 = new Capitan("Miguel", "S003");
        Coronel coronel1 = new Coronel("Andrea", "S000");

        capitan1.setUnidad("Comando2");
        teniente1.setUnidad("Milicia del sur");
        soldado1.setUnidad("Milicia del sur");
        coronel1.setEstrategia("proteger una región clave");

        ArrayList<Soldado> soldados = new ArrayList<>();
        soldados.add(soldado1);
        soldados.add(soldado2);
        soldados.add(soldado3);
        soldados.add(teniente1);
        soldados.add(capitan1);
        soldados.add(coronel1);

        try (Scanner scanner = new Scanner(System.in)) {
            byte salirDeSistema = 0;
            while (salirDeSistema != 1) {
                mostrarMenuPrincipal();
                byte opcion = leerOpcion(scanner);

                switch (opcion) {
                    case 1:
                        crearSoldado(scanner, soldados);
                        break;
                    case 2:
                        modificarSoldado(scanner, soldados);
                        break;
                    case 3:
                        mostrarSoldados(soldados);
                        break;
                    case 4:
                        System.out.println("\nOperación finalizada.");
                        salirDeSistema = 1;
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

    private static void mostrarMenuPrincipal() {
        System.out.println("\n---- MENÚ PRINCIPAL ----");
        System.out.println("1. Crear Soldado");
        System.out.println("2. Modificar Soldado");
        System.out.println("3. Mostrar Soldados");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static byte leerOpcion(Scanner scanner) {
        return scanner.nextByte();
    }

    private static void crearSoldado(Scanner scanner, ArrayList<Soldado> soldados) {
        System.out.print("Ingrese el nombre del nuevo soldado: ");
        String nombre = scanner.next();
        String nuevoID = generarNuevoID();

        SoldadoRaso nuevoSoldado = new SoldadoRaso(nombre, nuevoID);
        soldados.add(nuevoSoldado);
        System.out.println("Soldado " + nombre + " creado con ID " + nuevoID);
    }

    private static String generarNuevoID() {
        ultimoID++;
        return "S" + String.format("%03d", ultimoID);
    }

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
                    soldadoAModificar.setUnidad(nuevaUnidad);
                    System.out.println("Unidad actualizada exitosamente.\n");
                    break;
                case 3:
                    subirBajarRango(scanner, soldadoAModificar, soldados);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("\nOpción inválida.\n");
                    break;
            }
        }
    }

    private static void mostrarMenuModificarSoldado() {
        System.out.println("\n---- MODIFICAR SOLDADO ----");
        System.out.println("1. Cambiar nombre");
        System.out.println("2. Cambiar unidad");
        System.out.println("3. Cambiar rango");
        System.out.println("4. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    private static void subirBajarRango(Scanner scanner, Soldado soldado, ArrayList<Soldado> soldados) {
        System.out.println("\nSeleccione la opción de rango:");
        System.out.println("1. Subir rango");
        System.out.println("2. Bajar rango");
        byte opcion = scanner.nextByte();
        Soldado nuevoSoldado = null;

        if (opcion == 1) {
            nuevoSoldado = subirRango(soldado);
            if (nuevoSoldado != null) {
                soldados.set(soldados.indexOf(soldado), nuevoSoldado);
                System.out.println("Rango subido con éxito.");
            }
        } else if (opcion == 2) {
            nuevoSoldado = bajarRango(soldado);
            if (nuevoSoldado != null) {
                soldados.set(soldados.indexOf(soldado), nuevoSoldado);
                System.out.println("Rango bajado con éxito.");
            }
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private static Soldado subirRango(Soldado soldado) {
        if (soldado instanceof SoldadoRaso) {
            return new Teniente(soldado.getNombre(), soldado.getId());
        } else if (soldado instanceof Teniente) {
            return new Capitan(soldado.getNombre(), soldado.getId());
        } else if (soldado instanceof Capitan) {
            return new Coronel(soldado.getNombre(), soldado.getId());
        } else {
            System.out.println("El Coronel no puede subir de rango.");
            return null;
        }
    }

    private static Soldado bajarRango(Soldado soldado) {
        if (soldado instanceof Coronel) {
            return new Capitan(soldado.getNombre(), soldado.getId());
        } else if (soldado instanceof Capitan) {
            return new Teniente(soldado.getNombre(), soldado.getId());
        } else if (soldado instanceof Teniente) {
            return new SoldadoRaso(soldado.getNombre(), soldado.getId());
        } else {
            System.out.println("El Soldado Raso no puede bajar de rango.");
            return null;
        }
    }

    private static void mostrarSoldados(ArrayList<Soldado> soldados) {
        if (soldados.isEmpty()) {
            System.out.println("No hay soldados registrados.");
        } else {
            System.out.println("\nLista de soldados:");
            for (Soldado soldado : soldados) {
                soldado.mostrarInformacion();
            }
        }
    }
}

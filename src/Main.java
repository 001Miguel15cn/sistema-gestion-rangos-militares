import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;
import VistaTerminal.VistaTerminal;
import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;
import Militar.Soldados.Soldado;
import java.util.ArrayList;
import java.util.Scanner;
import interfaz_grafica.interfaz_principal;

public class Main {
    static ArrayList<Soldado> soldados = new ArrayList<>();
       
    public static void main(String[] args) {

        VistaTerminal vistaTerminal = new VistaTerminal();

        interfaz_principal interfaz = new interfaz_principal();
        interfaz.setVisible(true);

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
       
        soldados.add(soldado1);
        soldados.add(soldado2);
        soldados.add(soldado3);
        soldados.add(teniente1);
        soldados.add(capitan1);
        soldados.add(coronel1);
        interfaz.setListaSoldados(soldados);
        interfaz.setListaSoldadosDefecto(soldados);
        interfaz.update();
        String mayorID = "S000";

        // Uso de try-with-resources para gestionar el Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            byte salir_de_sistema = 0;
            while (salir_de_sistema != 1) {
                vistaTerminal.mostrarMenuPrincipal();
                byte opcion = vistaTerminal.leerOpcion(scanner);

                switch (opcion) {
                    case 1:
                        mayorID = vistaTerminal.crearSoldado(scanner, soldados, mayorID);
                        break;
                    case 2:
                        vistaTerminal.modificarSoldado(scanner, soldados);
                        break;
                    case 3:
                        vistaTerminal.mostrar(scanner,soldados);
                        break;
	                case 4:
                        vistaTerminal.ejecutarSaludo(scanner, soldados);
		                break;
	                case 5:
                        vistaTerminal.ejecutarPatrullamiento(scanner, soldados);
		                break;
	                case 6:
                        vistaTerminal.ejecutarRegaño(scanner, soldados);
		                 break;
	                case 7:
                        vistaTerminal.ejecutarAccionDelSoldado(scanner, soldados);
		                break;
	                case 8: 
                        vistaTerminal.ejecutarAsignarMision(scanner, soldados);
                        break;
	                case 9: 
                        vistaTerminal.ejecutarReportarEstado(scanner, soldados);
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
}

    
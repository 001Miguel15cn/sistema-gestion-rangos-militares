
import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;

import java.util.ArrayList;
import java.util.Scanner;

import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;
import Militar.Soldados.Soldado;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //soldados por defecto del el ArrayList
        SoldadoRaso soldado1 = new SoldadoRaso("Juan", "S001");
        Teniente teniente1 = new Teniente("Camilo","S002" );
        Capitan capitan1 = new Capitan("Miguel", "S003");
        Coronel coronel1 = new Coronel("Andrea", "S000");
        ArrayList <Soldado> soldados = new ArrayList<Soldado>();
        soldados.add(soldado1);
        soldados.add(teniente1);
        soldados.add(capitan1);
        soldados.add(coronel1);
        byte salir_de_sistema = 0;
        Scanner scanner = new Scanner(System.in);
        while (salir_de_sistema != 1){

        System.out.println("Sistema de gestion de Soldados");
        System.out.println("");
        System.out.println("crear soldado: 1");
        System.out.println("");
        System.out.println("modificar soldado: 2");
        System.out.println("");
        System.out.println("vizualizar soldado: 3");
        System.out.println("");
        System.out.println("salir: 4");
        System.out.println("");
        System.out.print("ingrese una opcion: ");
        byte opcion =  scanner.nextByte();

        switch (opcion) {
            case 1:
                //crear soldado
                break;
            case 2:
                //modificar soldado
                break;
            case 3:
                //mostrar soldado
                break;
    
            case 4:
                System.out.println("");
                System.out.println("operacion finalizada");
                salir_de_sistema = 1;
                break;
        
            default:
                System.out.println("");
                System.out.println("error digite una opcion valida");
                break;
           
         } 
        if (salir_de_sistema == 0){   
        System.out.println("");         
        System.out.println("Presiona una tecla para continuar...");
        scanner.nextLine(); // Espera hasta que el usuario presione una tecla
        }

        }




       /*  System.out.println("Acciones en curso:");
        soldado1.realizarAccion();
        teniente1.realizarAccion();
        capitan1.realizarAccion();
        coronel1.realizarAccion();

        coronel1.asignarMision();
        capitan1.asignarMision();

        coronel1.reportarEstado();
        capitan1.reportarEstado(); */
    }
}

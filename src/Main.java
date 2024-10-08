
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
        SoldadoRaso soldado2 = new SoldadoRaso("robeto", "S004");
        SoldadoRaso soldado3 = new SoldadoRaso("albaro", "S005");
        Teniente teniente1 = new Teniente("Camilo","S002" );
        Capitan capitan1 = new Capitan("Miguel", "S003");
        Coronel coronel1 = new Coronel("Andrea", "S000");
        capitan1.setUnidad("Comando2");
        teniente1.setUnidad("Milicia del sur");
        soldado1.setUnidad("Milicia del sur");
        coronel1.setEstrategia("proteger una region clave");
    
        ArrayList <Soldado> soldados = new ArrayList<Soldado>();
        soldados.add(soldado1);
        soldados.add(soldado2);
        soldados.add(soldado3);
        soldados.add(teniente1);
        soldados.add(capitan1);
        soldados.add(coronel1);
        String MayorID = "S000";


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
            // inicio crear soldado
            case 1:
                    
                    byte salir1 = 0;
                    while (salir1 != 1){
                     System.out.println("");
                     System.out.println("Selecione el rango del soldado");
                     System.out.println("");
                     System.out.println("Soldado Raso: 1");
                     System.out.println("");
                     System.out.println("Teniente: 2");
                     System.out.println("");
                     System.out.println("Capitan: 3");
                     System.out.println("");
                     System.out.println("Coronel: 4");
                     System.out.println("");
                     System.out.println("salir: 5");
                     System.out.println("");
                     System.out.print("ingrese una opcion: ");
                     byte opcion2 =  scanner.nextByte();
                    //crear soldado raso
                     switch (opcion2) {
                        case 1:
                        System.out.println("");
                        System.out.println("Ingrese el nombre del soldado: ");
                        System.out.println("");
                        String nombre = scanner.next();

                        for (Soldado soldado : soldados) {
                            String idActual = soldado.getId();
                
                            // Comparar los IDs directamente
                            if (idActual.compareTo(MayorID) > 0) {
                                MayorID = idActual; // Actualizar MayorID
                            }
                        }

                        int numeroID = Integer.parseInt(MayorID.substring(1));
                        int nuevoID = numeroID +1;
                        String nuevoIDString = String.format("S%03d", nuevoID);
                     
    
                        System.out.println("se añadira el Soldado Raso " + nombre + ", con ID: " + nuevoIDString +"");
                        System.out.println("");
                        System.out.println("confirmar: 1");
                        System.out.println("");
                        System.out.println("cancelar: 2");
                        byte opcion3 = scanner.nextByte();

                        switch (opcion3) {
                            case 1:
                                SoldadoRaso soldadonuevo = new SoldadoRaso(nombre,nuevoIDString);
                                soldados.add(soldadonuevo);
                                System.out.println("");
                                System.out.println("el soldado se añadio exitosamente");
                                System.out.println("");
                                salir1 = 1;
                                break;

                            case 2:
                               
                                System.out.println("");
                                System.out.println("no se añadio el soldado");
                                System.out.println("");
                                salir1 = 1;
                                break;
                        
                            default:
                                break;
                        }

                        
                            
                            break;
                        //final de crear soldado raso

                        //inicio de crear teniente
                        case 2:
                        System.out.println("");
                        System.out.println("Ingrese el nombre del teniente: ");
                        System.out.println("");
                        String nombre2 = scanner.next();

                        for (Soldado soldado : soldados) {
                            String idActual = soldado.getId();
                
                            // Comparar los IDs directamente
                            if (idActual.compareTo(MayorID) > 0) {
                                MayorID = idActual; // Actualizar MayorID
                            }
                        }

                        int numeroID2 = Integer.parseInt(MayorID.substring(1));
                        int nuevoID2 = numeroID2 +1;
                        String nuevoIDString2 = String.format("S%03d", nuevoID2);
                     
    
                        System.out.println("se añadira el teniente " + nombre2 + ", con ID: " + nuevoIDString2 +"");
                        System.out.println("");
                        System.out.println("confirmar: 1");
                        System.out.println("");
                        System.out.println("cancelar: 2");
                        byte opcion4 = scanner.nextByte();

                        switch (opcion4) {
                            case 1:
                                Teniente soldadonuevo2 = new Teniente(nombre2,nuevoIDString2);
                                soldados.add(soldadonuevo2);
                                System.out.println("");
                                System.out.println("el teniente se añadio exitosamente");
                                System.out.println("");
                                salir1 = 1;
                                break;

                            case 2:
                               
                                System.out.println("");
                                System.out.println("no se añadio el teniente");
                                System.out.println("");
                                salir1 = 1;
                                break;
                        
                            default:
                                break;
                        }

                            break;

                        //final de crear teniente

                        //inicio de crear capitan

                        case 3:
                        System.out.println("");
                        System.out.println("Ingrese el nombre del Capitan: ");
                        System.out.println("");
                        String nombre3 = scanner.next();

                        for (Soldado soldado : soldados) {
                            String idActual = soldado.getId();
                
                            // Comparar los IDs directamente
                            if (idActual.compareTo(MayorID) > 0) {
                                MayorID = idActual; // Actualizar MayorID
                            }
                        }

                        int numeroID3 = Integer.parseInt(MayorID.substring(1));
                        int nuevoID3 = numeroID3 +1;
                        String nuevoIDString3 = String.format("S%03d", nuevoID3);
                     
    
                        System.out.println("se añadira el capitan " + nombre3 + ", con ID: " + nuevoIDString3 +"");
                        System.out.println("");
                        System.out.println("confirmar: 1");
                        System.out.println("");
                        System.out.println("cancelar: 2");
                        byte opcion5 = scanner.nextByte();

                        switch (opcion5) {
                            case 1:
                                Capitan soldadonuevo3 = new Capitan(nombre3,nuevoIDString3);
                                soldados.add(soldadonuevo3);
                                System.out.println("");
                                System.out.println("el capitan se añadio exitosamente");
                                System.out.println("");
                                salir1 = 1;
                                break;

                            case 2:
                               
                                System.out.println("");
                                System.out.println("no se añadio el capitan");
                                System.out.println("");
                                salir1 = 1;
                                break;
                        
                            default:
                                break;
                        }
                            
                            break; 

                        //final de crear capitan
                        //crear Coronel
                        case 4:
                        System.out.println("");
                        System.out.println("Ingrese el nombre del Coronel: ");
                        System.out.println("");
                        String nombre4 = scanner.next();

                        for (Soldado soldado : soldados) {
                            String idActual = soldado.getId();
                
                            // Comparar los IDs directamente
                            if (idActual.compareTo(MayorID) > 0) {
                                MayorID = idActual; // Actualizar MayorID
                            }
                        }

                        int numeroID4 = Integer.parseInt(MayorID.substring(1));
                        int nuevoID4 = numeroID4 +1;
                        String nuevoIDString4 = String.format("S%03d", nuevoID4);
                     
    
                        System.out.println("se añadira el Coronel " + nombre4 + ", con ID: " + nuevoIDString4 +"");
                        System.out.println("");
                        System.out.println("confirmar: 1");
                        System.out.println("");
                        System.out.println("cancelar: 2");
                        byte opcion6 = scanner.nextByte();

                        switch (opcion6) {
                            case 1:
                                Coronel soldadonuevo4 = new Coronel(nombre4,nuevoIDString4);
                                soldados.add(soldadonuevo4);
                                System.out.println("");
                                System.out.println("el Coronel se añadio exitosamente");
                                System.out.println("");
                                salir1 = 1;
                                break;

                            case 2:
                               
                                System.out.println("");
                                System.out.println("no se añadio el Coronel");
                                System.out.println("");
                                salir1 = 1;
                                break;
                        
                            default:
                                break;
                        }
                        
                            
                            break;
                        //final de crear coronel
                        case 5:
                            salir1 = 1;
                            break;
                    
                        default:
                            break;
                        
                    }
                    
                }

                // fin de crear soldado
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
        /*if (salir_de_sistema == 0){   
        System.out.println("");         
        System.out.println("Presiona una tecla para continuar...");
        scanner.nextLine(); // Espera hasta que el usuario presione una tecla
        }*/

        }

    }
}

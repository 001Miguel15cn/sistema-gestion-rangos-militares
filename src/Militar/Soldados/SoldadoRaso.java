package Militar.Soldados;

import java.util.ArrayList;

import Militar.misiones.Misiones;
import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;
import Militar.misiones.Misiones;

public class SoldadoRaso extends Soldado implements OperacionesMilitares{
    SoldadoRaso_rango rango = new SoldadoRaso_rango(); 
    public static int cantidad = 0;
    
    public SoldadoRaso(String nombre, String id) {
        super(nombre,"SoldadoRaso",id);
        setRango("Soldado Raso");
        cantidad++;
    }


    
    @Override
    public String toString() {
        return "Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
                + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]";
    }

    public void setUnidad(String unidad){
        rango.setUnidad(unidad);

        }

    public String realizarAccion(){
            return rango.realizarAccion();
        }

    @Override
        public String patrullar(boolean accionar) {
            String mensaje = "";
            if (accionar){
                mensaje = "El soldado raso" + super.getNombre() +" toma su rifle y se lanza al campo de batalla a realizar un reconocimiento";
            }
            if (!accionar){
                mensaje = "El soldado raso " + super.getNombre() + " ha detenido su patrulla.";
            }
            return mensaje;
    
    }

    @Override
    public String saludar() {
        // Se inicializa una variable para el saludo
        String saludo = "";  
        // comprueba si el soldado raso tiene un nombre definido y si no esta vacio este parametro
            if (getNombre() != null && !getNombre().isEmpty()) {
                // Convertir el nombre a minúsculas para evitar problemas con mayúsculas/minúsculas
                String nombreEnMinusula = getNombre().toLowerCase();
                // Obtener la primera y última letra
                char primeraLetra = nombreEnMinusula.charAt(0);
                char ultimaLetra = nombreEnMinusula.charAt(nombreEnMinusula.length() - 1);
                // Comparar si la primera y la última letra son iguales
                if (primeraLetra == ultimaLetra) {
                    saludo = "El soldado raso " + getNombre() + " se pone en postura y hace una señal de respeto";
                } else {
                saludo = "El soldado raso " + getNombre() + " olvido ponerle el seguro a su arma y se disparo al pie mientras intentaba hacer su rutina de saludo";
                }
            } else {
                saludo = "El soldado raso no tiene un nombre definido";
            }
        return saludo;  // Se retorna el saludo como un String
    }

    @Override
    //retorna un mensaje de expulsion
    public String regañado() {
        return "El soldado raso " + getNombre() + " ha sido expulsado debido a su mal desempeño en su labor";
    }

    private class SoldadoRaso_rango extends rango{
        int nivel;
        String unidad;
        public SoldadoRaso_rango() {
            this.nivel = 1;
            this.unidad = "sin unidad";
        }
        
        @Override
        public void setNivel(int nivel) {
            
                this.nivel = nivel;
        }
        @Override
        public void setUnidad(String unidad) {
            
                this.unidad = unidad;

        }
        @Override
        public int getNivel() {
            
            return nivel;
        }
        @Override
        public String getUnidad() {
            
            return unidad;
        }

        

        @Override
        public String realizarAccion() {
          return "El soldado" + getNombre() + " con código " + getId() + " está cumpliendo órdenes con determinación.";
        }
       
    }
    /* 
    @Override
    public String asignarMision(Misiones mision){
        return "el soldado Raso ha recibido la mision de: " + mision;
    }
    */
    
    @Override
    public String mostrarInformacion(){
         //System.out.println("");
        // System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
               // + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]");

         return "Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
                + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]";
         
    }

    @Override
    public ArrayList<String> reportarEstado() {
        ArrayList<String> reporte = new ArrayList<String>();
        
        reporte.add("El " + getRango() + " " + getNombre() + " con código " + getId() + " reporta: ");
        reporte.add(" -Estado de tarea asignada");
        reporte.add(" -condiciones del entorno");
        reporte.add(" -necesidad de suministros");
        reporte.add(" -observaciones");
        reporte.add(" -proximidad del enemigo");

        return reporte;
    }
    
    public static void remove(){
        cantidad --;
    }



    @Override
    public String asignarMision(Misiones mision){
        return "el soldado Raso ha recibido la mision de: " + mision;
    }
  
}

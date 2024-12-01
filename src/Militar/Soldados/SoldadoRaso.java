package Militar.Soldados;

import java.util.ArrayList;

import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;

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
    public String patrullar() {
        // Imprime la forma de patrullar del soldado raso
        System.out.println("El soldado raso toma su rifle y se lanza al campo de batalla a realizar un reconocimiento");
        return "El soldado raso toma su rifle y se lanza al campo de batalla a realizar un reconocimiento";
        
    }

    @Override
    public void saludar() {
        // comprueba si el soldado razo tiene un nombre definido y si no esta vacio este parametro
        if (getNombre() != null && !getNombre().isEmpty()) {
            // Convertir el nombre a minúsculas para evitar problemas con mayúsculas/minúsculas
            String nombreEnMinusula = getNombre().toLowerCase();
            // Obtener la primera y última letra
            char primeraLetra = nombreEnMinusula.charAt(0);
            char ultimaLetra = nombreEnMinusula.charAt(nombreEnMinusula.length() - 1);
            // Comparar si la primera y la última letra son iguales
            if (primeraLetra == ultimaLetra) {
                System.out.println("El soldado raso " + getNombre() + " se pone en postura y hace una señal de respeto");
            } else {
                System.out.println("El soldado raso " + getNombre() + " olvido ponerle el seguro a su arma y se disparo al pie mientras intentaba hacer su rutina de saludo");
            }
        } else {
            System.out.println("El soldado raso no tiene un nombre definido");
        }       
    }

    @Override
    public String regañado(ArrayList<Soldado> soldados) {
            // El soldado razo sera expulsado directamente ya que no puede bajar más de rango
            System.out.println("El soldado raso " + getNombre() + " ha sido expulsado debido a su mal desempeño en su labor");
            soldados.remove(this); // Es eliminado de la lista
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

    @Override
    public String mostrarInformacion(){
         //System.out.println("");
        // System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
               // + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]");

         return "Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
                + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]";
         
    }

    @Override
    public void asignarMision() {
        System.out.println("");
        System.out.println("se ha asignado una mision al soldado Raso");;
    }

    @Override
    public void reportarEstado() {
        System.out.println("");
        System.out.println("El " + getRango() + " " + getNombre() + " con código " + getId() + " reporta: ");
        System.out.println("");
        System.out.println(" -Estado de tarea asignada");
        System.out.println("");
        System.out.println(" -condiciones del entorno");
        System.out.println("");
        System.out.println(" -necesidad de suministros");
        System.out.println("");
        System.out.println(" -observaciones");
        System.out.println("");
        System.out.println(" -proximidad del enemigo");
        
    }
}
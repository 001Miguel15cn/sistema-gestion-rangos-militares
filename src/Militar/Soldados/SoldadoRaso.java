package Militar.Soldados;

import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;

public class SoldadoRaso extends Soldado implements OperacionesMilitares{
    SoldadoRaso_rango rango = new SoldadoRaso_rango(); 
    
    public SoldadoRaso(String nombre, String id) {
        super(nombre, id);
        setRango("Soldado Raso");
    }

    @Override
    public String toString() {
        return "Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
                + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]";
    }

    public void setUnidad(String unidad){
        rango.setUnidad(unidad);

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
            // TODO Auto-generated method stub
                this.nivel = nivel;
        }
        @Override
        public void setUnidad(String unidad) {
            // TODO Auto-generated method stub
                this.unidad = unidad;

        }
        @Override
        public int getNivel() {
            // TODO Auto-generated method stub
            return nivel;
        }
        @Override
        public String getUnidad() {
            // TODO Auto-generated method stub
            return unidad;
        }

        

        @Override
        public void realizarAccion() {
            System.out.println("");
            System.out.println("El soldado" + getNombre() + " con código " + getId() + " está cumpliendo órdenes con determinación.");
        }
       
    }

    @Override
    public void mostrarInformacion(){
         System.out.println("");
         System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
                + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]");
         
         
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
        System.out.println(" -informe de tareas diarias");
        System.out.println("");
        System.out.println(" -condiciones del entorno");
        System.out.println("");
        System.out.println(" -necesidad de suministros");
        System.out.println("");
        System.out.println(" -observaciones");
        
    }
}
package Militar.Soldados;

import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;

public class Coronel extends Soldado implements OperacionesMilitares {

    public static int cantidad = 0;
    private Coronel_rango rango = new Coronel_rango();

    public Coronel(String nombre, String id) {
        super(nombre, id);
        setRango("Coronel");
        cantidad++;
    }

  
     public void setUnidad(String unidad){
        rango.setUnidad(unidad);
         }

    public void setEstrategia(String estrategia){
        rango.setEstrategia(estrategia);
    }
    public void realizarAccion(){
        rango.realizarAccion();
    }


    private class Coronel_rango extends rango{
        int nivel;
        String unidad;
        public Coronel_rango() {
            this.nivel = 4;
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
        public String getEstrategia() {
            // TODO Auto-generated method stub
            return super.getEstrategia();
        }

        @Override
        public void setEstrategia(String estrategia) {
            // TODO Auto-generated method stub
            super.setEstrategia(estrategia);
        }

        @Override
        public void realizarAccion() {
            if (estrategia == "sin estrategia"){
                System.out.println("");
                System.out.println("El Coronel " + getNombre() + "aun no ha establecido una estrategia");
            }
            else{
            System.out.println("");
            System.out.println("El Coronel " + getNombre() + " está estableciendo la estrategia: " + estrategia);
       }
            
        }
    }









    ///este debe ser cambiando por realizar accion
    public void mostrarInformacion() {
        System.out.println("");
        System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
               + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]");
      
    }

    // Implementación de los métodos de la interfaz
   
    @Override
    public void asignarMision() {
        System.out.println("El Coronel " + getNombre() + " asigna una misión estratégica.");
    }

    @Override
    public void reportarEstado() {
        System.out.println("");
        System.out.println("El " + getRango() + " " + getNombre() + " con código " + getId() + " reporta: ");
        System.out.println("");
        System.out.println(" -Estrategias y operaciones a nivel regional");
        System.out.println("");
        System.out.println(" -informe de inteligencia y análisis de la situación global");
        System.out.println("");
        System.out.println(" -Estado general de la unidad bajo su mando");
        System.out.println("");
        System.out.println(" -Gestión de recursos a gran escala");
        System.out.println("");
        System.out.println(" -Evaluación de objetivos de misión a largo plazo");
        System.out.println("");
        System.out.println(" -Supervisión de capitanes de unidades grandes");
    }

    @Override
    public String toString() {
        return "Coronel [estrategia=" + rango.getEstrategia() + "]";
    }

    


}




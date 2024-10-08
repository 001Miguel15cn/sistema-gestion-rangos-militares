package Militar.Soldados;

import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;

public class Capitan extends Soldado implements OperacionesMilitares {
    private int soldadosBajoMando;
    Capitan_rango rango = new Capitan_rango();
    public static int cantidad = 0;

    public Capitan(String nombre, String id) {
        super(nombre, id);
        //un capitan por defecto tiene 50 soldados bajo su mando
        this.soldadosBajoMando = 50;
        setRango("Capitan");
        cantidad++;
    }

    

    @Override
    //este debe ser cambiado por reportar informacion
    public void mostrarInformacion() {
        System.out.println("");
        System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
        + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + ", Comanda: "+ soldadosBajoMando + " soldados"+ "]");

       
        System.out.println("Tiene " + soldadosBajoMando + " soldados bajo su mando.");
    }
    public void setUnidad(String unidad){
        rango.setUnidad(unidad);
         }
         
     public void realizarAccion(){
            rango.realizarAccion();
        }


    private class Capitan_rango extends rango{
        int nivel;
        String unidad;
        public Capitan_rango() {
            this.nivel = 3;
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
            System.out.println("El Capitán " + getNombre() + " coordina misiones y lidera estrategias.");
       
    }

    @Override
    public String toString() {
        System.out.println("");
        return "Capitan [soldadosBajoMando=" + soldadosBajoMando + "]";
    }
    
}

    @Override
    public void asignarMision() {
        // TODO Auto-generated method stub
        System.out.println("");
        System.out.println("El Capitán " + getNombre() + " asigna una misión táctica.");
    }

    @Override
    public void reportarEstado() {
        // TODO Auto-generated method stub
        System.out.println("");
        System.out.println("El " + getRango() + " " + getNombre() + " con código " + getId() + " reporta: ");
        System.out.println("");
        System.out.println(" -informe de tareas diarias");
        System.out.println("");
        System.out.println(" -Supervision de tenientes");
        System.out.println("");
        System.out.println(" -Estado general de la unidad bajo su mando");
        System.out.println("");
        System.out.println(" -Planificacion de misiones a corto plazo");
        System.out.println("");
        System.out.println(" -Evaluacion de riesgos y oportunidades estrategicas");
        System.out.println("");
        System.out.println(" -Coordinacion entre diferentes unidades");
        System.out.println("");
        System.out.println(" -Condiciones tácticas locales");

        


    }
}

package Militar.Soldados;
import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;

public class Teniente extends Soldado implements OperacionesMilitares{
    Teniente_rango rango = new Teniente_rango();
    public static int cantidad = 0;

    
    //crear un teniente sin unidad
    public Teniente(String nombre, String id) {
        super(nombre, id); // Llamada explícita al constructor de Soldado
        setRango("Teniente");
        cantidad++;
        
        
    }    
    public void setUnidad(String unidad){
        rango.setUnidad(unidad);
         }
  
    public void realizarAccion(){
            rango.realizarAccion();
        }


    private class Teniente_rango extends rango{
        int nivel;
        String unidad;
        public Teniente_rango() {
            this.nivel = 2;
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
        public void realizarAccion() {
            System.out.println("");
            System.out.println("El Teniente" + getNombre() + " con código " + getId() + " coordina a los soldados y supervisa las operaciones.");
       
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
        System.out.println("se ha asignado una mision al Teniente");;
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
        System.out.println(" -supervision de Soldados Rasos");
        System.out.println("");
        System.out.println(" -observaciones");
        System.out.println("");
        System.out.println(" -Condiciones tácticas locales");
        System.out.println("");
        System.out.println(" -Necesidad de refuerzos o equipo adicional");
    }



}

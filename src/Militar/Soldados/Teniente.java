package Militar.Soldados;
import java.util.ArrayList;

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

    @Override
    public void patrullar() {
        // Imprime la forma de patrullar del teniente
        System.out.println("El teniente llama a su unidad y realizan una operacion especial para reconocer los enemigos en el terreno");
    }

    @Override
    public void saludar() {
        // comprueba si el teniente tiene un nombre definido y si no esta vacio este parametro
        if (getNombre() != null && !getNombre().isEmpty()) {
            // Convertir el nombre a minúsculas para evitar problemas con mayúsculas/minúsculas
            String nombreEnMinusula = getNombre().toLowerCase();
            // Obtener la primera y última letra
            char primeraLetra = nombreEnMinusula.charAt(0);
            char ultimaLetra = nombreEnMinusula.charAt(nombreEnMinusula.length() - 1);
            // Comparar si la primera y la última letra son iguales
            if (primeraLetra == ultimaLetra) {
                System.out.println("El teniente " + getNombre() + " hace un canto junto a su unidad para darle la bienvenida");
            } else {
                System.out.println("El teniente " + getNombre() + " desafino a la hora de cantar y toda su unidad se rie de el arruinando el saludo");
            }
        } else {
            System.out.println("El teniente no tiene un nombre definido");
        }       
    }

    @Override
    public void regañado(ArrayList<Soldado> soldados) {
        if (rango.getNivel() > 1) {
            // Si el nivel es mayor que 1, se disminuye el nivel
            rango.setNivel(rango.getNivel() - 1);
            System.out.println("El teniente " + getNombre() + " ha sido regañado. Su nivel de rango ha bajado a " + rango.getNivel());
        } else if (rango.getNivel() == 1) {
            // Si el nivel es 1, es expulsado
            System.out.println("El teniente " + getNombre() + " ha sido expulsado debido a su bajo nivel de rango.");
            soldados.remove(this); // Es eliminado de la lista
        }
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

package Militar.Soldados;
import java.util.ArrayList;

import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;
import Militar.misiones.*;

public class Teniente extends Soldado implements OperacionesMilitares{
    Teniente_rango rango = new Teniente_rango();
    public static int cantidad = 0;

    
    //crear un teniente sin unidad
    public Teniente(String nombre, String id) {
        super(nombre,"Teniente",id); // Llamada explícita al constructor de Soldado
        setRango("Teniente");
        cantidad++;
        
        
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
            mensaje = "El teniente" + super.getNombre() + "se pone un traje de camuflaje y se adelanta al campo de combate para realizar una operacion especial para reconocer los enemigos en el terreno";
        }
        if (!accionar){
            mensaje = "El teniente " + super.getNombre() + " ha detenido su patrulla.";
        }
        return mensaje;

    }

    @Override
    public String saludar() {
        // Se inicializa una variable para el saludo
        String saludo = "";
        // comprueba si el teniente tiene un nombre definido y si no esta vacio este parametro
            if (getNombre() != null && !getNombre().isEmpty()) {
                // Convertir el nombre a minúsculas para evitar problemas con mayúsculas/minúsculas
                String nombreEnMinusula = getNombre().toLowerCase();
                // Obtener la primera y última letra
                char primeraLetra = nombreEnMinusula.charAt(0);
                char ultimaLetra = nombreEnMinusula.charAt(nombreEnMinusula.length() - 1);
                // Comparar si la primera y la última letra son iguales
                    if (primeraLetra == ultimaLetra) {
                        saludo = "El teniente " + getNombre() + " hace un canto junto a su unidad para darle la bienvenida";
                }    else {
                        saludo = "El teniente " + getNombre() + " desafinó a la hora de cantar y toda su unidad se ríe de él arruinando el saludo";
                    }
            } else {
                saludo = "El teniente no tiene un nombre definido";
            }
        return saludo;  // Se retorna el saludo como un String
    }

    @Override
    //retorna un mensaje de regaño
    public String regañado() {
        return "Ahora el teniente " + getNombre() + " es un soldado raso debido a su mal desempeño en su labor";
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
        public String realizarAccion() {
            return "El Teniente" + getNombre() + " con código " + getId() + " coordina a los soldados y supervisa las operaciones.";
       
    }


  
}

    @Override
    public String mostrarInformacion(){
        //System.out.println("");
       // System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
        //    + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]");
        return "Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
            + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]";
    }

    @Override
    public String asignarMision(Misiones mision) {
        String misionAsignada = "El teniente " + getNombre() + " ha sido asignado a la mision " + mision;
        return misionAsignada;
    }

    @Override
    public ArrayList<String> reportarEstado() {
        ArrayList<String> reporte = new ArrayList<String>();
        reporte.add("El " + getRango() + " " + getNombre() + " con código " + getId() + " reporta: ");
        reporte.add(" -informe de tareas diarias");
        reporte.add(" -condiciones del entorno");
        reporte.add(" -supervision de Soldados Rasos");
        reporte.add(" -observaciones");
        reporte.add(" -Condiciones tácticas locales");
        reporte.add(" -Necesidad de refuerzos o equipo adicional");
        return reporte;
    }

    

    public static void remove(){
        cantidad --;
    }


}

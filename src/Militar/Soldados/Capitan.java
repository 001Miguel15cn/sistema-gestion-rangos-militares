package Militar.Soldados;

import java.util.ArrayList;

import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;

public class Capitan extends Soldado implements OperacionesMilitares {
    private int soldadosBajoMando;
    Capitan_rango rango = new Capitan_rango();
    public static int cantidad = 0;

    public Capitan(String nombre, String id) {
        super(nombre, id);
        this.soldadosBajoMando = 0;
        setRango("Capitan");
        cantidad++;
    }
    

    public int getSoldadosBajoMando() {
        return soldadosBajoMando;
    }


    public void setSoldadosBajoMando(int soldadosBajoMando) {
        this.soldadosBajoMando = soldadosBajoMando;
    }


    @Override
    //este debe ser cambiado por reportar informacion
    public void mostrarInformacion() {
        System.out.println("");
        System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
        + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + ", Comanda: "+ soldadosBajoMando + " soldados"+ "]");

    }

    @Override
    public void patrullar() {
        // Imprime la forma de patrullar del capitan
        System.out.println("El capitan saca unos vinoculares y reconoce el terreno");
    }

    @Override
    public void saludar() {
        // comprueba si el capitan tiene un nombre definido y si no esta vacio este parametro
        if (getNombre() != null && !getNombre().isEmpty()) {
            // Convertir el nombre a minúsculas para evitar problemas con mayúsculas/minúsculas
            String nombreEnMinusula = getNombre().toLowerCase();
            // Obtener la primera y última letra
            char primeraLetra = nombreEnMinusula.charAt(0);
            char ultimaLetra = nombreEnMinusula.charAt(nombreEnMinusula.length() - 1);
            // Comparar si la primera y la última letra son iguales
            if (primeraLetra == ultimaLetra) {
                System.out.println("El capitan " + getNombre() + " hace una voltereta en el aire y atrapa sus binoculares con la boca y luego te saluda con el pie");
            } else {
                System.out.println("El capitan " + getNombre() + " intenta hacer una voltereta pero se cae y se rompe la espalda, te saluda con una carta desde el hospital");
            }
        } else {
            System.out.println("El capitan no tiene un nombre definido");
        }       
    }

    @Override
    public void regañado(ArrayList<Soldado> soldados) {
        if (rango.getNivel() > 1) {
            // Si el nivel es mayor que 1, se disminuye el nivel
            rango.setNivel(rango.getNivel() - 1);
            System.out.println("El capitan " + getNombre() + " ha sido regañado. Su nivel de rango ha bajado a " + rango.getNivel());
        } else if (rango.getNivel() == 1) {
            // Si el nivel es 1, es expulsado
            System.out.println("El capitan " + getNombre() + " ha sido expulsado debido a su bajo nivel de rango.");
            soldados.remove(this); // Es eliminado de la lista
        }
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
        
        System.out.println("");
        System.out.println("El Capitán " + getNombre() + " asigna una misión táctica.");
    }

    @Override
    public void reportarEstado() {
       
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

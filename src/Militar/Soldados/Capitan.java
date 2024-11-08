package Militar.Soldados;

import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;

public class Capitan extends Soldado implements OperacionesMilitares {
    private int soldadosBajoMando;
    CapitanRango rango = new CapitanRango();
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
    public void mostrarInformacion() {
        System.out.println("");
        System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
        + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + ", Comanda: "+ soldadosBajoMando + " soldados"+ "]");
    }

    public void setUnidad(String unidad){
        rango.setUnidad(unidad);
    }

    public void realizarAccion(){
        rango.realizarAccion();
    }

    private class CapitanRango extends rango {
        int nivel;
        String unidad;

        public CapitanRango() {
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
        System.out.println(" - Informe de tareas diarias");
        System.out.println(" - Supervisión de tenientes");
        System.out.println(" - Estado general de la unidad bajo su mando");
        System.out.println(" - Planificación de misiones a corto plazo");
        System.out.println(" - Evaluación de riesgos y oportunidades estratégicas");
        System.out.println(" - Coordinación entre diferentes unidades");
        System.out.println(" - Condiciones tácticas locales");
    }
}

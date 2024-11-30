package Militar.Soldados;

import java.util.ArrayList;
import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;

public class Capitan extends Soldado implements OperacionesMilitares {
    private int soldadosBajoMando;
    private Capitan_rango rango = new Capitan_rango(); // Relación con la clase interna Capitan_rango
    public static int cantidad = 0;

    // Constructor de Capitan
    public Capitan(String nombre, String id) {
        super(nombre,"Capitan",id);  // Ahora pasamos el rango al constructor de Soldado
        this.soldadosBajoMando = 0;
        cantidad++;
    }

    // Métodos Getters y Setters
    public int getSoldadosBajoMando() {
        return soldadosBajoMando;
    }

    public void setSoldadosBajoMando(int soldadosBajoMando) {
        this.soldadosBajoMando = soldadosBajoMando;
    }

    // Método sobrescrito para mostrar la información
    @Override
    public String mostrarInformacion() {
       // System.out.println("");
        //System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
        //        + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad()
         //       + ", Comanda: " + soldadosBajoMando + " soldados]");
        return "Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
                + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad()
                + ", Comanda: " + soldadosBajoMando + " soldados]";
    }

    // Método sobrescrito para patrullaje
    @Override
    public void patrullar() {
        System.out.println("El capitan saca unos binoculares y reconoce el terreno.");
    }

    // Método sobrescrito para saludar
    @Override
    public void saludar() {
        if (getNombre() != null && !getNombre().isEmpty()) {
            String nombreEnMinuscula = getNombre().toLowerCase();
            char primeraLetra = nombreEnMinuscula.charAt(0);
            char ultimaLetra = nombreEnMinuscula.charAt(nombreEnMinuscula.length() - 1);
            if (primeraLetra == ultimaLetra) {
                System.out.println("El capitan " + getNombre() + " hace una voltereta en el aire y atrapa sus binoculares con la boca y luego te saluda con el pie.");
            } else {
                System.out.println("El capitan " + getNombre() + " intenta hacer una voltereta pero se cae y se rompe la espalda, te saluda con una carta desde el hospital.");
            }
        } else {
            System.out.println("El capitan no tiene un nombre definido.");
        }
    }

    // Método sobrescrito para regañar
    @Override
    public void regañado(ArrayList<Soldado> soldados) {
        System.out.println("El capitan " + getNombre() + " ha sido bajado de rango a teniente debido a su mal desempeño en su labor.");
        Teniente soldadoBajado = new Teniente(getNombre(), getId());
        soldados.remove(this);  // Elimina al capitan de la lista
        soldados.add(soldadoBajado);  // Agrega el nuevo teniente a la lista
    }

    // Método para asignar la unidad
    public void setUnidad(String unidad) {
        rango.setUnidad(unidad);
    }

    // Método para realizar la acción del capitán
    public void realizarAccion() {
        rango.realizarAccion();
    }

    // Implementación de los métodos de la interfaz OperacionesMilitares
    @Override
    public void asignarMision() {
        System.out.println("El Capitán " + getNombre() + " asigna una misión táctica.");
    }

    @Override
    public void reportarEstado() {
        System.out.println("El " + getRango() + " " + getNombre() + " con código " + getId() + " reporta:");
        System.out.println(" - Informe de tareas diarias");
        System.out.println(" - Supervisión de tenientes");
        System.out.println(" - Estado general de la unidad bajo su mando");
        System.out.println(" - Planificación de misiones a corto plazo");
        System.out.println(" - Evaluación de riesgos y oportunidades estratégicas");
        System.out.println(" - Coordinación entre diferentes unidades");
        System.out.println(" - Condiciones tácticas locales");
    }

    // Clase interna para representar el rango del Capitán
    private class Capitan_rango extends rango {
        private int nivel;
        private String unidad;

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
            System.out.println("El Capitán " + getNombre() + " coordina misiones y lidera estrategias.");
        }
    }

    // Método toString sobrescrito
    @Override
    public String toString() {
        return "Capitan [soldadosBajoMando=" + soldadosBajoMando + "]";
    }

    public static void remove(){
        cantidad --;
    }
}

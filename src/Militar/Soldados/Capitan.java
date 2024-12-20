package Militar.Soldados;

import java.util.ArrayList;
import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;
import Militar.misiones.*;

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
        public String patrullar(boolean accionar) {
            String mensaje = "";
            if (accionar){
                mensaje = "El capitan"+ super.getNombre() +" saca unos binoculares y reconoce el terreno.";
            }
            if (!accionar){
                mensaje = "El capitan"+ super.getNombre() +"ha dejado de inspecionar el terreno";
            }
            return mensaje;
            
     
    }

    // Método sobrescrito para saludar
    @Override
    public String saludar() {
        // Se inicializa una variable para el saludo
        String saludo = "";
        // comprueba si el teniente tiene un nombre definido y si no esta vacio este parametro
            if (getNombre() != null && !getNombre().isEmpty()) {
                // Convertir el nombre a minúsculas para evitar problemas con mayúsculas/minúsculas
                String nombreEnMinuscula = getNombre().toLowerCase();
                // Obtener la primera y última letra
                char primeraLetra = nombreEnMinuscula.charAt(0);
                char ultimaLetra = nombreEnMinuscula.charAt(nombreEnMinuscula.length() - 1);
                // Comparar si la primera y la última letra son iguales
                if (primeraLetra == ultimaLetra) {
                    saludo = "El capitan " + getNombre() + " hace una voltereta en el aire y atrapa sus binoculares con la boca y luego te saluda con el pie.";
                } else {
                    saludo = "El capitan " + getNombre() + " intenta hacer una voltereta pero se cae y se rompe la espalda, te saluda con una carta desde el hospital.";
                }
            } else {
                saludo = "El capitan no tiene un nombre definido.";
            }
        return saludo; //Se retorna el saludo como un String
    }

    // Método sobrescrito para regañar
    @Override
    //retorna un mensaje de regaño
    public String regañado() {
        return "El capitan " + getNombre() + " ha sido bajado de rango a teniente debido a su mal desempeño en su labor.";

    }

    // Método para asignar la unidad
    public void setUnidad(String unidad) {
        rango.setUnidad(unidad);
    }

    // Método para realizar la acción del capitán
    public String realizarAccion() {
        return rango.realizarAccion();
    }

    // Implementación de los métodos de la interfaz OperacionesMilitares
    @Override
    public String asignarMision(Misiones mision) {
        String misionAsignada = "El Capitán " + getNombre() + " asigna a las tropas la mision tactica: " + mision;
        return misionAsignada;
    }

    @Override
    public ArrayList<String> reportarEstado() {
        ArrayList<String> reporte = new ArrayList<String>();
        reporte.add("El " + getRango() + " " + getNombre() + " con código " + getId() + " reporta:");
        reporte.add(" - Informe de tareas diarias");
        reporte.add(" - Supervisión de tenientes");
        reporte.add(" - Estado general de la unidad bajo su mando");
        reporte.add(" - Planificación de misiones a corto plazo");
        reporte.add(" - Evaluación de riesgos y oportunidades estratégicas");
        reporte.add(" - Coordinación entre diferentes unidades");
        reporte.add(" - Condiciones tácticas locales");
        return reporte;
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
        public String realizarAccion() {
            return "El Capitán " + getNombre() + " coordina misiones y lidera estrategias.";
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

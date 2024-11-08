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

    public void setUnidad(String unidad) {
        if (unidad != null && !unidad.isEmpty()) {  // Validación para asegurar que la unidad no sea nula o vacía
            rango.setUnidad(unidad);
            System.out.println("Unidad del Coronel " + getNombre() + " establecida a: " + unidad);
        } else {
            System.out.println("Error: La unidad no puede ser nula o vacía.");
        }
    }

    public void setEstrategia(String estrategia) {
        rango.setEstrategia(estrategia);
    }

    public void realizarAccion() {
        rango.realizarAccion();
    }

    private class Coronel_rango extends rango {
        int nivel;
        String unidad;

        public Coronel_rango() {
            this.nivel = 4;
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
        public String getEstrategia() {
            return super.getEstrategia();
        }

        @Override
        public void setEstrategia(String estrategia) {
            super.setEstrategia(estrategia);
        }

        @Override
        public void realizarAccion() {
            if ("sin estrategia".equals(estrategia)) {
                System.out.println("El Coronel " + getNombre() + " aún no ha establecido una estrategia.");
            } else {
                System.out.println("El Coronel " + getNombre() + " está estableciendo la estrategia: " + estrategia);
            }
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
                + getRango() + ", Nivel: " + rango.getNivel() + ", Unidad: " + rango.getUnidad() + "]");
    }

    // Implementación de los métodos de la interfaz
    @Override
    public void asignarMision() {
        System.out.println("El Coronel " + getNombre() + " asigna una misión estratégica.");
    }

    @Override
    public void reportarEstado() {
        System.out.println("El " + getRango() + " " + getNombre() + " con código " + getId() + " reporta: ");
        System.out.println(" - Estrategias y operaciones a nivel regional");
        System.out.println(" - Informe de inteligencia y análisis de la situación global");
        System.out.println(" - Estado general de la unidad bajo su mando");
        System.out.println(" - Gestión de recursos a gran escala");
        System.out.println(" - Evaluación de objetivos de misión a largo plazo");
        System.out.println(" - Supervisión de capitanes de unidades grandes");
    }

    @Override
    public String toString() {
        return "Coronel [estrategia=" + rango.getEstrategia() + "]";
    }
}

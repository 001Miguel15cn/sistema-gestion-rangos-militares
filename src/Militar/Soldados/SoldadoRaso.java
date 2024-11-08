package Militar.Soldados;

import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;

public class SoldadoRaso extends Soldado implements OperacionesMilitares {
    private SoldadoRaso_rango rango = new SoldadoRaso_rango();
    public static int cantidad = 0;

    public SoldadoRaso(String nombre, String id) {
        super(nombre, id);
        setRango("Soldado Raso");
        cantidad++;
    }

    @Override
    public String toString() {
        return "Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
                + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]";
    }

    @Override
    public void setUnidad(String unidad) {
        rango.setUnidad(unidad); // Delegamos la acción al objeto 'rango'
    }

    public void realizarAccion() {
        rango.realizarAccion(); // Delegamos la acción al objeto 'rango'
    }

    private class SoldadoRaso_rango extends rango {
        private int nivel;
        private String unidad;

        public SoldadoRaso_rango() {
            this.nivel = 1;
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
            System.out.println("El soldado " + getNombre() + " con código " + getId() + " está cumpliendo órdenes con determinación.");
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("");
        System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
                + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]");
    }

    @Override
    public void asignarMision() {
        System.out.println("");
        System.out.println("Se ha asignado una misión al soldado Raso.");
    }

    @Override
    public void reportarEstado() {
        System.out.println("");
        System.out.println("El " + getRango() + " " + getNombre() + " con código " + getId() + " reporta: ");
        System.out.println("");
        System.out.println(" - Estado de tarea asignada");
        System.out.println("");
        System.out.println(" - Condiciones del entorno");
        System.out.println("");
        System.out.println(" - Necesidad de suministros");
        System.out.println("");
        System.out.println(" - Observaciones");
        System.out.println("");
        System.out.println(" - Proximidad del enemigo");
    }
}

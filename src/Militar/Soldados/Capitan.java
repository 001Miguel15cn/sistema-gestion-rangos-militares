package Militar.Soldados;

import Operaciones.OperacionesMilitares;

public class Capitan extends Soldado implements OperacionesMilitares {
    private int soldadosBajoMando;

    public Capitan(String nombre, String id) {
        super(nombre, id);
        this.soldadosBajoMando = 50;
    }

    @Override
    public void realizarAccion() {
        System.out.println("El Capitán " + getNombre() + " coordina misiones y lidera estrategias.");
        System.out.println("Tiene " + soldadosBajoMando + " soldados bajo su mando.");
    }

    // Implementación de los métodos de la interfaz
    @Override
    public void asignarMision() {
        System.out.println("El Capitán " + getNombre() + " asigna una misión táctica.");
    }

    @Override
    public void reportarEstado() {
        System.out.println("El Capitán " + getNombre() + " reporta el estado de sus tropas.");
    }
}

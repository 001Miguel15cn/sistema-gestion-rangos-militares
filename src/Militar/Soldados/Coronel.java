package Militar.Soldados;

import Operaciones.OperacionesMilitares;

public class Coronel extends Soldado implements OperacionesMilitares {
    private String estrategia;

    public Coronel(String nombre, String id) {
        super(nombre, id);
        this.estrategia = "Estrategia de ataque coordinado";
        setRango("Coronel");
    }

    @Override
    public void realizarAccion() {
        System.out.println("El Coronel " + getNombre() + " está estableciendo la estrategia: " + estrategia);
    }

    // Implementación de los métodos de la interfaz
    @Override
    public void asignarMision() {
        System.out.println("El Coronel " + getNombre() + " asigna una misión estratégica.");
    }

    @Override
    public void reportarEstado() {
        System.out.println("El Coronel " + getNombre() + " reporta que las operaciones van según lo planeado.");
    }

    @Override
    public String toString() {
        return "Coronel [estrategia=" + estrategia + "]";
    }

    


}




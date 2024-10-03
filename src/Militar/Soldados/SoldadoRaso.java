package Militar.Soldados;

public class SoldadoRaso extends Soldado {

    public SoldadoRaso(String nombre, String id) {
        super(nombre, id);
        setRango("Soldado Raso");
    }

    @Override
    public void realizarAccion() {
        System.out.println(getNombre() + " con código " + getId() + " está cumpliendo órdenes con determinación.");
    }
}



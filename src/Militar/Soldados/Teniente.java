package Militar.Soldados;

public class Teniente extends Soldado {

    public Teniente(String nombre, String id) {
        super(nombre, id); // Llamada explícita al constructor de Soldado
        setRango("Teniente");
    }

    @Override
    public void realizarAccion() {
        System.out.println("El Teniente " + getNombre() + " coordina a los soldados y supervisa las operaciones.");
    }
}

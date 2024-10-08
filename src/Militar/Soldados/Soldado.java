package Militar.Soldados;

public abstract class Soldado {
    private String nombre;
    private String id;
    private String rango;

    public Soldado(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getRango() {
        return rango;
    }

    // Método abstracto para que las clases hijas lo implementen
    public abstract void mostrarInformacion();

    @Override
    public String toString() {
        return "Soldado [nombre=" + nombre + ", id=" + id + ", rango=" + rango + "]";
    }

    

}

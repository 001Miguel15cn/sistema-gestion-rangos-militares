package Militar.Soldados;

public abstract class Soldado {
    private String nombre;
    private final String id;
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

    public String getRango() {
        return rango;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    // Método abstracto para setUnidad, que cada subclase debe implementar
    public abstract void setUnidad(String unidad);

    public abstract void mostrarInformacion();

    @Override
    public String toString() {
        return "Soldado [Nombre=" + nombre + ", ID=" + id + ", Rango=" + rango + "]";
    }
}

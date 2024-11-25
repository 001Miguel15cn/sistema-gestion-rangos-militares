package Militar.Soldados;

import java.util.ArrayList;

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


    public abstract void mostrarInformacion();

    public abstract void patrullar();

    public abstract void saludar();

    public abstract void regañado(ArrayList<Soldado> soldados);

    @Override
    public String toString() {
        return "Soldado [Nombre=" + nombre + ", ID=" + id + ", Rango=" + rango + "]";
    }
}

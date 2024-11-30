package Militar.Soldados;

import java.util.ArrayList;

public class Soldado {
      
    private String nombre;
    private final  String id;  // ID generado automáticamente
    private String rango;

    // Constructor que recibe nombre y rango, pero genera el ID automáticamente
    public Soldado(String nombre, String rango, String id) {
        this.nombre = nombre;
        this.rango = rango;
        this.id = id;  // Generar el ID único al crear el soldado
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

    // Implementación de los métodos abstractos
    public String mostrarInformacion() {
        System.out.println("Información del Soldado: " + this.toString());
        return "Información del Soldado: " + this.toString();
    }

    public void patrullar() {
        System.out.println("El soldado " + nombre + " está patrullando.");
    }

    public void saludar() {
        System.out.println("El soldado " + nombre + " saluda.");
    }

    public void regañado(ArrayList<Soldado> soldados) {
        System.out.println("El soldado " + nombre + " está siendo regañado.");
    }

    @Override
    public String toString() {
        return "Soldado [Nombre=" + nombre + ", ID=" + id + ", Rango=" + rango + "]";
    }
}

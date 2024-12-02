package Militar.Soldados;

import java.util.ArrayList;

public class Soldado {
      
    private String nombre;
    private final  String id;  // ID generado automáticamente
    private String rango;
    private String unidad;

    // Constructor que recibe nombre y rango, pero genera el ID automáticamente
    public Soldado(String nombre, String rango, String id) {
        this.nombre = nombre;
        this.rango = rango;
        this.id = id;  // Generar el ID único al crear el soldado
        this.unidad = "sin unidad";
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

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad; // Asignar unidad al soldado
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

    public String patrullar() {
        System.out.println("El soldado " + nombre + " está patrullando.");
        return "El soldado " + nombre + " está patrullando.";
    }

    public void saludar() {
        System.out.println("El soldado " + nombre + " saluda.");
    }

    public String regañado(ArrayList<Soldado> soldados) {
        System.out.println("El soldado " + nombre + " está siendo regañado.");
        return "El soldado " + nombre + " está siendo regañado.";
    }
    public String realizarAccion() {
        return "El soldado " + nombre + " está cumpliendo órdenes.";
    }

    @Override
    public String toString() {
        return "Soldado [Nombre=" + nombre + ", ID=" + id + ", Rango=" + rango + "]";
    }
    
}

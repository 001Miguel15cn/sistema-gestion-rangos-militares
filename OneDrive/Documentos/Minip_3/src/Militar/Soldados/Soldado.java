package Militar.Soldados;

import java.util.ArrayList;

import Militar.misiones.Misiones;

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

    public String patrullar(boolean accionar) {
        String mensaje = "";
        if (accionar){
            mensaje = "El soldado " + nombre + " está patrullando.";
        }
        if (!accionar){
            mensaje = "El soldado " + nombre + " ha detenido su patrulla.";
        }
        return mensaje;
        
    }
       

    public String saludar() {
        return "El soldado " + nombre + " saluda.";
    }

    public String regañado() {
        return "El soldado " + nombre + " está siendo regañado.";
    }

    @Override
    public String toString() {
        return "Soldado [Nombre=" + nombre + ", ID=" + id + ", Rango=" + rango + "]";
    }



    public void realizarMision(Misiones mision) {
        
        throw new UnsupportedOperationException("Unimplemented method 'realizarMision'");
    }



    public Object asignarMision(Misiones mision) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarMision'");
    }
    
}

package Militar.Soldados;

import java.util.ArrayList;
import Militar.misiones.*;
import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;

public class Coronel extends Soldado implements OperacionesMilitares {

    public static int cantidad = 0;
    private Coronel_rango rango = new Coronel_rango();

    public Coronel(String nombre, String id) {
        // Llamamos al constructor de Soldado, ahora con tres parámetros
        super(nombre,"Coronel",id);  // "Coronel" es el rango que le asignamos al coronel
        cantidad++;
    }

    public void setUnidad(String unidad){
        rango.setUnidad(unidad);
    }

    public void setEstrategia(String estrategia){
        rango.setEstrategia(estrategia);
    }

    public String realizarAccion(){
        return rango.realizarAccion();
    }

    @Override
        public String patrullar(boolean accionar) {
            String mensaje = "";
            if (accionar){
                mensaje = "El coronel"+ super.getNombre() +" ordena a sus tropas un reconocimiento del area de combate mientras se toma un tinto en su oficina";
            }
            if (!accionar){
                mensaje = "El coronel"+ super.getNombre() +" ha ordenado detener la patrulla.";
            }
            return mensaje;
            

    }

    @Override
    public String saludar() {
        // Se inicializa una variable para el saludo
        String saludo = "";
            if (getNombre() != null && !getNombre().isEmpty()) {
                String nombreEnMinusula = getNombre().toLowerCase();
                char primeraLetra = nombreEnMinusula.charAt(0);
                char ultimaLetra = nombreEnMinusula.charAt(nombreEnMinusula.length() - 1);
                if (primeraLetra == ultimaLetra) {
                    saludo = "El coronel " + getNombre() + " le prepara una tacita de cafe y le da un cordial saludo invitandolo a sentarse con el en su oficina";
                } else {
                    saludo = "El coronel " + getNombre() + " se quema la lengua tomando cafe y lo saluda sacandole la lengua";
                }
            } else {
                saludo = "El coronel no tiene un nombre definido";
            } 
        return saludo;  // Se retorna el saludo como un String    
    }

    @Override
    //retorna un mensaje de regaño
    public String regañado() {
        return "El coronel " + getNombre() + " ha sido bajado de rango a capitan debido a su mal desempeño en su labor";
    }

    private class Coronel_rango extends rango {
        int nivel;
        String unidad;

        public Coronel_rango() {
            this.nivel = 4;
            this.unidad = "sin unidad";
        }

        @Override
        public void setNivel(int nivel) {
            this.nivel = nivel;
        }

        @Override
        public void setUnidad(String unidad) {
            this.unidad = unidad;
        }

        @Override
        public int getNivel() {
            return nivel;
        }

        @Override
        public String getUnidad() {
            return unidad;
        }

        @Override
        public String getEstrategia() {
            return super.getEstrategia();
        }

        @Override
        public void setEstrategia(String estrategia) {
            super.setEstrategia(estrategia);
        }

        @Override
        public String realizarAccion() {
            if (estrategia == "sin estrategia") {
                return "El Coronel " + getNombre() + " aún no ha establecido una estrategia";
            } else {
                 return "El Coronel " + getNombre() + " está estableciendo la estrategia: " + estrategia;
            }
        }
    }

    public String mostrarInformacion() {
        //System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
             //   + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]");
        return "Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
                + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]";
    }

    @Override
    public String asignarMision(Misiones mision) {
        String misionAsignada = "El Coronel " + getNombre() + " asigna una misión estratégica: " + mision;
        return misionAsignada;
    }

    @Override
    public ArrayList<String> reportarEstado() {
        ArrayList<String> reporte = new ArrayList<String>();
        reporte.add("El " + getRango() + " " + getNombre() + " con código " + getId() + " reporta: ");
        reporte.add(" -Estrategias y operaciones a nivel regional");
        reporte.add(" -Informe de inteligencia y análisis de la situación global");
        reporte.add(" -Estado general de la unidad bajo su mando");
        reporte.add(" -Gestión de recursos a gran escala");
        reporte.add(" -Evaluación de objetivos de misión a largo plazo");
        reporte.add(" -Supervisión de capitanes de unidades grandes");
        return reporte;
    }

    @Override
    public String toString() {
        return "Coronel [estrategia=" + rango.getEstrategia() + "]";
    }
    
    public static void remove(){
        cantidad --;
    }
}

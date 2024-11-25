package Militar.Soldados;

import java.util.ArrayList;

import Militar.rangos.rango;
import Operaciones.OperacionesMilitares;

public class Coronel extends Soldado implements OperacionesMilitares {

    public static int cantidad = 0;
    private Coronel_rango rango = new Coronel_rango();

    public Coronel(String nombre, String id) {
        super(nombre, id);
        setRango("Coronel");
        cantidad++;
    }

     public void setUnidad(String unidad){
        rango.setUnidad(unidad);
         }

    public void setEstrategia(String estrategia){
        rango.setEstrategia(estrategia);
    }
    public void realizarAccion(){
        rango.realizarAccion();
    }

    @Override
    public void patrullar() {
        // Imprime la forma de patrullar del coronel
        System.out.println("El coronel ordena a sus tropas un reconocimiento del area de combate mientras se toma un tinto en su oficina");
    }

    @Override
    public void saludar() {
        // comprueba si el coronel tiene un nombre definido y si no esta vacio este parametro
        if (getNombre() != null && !getNombre().isEmpty()) {
            // Convertir el nombre a minúsculas para evitar problemas con mayúsculas/minúsculas
            String nombreEnMinusula = getNombre().toLowerCase();
            // Obtener la primera y última letra
            char primeraLetra = nombreEnMinusula.charAt(0);
            char ultimaLetra = nombreEnMinusula.charAt(nombreEnMinusula.length() - 1);
            // Comparar si la primera y la última letra son iguales
            if (primeraLetra == ultimaLetra) {
                System.out.println("El coronel " + getNombre() + " le prepara una tacita de cafe y le da un cordial saludo invitandolo a sentarse con el en su oficina");
            } else {
                System.out.println("El coronel " + getNombre() + " se quema la lengua tomando cafe y lo saluda sacandole la lengua");
            }
        } else {
            System.out.println("El coronel no tiene un nombre definido");
        }       
    }

    @Override
    public void regañado(ArrayList<Soldado> soldados) {
        System.out.println("El coronel " + getNombre() + " ha sido bajado de rango a capitan debido a su mal desempeño en su labor");
        Capitan soldadoBajado = new Capitan(getNombre(), getId());
        // Se reemplaza el coronel por el nuevo capitan en la lista
        soldados.remove(this);  // Elimina al coronel de la lista
        soldados.add(soldadoBajado);  // Agrega el nuevo capitan a la lista
    }

    private class Coronel_rango extends rango{
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
        public void realizarAccion() {
            if (estrategia == "sin estrategia"){
                System.out.println("");
                System.out.println("El Coronel " + getNombre() + "aun no ha establecido una estrategia");
            }
            else{
            System.out.println("");
            System.out.println("El Coronel " + getNombre() + " está estableciendo la estrategia: " + estrategia);
       }
            
        }
    }

    ///este debe ser cambiando por realizar accion
    public void mostrarInformacion() {
        System.out.println("");
        System.out.println("Soldado[ Nombre: " + getNombre() + ", Id: " + getId() + ", Rango: "
               + getRango() + ", nivel: " + rango.getNivel() + ", unidad: " + rango.getUnidad() + "]");
      
    }

    // Implementación de los métodos de la interfaz
   
    @Override
    public void asignarMision() {
        System.out.println("El Coronel " + getNombre() + " asigna una misión estratégica.");
    }

    @Override
    public void reportarEstado() {
        System.out.println("");
        System.out.println("El " + getRango() + " " + getNombre() + " con código " + getId() + " reporta: ");
        System.out.println("");
        System.out.println(" -Estrategias y operaciones a nivel regional");
        System.out.println("");
        System.out.println(" -informe de inteligencia y análisis de la situación global");
        System.out.println("");
        System.out.println(" -Estado general de la unidad bajo su mando");
        System.out.println("");
        System.out.println(" -Gestión de recursos a gran escala");
        System.out.println("");
        System.out.println(" -Evaluación de objetivos de misión a largo plazo");
        System.out.println("");
        System.out.println(" -Supervisión de capitanes de unidades grandes");
    }

    @Override
    public String toString() {
        return "Coronel [estrategia=" + rango.getEstrategia() + "]";
    }

    


}




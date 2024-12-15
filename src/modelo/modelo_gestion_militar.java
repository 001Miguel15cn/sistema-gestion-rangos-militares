package modelo;

import java.util.ArrayList;
import java.util.Scanner;

import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;
import Militar.Soldados.Soldado;
import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;
import Militar.misiones.Misiones;
import controlador.Controlador;

public class modelo_gestion_militar {
    private String mayorID = "S000";
    private ArrayList<Soldado> lista_soldados = new ArrayList<Soldado>();
    private ArrayList<Soldado> lista_soldados_defecto = new ArrayList<Soldado>();
    private Controlador controlador;

    
    public String getMayorID() {
        return mayorID;
    }

    public void setMayorID(String mayorID) {
        this.mayorID = mayorID;
    }
    //añadir un soldado ya creado a la lista 
    public void addSoldado(Soldado soldado){
        this.lista_soldados.add(soldado);
    }
    //remover un soldado ya creado de la lista
    public void removeSoldado(Soldado soldado){
        this.lista_soldados.remove(soldado);
    }

    //mostrar la informacion de un soldado ya creado
    public String mostrarSoldados(Soldado soldado){
        return  soldado.mostrarInformacion();
      }
    //optener la lista de soldados
    public ArrayList<Soldado> getLista_soldados() {
        return lista_soldados;
    }
    //setear la lista de soldados
    public void setLista_soldados(ArrayList<Soldado> lista_soldados) {
        this.lista_soldados = lista_soldados;
    }
    //optener la lista de soldados por defecto
    public ArrayList<Soldado> getLista_soldados_defecto() {
        return lista_soldados_defecto;
    }
    //setear la lista de soldados por defecto
    public void setLista_soldados_defecto(ArrayList<Soldado> lista_soldados_defecto) {
        this.lista_soldados_defecto = lista_soldados_defecto;
    }
    //optener el controlador
    public Controlador getControlador() {
        return controlador;
    }
    //setear el controlador
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    //retorna el ID mayor de la lista de soldados seteada
    public String OptenerIDmayor() {
        // Actualizar MayorID
        for (Soldado soldado : lista_soldados) {
            String idActual = soldado.getId();
            if (idActual.compareTo(mayorID) > 0) {
                this.mayorID = idActual;
            }
        }
        return mayorID;
    }

    //retorna el incremental del ID ingresado
    public String IdIncremental(String ID) {
        int numeroID = Integer.parseInt(ID.substring(1));
        int nuevoID = numeroID + 1;
        String nuevoIDString = String.format("S%03d", nuevoID);
        return nuevoIDString;
    }

    //recibe el iD de un soldado y retorna su informacion
    public String mostrarSoldadoID(String ID){
    
        for (Soldado soldado : lista_soldados) {
            String idActual = soldado.getId();
            if (idActual.equals(ID)) {
                return soldado.mostrarInformacion();
                }
            }
        return null;
      }

    //funcion para crear una intacia soldado dependiendo de el tipo que se le ingrese
    public Soldado crearInstanciaSoldado(Tipo_soldado tipo , String nombre, String id) {
        switch (tipo) {
            case Tipo_soldado.Soldado_raso:
                return new SoldadoRaso(nombre, id);
            case Tipo_soldado.Teniente:
                return new Teniente(nombre, id);
            case Tipo_soldado.Capitan:
                return new Capitan(nombre, id);
            case Tipo_soldado.Coronel:
                return new Coronel(nombre, id);
            default:
                return null;
        }
    }
    //resetea el arraylist a los valores por defecto 
    public void Resetear_lista(){
        SoldadoRaso.cantidad = 3;
        Teniente.cantidad = 1;
        Coronel.cantidad = 1;
        Capitan.cantidad = 1;
        lista_soldados.clear();
        setLista_soldados(lista_soldados_defecto);
    }
    //mostrar soldados retorna un arraylist con los datos de los soldados
    public ArrayList<String> mostrarSoldados() {
        ArrayList<String> lista_datos = new ArrayList<String>();
        if (lista_soldados.isEmpty()){
            return null;
        }
        else{
        for (Soldado soldado : lista_soldados) {
            lista_datos.add(soldado.mostrarInformacion());
        }
        return lista_datos;}
    }
      
    //retorna un arraylist con los soldados que pertenecescan al rango seleccionado
    public ArrayList<String> mostrarSoldadosRango(Tipo_soldado rango) {
        ArrayList<String> lista_datos = new ArrayList<String>();
        if (lista_soldados.isEmpty()){
            return null;
        }
        else{
        for (Soldado soldado : lista_soldados) {
            if (rango.equals(soldado.getRango())){
                    lista_datos.add(soldado.mostrarInformacion());
             }
        
         }
         return lista_datos;
      }
    }
    //recibe un iD retorna un soldado para entregarlo a otros metodos 
    public Soldado Optener_soldado(String ID){
        Soldado soldadoAModificar = null;
        for (Soldado soldado : lista_soldados) {
            if (soldado.getId().equalsIgnoreCase(ID)) {
                soldadoAModificar = soldado; 
            }
          
        }
        return soldadoAModificar;
    }
    //retorna el downcasting del Soldado ingresado
    public Object Optener_soldado_Clase(Soldado soldado) {
        if (soldado instanceof SoldadoRaso) {
            return (SoldadoRaso) soldado;
        } else if (soldado instanceof Teniente) {
            return (Teniente) soldado;
        } else if (soldado instanceof Capitan) {
            return (Capitan) soldado;
        } else if (soldado instanceof Coronel) {
            return (Coronel) soldado;
        }
    
        // Si no pertenece a ninguna de las clases esperadas, puedes retornar null o lanzar una excepción
        return null; // o lanzar una excepción: throw new IllegalArgumentException("Tipo de soldado no reconocido");
    }
    


    //recibe un soldado y una unidad y se la asinga al soldado recibido
    public void modificar_unidad(Soldado soldado, String Unidad){
        if (soldado instanceof SoldadoRaso) {
            SoldadoRaso soldadoAmodificar2 = (SoldadoRaso) soldado;
            soldadoAmodificar2.setUnidad(Unidad);  

        }
        if (soldado instanceof Teniente) {
            Teniente soldadoAmodificar2 = (Teniente) soldado;
            soldadoAmodificar2.setUnidad(Unidad);  

        }
        if (soldado instanceof Capitan) {
            Capitan soldadoAmodificar2 = (Capitan) soldado;
            soldadoAmodificar2.setUnidad(Unidad);  

        }
        if (soldado instanceof Coronel) {
            Coronel soldadoAmodificar2 = (Coronel) soldado;
            soldadoAmodificar2.setUnidad(Unidad);  

        }
    }
    //recibe un coronel y modifica su estrategia
    public void modificar_estrategia(Coronel soldado, String Strategia){
        soldado.setEstrategia(Strategia);
    }

    //recibe un capitan y modificar su numero de soldados bajo mando
    public void modificar_soldados_bajo_mando(Capitan soldado, int numero_soldados){
        soldado.setSoldadosBajoMando(numero_soldados);
    }

    //recibe un soldado y lo sube de rango
    public Soldado subirRango(Soldado soldado) {
        if (soldado instanceof SoldadoRaso) {
            SoldadoRaso.remove();
            return new Teniente(soldado.getNombre(), soldado.getId());
        } else if (soldado instanceof Teniente) {
            Teniente.remove();
            return new Capitan(soldado.getNombre(), soldado.getId());
        } else if (soldado instanceof Capitan) {
            Capitan.remove();
            return new Coronel(soldado.getNombre(), soldado.getId());
        } else {
            return null;
        }
    }

    // recibe un soldado y lo baja de rango, cuando el rango es soldado raso
    //remove() solo reduce la cantidad de elementos de esa instancia
    public Soldado bajarRango(Soldado soldado) {
        if (soldado instanceof Coronel) {
            Coronel.remove();
            return new Capitan(soldado.getNombre(), soldado.getId());
        } else if (soldado instanceof Capitan) {
            Capitan.remove();
            return new Teniente(soldado.getNombre(), soldado.getId());
        } else if (soldado instanceof Teniente) {
            Teniente.remove();
            return new SoldadoRaso(soldado.getNombre(), soldado.getId());
        } else {
            SoldadoRaso.remove();
            return null;
        }
    }
    //ejecuta la accion de bajar rango al soldado regañado
    public String Obtener_mensaje_regaño(Soldado soldado){
        String mensaje = "";
        if (soldado instanceof SoldadoRaso) {
            SoldadoRaso soldadonew = (SoldadoRaso) soldado;
            mensaje = soldadonew.regañado();

        }
        if (soldado instanceof Teniente) {
            Teniente soldadonew = (Teniente) soldado;
            mensaje = soldadonew.regañado();

        }
        if (soldado instanceof Capitan) {
            Capitan soldadonew = (Capitan) soldado;
            mensaje = soldadonew.regañado();

        }
        if (soldado instanceof Coronel) {
            Coronel soldadonew = (Coronel) soldado;
            mensaje = soldadonew.regañado();

        }
        return mensaje;
    }
    //obtiene el mensaje de saludo del soldado
    public String Obtener_mensaje_de_saludo(Soldado soldado){
        String mensaje = "";
        if (soldado instanceof SoldadoRaso) {
            SoldadoRaso soldadonew = (SoldadoRaso) soldado;
            mensaje =soldadonew.saludar();

        }
        if (soldado instanceof Teniente) {
            Teniente soldadonew = (Teniente) soldado;
            mensaje = soldadonew.saludar();

        }
        if (soldado instanceof Capitan) {
            Capitan soldadonew = (Capitan) soldado;
            mensaje = soldadonew.saludar();

        }
        if (soldado instanceof Coronel) {
            Coronel soldadonew = (Coronel) soldado;
            mensaje = soldadonew.saludar();

        }
        return mensaje;
    }
    //permite obtener el mensaje de patrulla de un soldado en base a un booleando accion
    //si es true retorna su mensaje de patrulla
    //si es falso retorna que se ha detenido su patrulla
    public String obtener_mensaje_de_patrulla(Soldado soldado, boolean accion){
        String mensaje = "";
        if (soldado instanceof SoldadoRaso) {
            SoldadoRaso soldadonew = (SoldadoRaso) soldado;
            mensaje = soldadonew.patrullar(accion);
        }
        if (soldado instanceof Teniente) {
            Teniente soldadonew = (Teniente) soldado;
            mensaje = soldadonew.patrullar(accion);
        }
        if (soldado instanceof Capitan) {
            Capitan soldadonew = (Capitan) soldado;
            mensaje = soldadonew.patrullar(accion);
        }
        if (soldado instanceof Coronel) {
            Coronel soldadonew = (Coronel) soldado;
            mensaje = soldadonew.patrullar(accion);

        }
        return mensaje;
        
    }
    //obtiene el mensaje de realizar accion del soldado ingresado
    public String obtener_mensaje_realizar_accion(Soldado soldado){
        String mensaje = "";
        if (soldado instanceof SoldadoRaso) {
            SoldadoRaso soldadonew = (SoldadoRaso) soldado;
            mensaje = soldadonew.realizarAccion();
        }
        if (soldado instanceof Teniente) {
            Teniente soldadonew = (Teniente) soldado;
            mensaje = soldadonew.realizarAccion();
        }
        if (soldado instanceof Capitan) {
            Capitan soldadonew = (Capitan) soldado;
            mensaje = soldadonew.realizarAccion();
        }
    
        if (soldado instanceof Coronel) {
            Coronel soldadonew = (Coronel) soldado;
            mensaje = soldadonew.realizarAccion();
        }
        return mensaje; 
    }
    //obtiene el mensaje de accionar mision
    public String mensaje_asignar_mision(Soldado soldado, Misiones mision){
        String mensaje = "";
        if (soldado instanceof SoldadoRaso) {
            SoldadoRaso soldadonew = (SoldadoRaso) soldado;
            mensaje = soldadonew.asignarMision(mision);
        }
        if (soldado instanceof Teniente) {
            Teniente soldadonew = (Teniente) soldado;
            mensaje = soldadonew.asignarMision(mision);
        }
        if (soldado instanceof Capitan) {
            Capitan soldadonew = (Capitan) soldado;
            mensaje = soldadonew.asignarMision(mision);
        }
    
        if (soldado instanceof Coronel) {
            Coronel soldadonew = (Coronel) soldado;
            mensaje = soldadonew.asignarMision(mision);
        }
        return mensaje; 
    }

    //recibe un soldado y retorna un arraylist con los mensajes
    //de cada una de las secciones del reporte
    public ArrayList<String> reporte_de_estado(Soldado soldado){
        ArrayList<String> reporte = new ArrayList<String>();
        
        if (soldado instanceof SoldadoRaso) {
            SoldadoRaso soldadonew = (SoldadoRaso) soldado;
            reporte = soldadonew.reportarEstado();
        }
        if (soldado instanceof Teniente) {
            Teniente soldadonew = (Teniente) soldado;
            reporte = soldadonew.reportarEstado();
        }
        if (soldado instanceof Capitan) {
            Capitan soldadonew = (Capitan) soldado;
            reporte = soldadonew.reportarEstado();
        }
    
        if (soldado instanceof Coronel) {
            Coronel soldadonew = (Coronel) soldado;
            reporte = soldadonew.reportarEstado();
        }
        return reporte; 
    }

}
    




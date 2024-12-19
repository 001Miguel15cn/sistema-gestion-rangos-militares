package vista;

import java.util.ArrayList;

import Militar.misiones.Misiones;
import controlador.Accion_rango;
import controlador.Controlador;
import controlador.Mostrar_tipo_informacion;
import controlador.Tipo_soldado;
public interface Gestion_militar_interfaz {
    // Métodos para obtener atributos del soldado
    String getID();
    String getNombreSoldado();
    String getUnidad();
    int getSoldadosBajoMando();
    String getEstregia();
    Misiones getMision();
    Tipo_soldado getTipo_soldado();
    Accion_rango getAccion_rango();

    // Métodos para mostrar información
    void mostrarInformacion(ArrayList<String> lista);
    void mensajeMision(String misionmensaje);
    void mensajeRealizaraccion(String accion);
    void mensajesaludar(String mensaje);
    
    void inializar(Controlador controlador);
}   

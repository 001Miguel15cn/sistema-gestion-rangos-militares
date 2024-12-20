package vista;

import Militar.misiones.Misiones;
import controlador.Accion_rango;
import controlador.Controlador;
import controlador.Tipo_soldado;
import java.util.ArrayList;

public interface Gestion_militar_interfaz {
    // Métodos para obtener atributos del soldado
    String getID();
    String getNombreSoldado();
    String getUnidad();
    int getSoldadosBajoMando();
    String getEstrategia();  // Corrección aquí
    Misiones getMision();
    Tipo_soldado getTipo_soldado();
    Accion_rango getAccion_rango();
    ArrayList<String> getReporte();

    // Métodos para mostrar información
    void mostrarInformacion(ArrayList<String> lista);
    void mensajeMision(String misionmensaje);
    void mensajeRealizaraccion(String accion);
    void mensajesaludar(String mensaje);
    void mensajepatrullar(String mensaje);
    void mensajeregaño(String mensaje);

    // Método para inicializar la interfaz
    void inicializar(Controlador controlador);  // Corrección aquí

    // Métodos para mostrar reporte y cantidades
    void Mostrar_Reporte(ArrayList<String> listaReportes);  // Método para mostrar los reportes
    void Cantidadesoldados(int cantidad);  // Método para mostrar la cantidad de soldados
}

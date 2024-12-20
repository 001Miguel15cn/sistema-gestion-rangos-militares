package vista;

import java.util.ArrayList;

import Militar.misiones.Misiones;
import controlador.Accion_rango;
import controlador.Controlador;
import controlador.Tipo_soldado;

public class Gestion_militar_terminal implements Gestion_militar_interfaz{
    ArrayList<String> lista = new ArrayList<String>();
    //valores recibidos por la gui
    String ID="";
    String NombreSoldado="";
    String Unidad="";
    int SoldadosBajoMando=0;
    String Estregia="";
    Misiones Mision;
    Tipo_soldado tipo_soldado;

    @Override
    public String getID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getID'");
    }
    @Override
    public String getNombreSoldado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombreSoldado'");
    }
    @Override
    public String getUnidad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUnidad'");
    }
    @Override
    public int getSoldadosBajoMando() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSoldadosBajoMando'");
    }
    @Override
    public String getEstregia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEstregia'");
    }
    @Override
    public Misiones getMision() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMision'");
    }
    @Override
    public Tipo_soldado getTipo_soldado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipo_soldado'");
    }
    @Override
    public Accion_rango getAccion_rango() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccion_rango'");
    }
    @Override
    public void mostrarInformacion(ArrayList<String> lista) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarInformacion'");
    }
    @Override
    public void inializar(Controlador controlador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inializar'");
    }
    @Override
    public void mensajeMision(String misionmensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mensajeMision'");
    }
    @Override
    public void mensajeRealizaraccion(String accion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mensajeRealizaraccion'");
    }
    @Override
    public void mensajesaludar(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mensajesaludar'");
    }
    @Override
    public void mensajeregaño(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mensajeregaño'");
    }
    @Override
    public ArrayList<String> getReporte() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReporte'");
    }
    @Override
    public void mensajepatrullar(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mensajepatrullar'");
    }
    @Override
    public void Cantidadesoldados(ArrayList<Integer> cantidades) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Cantidadesoldados'");
    }
    @Override
    public void Mostrar_reporte(ArrayList<String> repote) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Mostrar_reporte'");
    }
    
}

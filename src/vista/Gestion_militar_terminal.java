package vista;

import java.util.ArrayList;

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
    String Mision="";
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
    public String getMision() {
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
    
}

import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;
import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;
import Militar.Soldados.Soldado;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.Controlador;
import vista.interfaz_grafica.interfaz_principal;
import modelo.Modelo_gestion_militar;
import vista.Gestion_militar_interfaz;
import vista.Gestion_militar_terminal;

public class Main {

    static ArrayList<Soldado> soldados = new ArrayList<>();

    public static void main(String[] args) {

        SoldadoRaso soldado1 = new SoldadoRaso("Juan", "S001");
        SoldadoRaso soldado2 = new SoldadoRaso("Roberto", "S004");
        SoldadoRaso soldado3 = new SoldadoRaso("Albaro", "S005");
        Teniente teniente1 = new Teniente("Camilo", "S002");
        Capitan capitan1 = new Capitan("Miguel", "S003");
        Coronel coronel1 = new Coronel("Andrea", "S000");
        
        // Configuración de unidades y estrategias
        capitan1.setUnidad("Comando2");
        teniente1.setUnidad("Milicia del sur");
        soldado1.setUnidad("Milicia del sur");
        coronel1.setEstrategia("proteger una region clave");

        // Lista de soldados
       
        soldados.add(soldado1);
        soldados.add(soldado2);
        soldados.add(soldado3);
        soldados.add(teniente1);
        soldados.add(capitan1);
        soldados.add(coronel1);
        Modelo_gestion_militar modelo = new Modelo_gestion_militar();   
        Gestion_militar_terminal vista = new Gestion_militar_terminal();
        //interfaz_principal vista = new interfaz_principal();
        Controlador controlador = new Controlador(modelo, vista);
        controlador.inicializacion();
    }
}


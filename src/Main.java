import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;
import Vista.VistaTerminal;
import controlador.Controlador;
import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;
import Militar.Soldados.Soldado;

import java.util.ArrayList;
import java.util.Scanner;

import interfaz_grafica.interfaz_principal;
public class Main {
    public static void main(String[] args) {
        
        Controlador controlador = new Controlador();
        VistaTerminal vista = new VistaTerminal(controlador);

        controlador.inicializacion(vista);
    }
}


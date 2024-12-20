import java.util.ArrayList;

import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;
import Militar.Soldados.Soldado;
import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;
import controlador.Controlador;
import modelo.modelo_gestion_militar;
import vista.Gestion_militar_terminal;

public class Main {
static ArrayList<Soldado> soldados = new ArrayList<>();
    public static void main(String[] args) {
         SoldadoRaso soldado1 = new SoldadoRaso("Juan", "S001");
        SoldadoRaso soldado2 = new SoldadoRaso("Natalia", "S004");
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

        
        // Crear el modelo que contiene la lógica de negocio
        modelo_gestion_militar modelo = new modelo_gestion_militar();


        // Crear la vista (puede ser una interfaz gráfica o una terminal)
        // Gestion_militar_terminal vista = new Gestion_militar_terminal();
        Gestion_militar_terminal vista = new Gestion_militar_terminal();

        // Crear el controlador que conecta el modelo y la vista
        Controlador controlador = new Controlador(modelo, vista);
        modelo.setLista_soldados(soldados);
        modelo.setLista_soldados_defecto(soldados);
        // Inicializar la aplicación
        controlador.inicializacion();
    }
}

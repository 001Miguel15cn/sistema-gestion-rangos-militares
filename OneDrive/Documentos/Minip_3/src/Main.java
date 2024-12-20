import controlador.Controlador;
import vista.Gestion_militar_interfaz;
import vista.Gestion_militar_terminal;
import modelo.Modelo_gestion_militar;

public class Main {

    public static void main(String[] args) {

        // Crear el modelo que contiene la lógica de negocio
        Modelo_gestion_militar modelo = new Modelo_gestion_militar();

        // Crear la vista (puede ser una interfaz gráfica o una terminal)
        // Gestion_militar_terminal vista = new Gestion_militar_terminal();
        Gestion_militar_interfaz vista = new Gestion_militar_interfaz();

        // Crear el controlador que conecta el modelo y la vista
        Controlador controlador = new Controlador(modelo, vista);

        // Inicializar la aplicación
        controlador.inicializacion();
    }
}

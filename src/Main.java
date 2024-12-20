import controlador.Controlador;
import modelo.modelo_gestion_militar;
import vista.Gestion_militar_terminal;

public class Main {

    public static void main(String[] args) {

        // Crear el modelo que contiene la lógica de negocio
        modelo_gestion_militar modelo = new modelo_gestion_militar();

        // Crear la vista (puede ser una interfaz gráfica o una terminal)
        // Gestion_militar_terminal vista = new Gestion_militar_terminal();
        Gestion_militar_terminal vista = new Gestion_militar_terminal();

        // Crear el controlador que conecta el modelo y la vista
        Controlador controlador = new Controlador(modelo, vista);

        // Inicializar la aplicación
        controlador.inicializacion();
    }
}


import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;
import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;

public class Main {
    public static void main(String[] args) {
        SoldadoRaso soldado1 = new SoldadoRaso("Juan", "S001");
        Teniente teniente = new Teniente("Camilo","S002" );
        Capitan capitan = new Capitan("Miguel", "S003");
        Coronel coronel = new Coronel("Andrea", "S000");

        System.out.println("Acciones en curso:");
        soldado1.realizarAccion();
        teniente.realizarAccion();
        capitan.realizarAccion();
        coronel.realizarAccion();

        coronel.asignarMision();
        capitan.asignarMision();

        coronel.reportarEstado();
        capitan.reportarEstado();
    }
}

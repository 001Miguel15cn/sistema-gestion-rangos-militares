package controlador;

import Militar.Soldados.Soldado;
import Militar.misiones.Misiones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.modelo_gestion_militar;
import vista.Gestion_militar_interfaz;

public class Controlador implements ActionListener{
    ArrayList<String> lista = new ArrayList<>();
    modelo_gestion_militar modelo;
    Gestion_militar_interfaz vista;
    Accion_rango accion;
    Tipo_soldado rango;
    Mostrar_tipo_informacion tipo_informacion;
    Operacion operacion;
    boolean patrulla = false;
    ArrayList<Accion_modificar> accionMOdificar = new ArrayList<>();

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public void setAccion(Accion_rango accion) {
        this.accion = accion;
    }

    public Controlador(modelo_gestion_militar modelo, Gestion_militar_interfaz vista){
        this.modelo = modelo;
        this.vista = vista;
    }

    public void setAcciones(Accion_modificar accion){
        this.accionMOdificar.add(accion);
    }

    public void resetAcciones(){
        accionMOdificar.clear();
    }

    public void inicializacion(){
        vista.inicializar(this); // Asegúrate de que el método se llama 'inicializar' en la vista.
    }

    public Tipo_soldado getRango() {
        return rango;
    }

    public void setRango(Tipo_soldado rango) {
        this.rango = rango;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(operacion) {
            case CREAR_SOLDADO:
                String nombresoldado = vista.getNombreSoldado();
                Tipo_soldado rangosoldado = vista.getTipo_soldado();
                String id_Soldado = modelo.IdIncremental(modelo.OptenerIDmayor());
                modelo.addSoldado(modelo.crearInstanciaSoldado(rangosoldado, nombresoldado, id_Soldado));
                break;

            case MODIFICAR_SOLDADO:
                Soldado soldado = modelo.obtener_soldado(vista.getID());
                for (Accion_modificar modificar : accionMOdificar){
                    switch (modificar) {
                        case NOMBRE:
                            modelo.modificar_nombre(soldado, vista.getNombreSoldado());
                            break;
                        case UNIDAD:
                            modelo.modificar_unidad(soldado, vista.getUnidad());
                            break;
                        case RANGO:
                            switch (accion) {
                                case Subir:
                                    modelo.subirRango(soldado);
                                    break;
                                case Bajar:
                                    modelo.bajarRango(soldado);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case SOLDADOS_BAJO_MANDO:
                            modelo.modificar_soldados_bajo_mando(soldado, vista.getSoldadosBajoMando());
                            break;
                        case ESTRATEGIA:
                            modelo.modificar_estrategia(soldado, vista.getEstrategia());
                            break;
                        default:
                            break;
                    }
                }
                resetAcciones();
                break;

            case MOSTRAR_INFORMACION:
                switch (tipo_informacion) {
                    case TODO:
                        lista = modelo.mostrarSoldados();
                        vista.mostrarInformacion(lista);
                        break;
                    case POR_ID:
                        lista.clear();
                        String info = modelo.mostrarSoldadoID(vista.getID());
                        lista.add(info);
                        break;
                    case POR_RANGO:
                        lista = modelo.mostrarSoldadosRango(vista.getTipo_soldado());
                        break;
                    default:
                        break;
                }
                break;

            case ASIGNAR_MISION:
                Soldado soldado1 = modelo.obtener_soldado(vista.getID());
                Misiones mision = vista.getMision();
                vista.mensajeMision(modelo.mensaje_asignar_mision(soldado1, mision));
                break;

            case REALIZAR_ACCION:
                Soldado soldado2 = modelo.obtener_soldado(vista.getID());
                vista.mensajeRealizaraccion(modelo.obtener_mensaje_realizar_accion(soldado2));
                break;

            case REPORTAR_ESTADO:
                Soldado soldado6 = modelo.obtener_soldado(vista.getID());
                ArrayList<String> lista_mensajes = modelo.reporte_de_estado(soldado6);
                ArrayList<String> lista_reportes = vista.getReporte();
                vista.Mostrar_Reporte(modelo.unir_reportes(lista_mensajes, lista_reportes)); // Implementar esta parte correctamente
                break;

            case PATRULLAR:
                Soldado soldado3 = modelo.obtener_soldado(vista.getID());
                patrulla = !patrulla;
                String mensaje = modelo.obtener_mensaje_de_patrulla(soldado3, patrulla);
                vista.mensajepatrullar(mensaje);
                break;

            case SALUDAR:
                Soldado soldado4 = modelo.obtener_soldado(vista.getID());
                String mensaje1 = modelo.Obtener_mensaje_de_saludo(soldado4);
                vista.mensajesaludar(mensaje1);
                break;

            case REGAÑAR:
                Soldado soldado5 = modelo.obtener_soldado(vista.getID());
                String mensaje2 = modelo.Obtener_mensaje_regaño(soldado5);
                vista.mensajeregaño(mensaje2);
                modelo.bajarRango(soldado5);
                break;

            case RESETEAR:
                modelo.Resetear_lista();
                break;

            case OBTENER_CANTIDADES:
                ArrayList<Soldado> cantidad = modelo.getLista_soldados();
                vista.Cantidadesoldados(cantidad.size()); // Pasando el número total de soldados
                break;

            default:
                break;
        }
    }
}

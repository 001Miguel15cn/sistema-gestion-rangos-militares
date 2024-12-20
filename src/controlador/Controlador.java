package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Militar.Soldados.Soldado;
import Militar.misiones.Misiones;
import modelo.modelo_gestion_militar;
import vista.Gestion_militar_interfaz;

public class Controlador implements ActionListener{
    ArrayList<String> lista = new ArrayList<String>();
    modelo_gestion_militar modelo;
    Gestion_militar_interfaz vista;
    Accion_rango accion;
    Tipo_soldado rango;
    Mostrar_tipo_informacion tipo_informacion;
    //operaciones a realizar
    Operacion operacion;
    boolean patrulla = false;
    //arraylist de acciones a modificar
    ArrayList<Accion_modificar> accionMOdificar = new ArrayList<Accion_modificar>();


    public void setTipo_informacion(Mostrar_tipo_informacion informacion){
        this.tipo_informacion = informacion; 
    }
    
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
    //añade una accion a modificar al arraylist de acciones
    public void setAcciones(Accion_modificar accion){
         this.accionMOdificar.add(accion);
        }
    //añade una accion a modificar al arraylist de acciones
     public void resetAcciones(){
        accionMOdificar.clear();
       }

    public void inicializacion(){
        vista.inicializar(this);
    }

    public Tipo_soldado getRango() {
        return rango;
    }


    public void setRango(Tipo_soldado rango) {
        this.rango = rango;
    }


    @Override
    //implementa la accion recibida
    public void actionPerformed(ActionEvent e) {

    //añadir los getSource para la gui;
    

    switch(operacion){
        //crear un nuevo soldado
        case CREAR_SOLDADO:
            String nombresoldado = vista.getNombreSoldado();
            Tipo_soldado rangosoldado = vista.getTipo_soldado();
            String id_Soldado = modelo.IdIncremental(modelo.OptenerIDmayor());
            modelo.addSoldado(modelo.crearInstanciaSoldado(rangosoldado , nombresoldado, id_Soldado));
            break;
            //modifica un soldado ya existente recibiendo un arraylist de acciones
        case MODIFICAR_SOLDADO:
            //crea una instancia de soldado para guardar el soldado optenido del modelo
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
                    modelo.modificar_soldados_bajo_mando(soldado,vista.getSoldadosBajoMando());
                    break;
                case ESTRATEGIA:
                    modelo.modificar_estrategia(soldado,vista.getEstregia());
                    break;

                default:
                    break;
                }     
            } resetAcciones();
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
            vista.mensajeMision(modelo.mensaje_asignar_mision(soldado1,mision));
            
            break;
        case REALIZAR_ACCION:
            Soldado soldado2 = modelo.obtener_soldado(vista.getID());
            vista.mensajeRealizaraccion(modelo.obtener_mensaje_realizar_accion(soldado2));
            break;
        //recibe un arraylist de reportes por vista
        // y los une a los mensajes de reporte de cada clase
        case REPORTAR_ESTADO:
            Soldado soldado6 = modelo.obtener_soldado(vista.getID());
            ArrayList<String> lista_mensajes = modelo.reporte_de_estado(soldado6);
            ArrayList<String> lista_reportes = vista.getReporte();
            //vista.Mostrar_reporte(modelo.unir_reportes(lista_mensajes,lista_reportes));
            break;
        case PATRULLAR:
            Soldado soldado3 = modelo.obtener_soldado(vista.getID());
            //si un soldado ya esta patrullando deja de patrullar
            patrulla = !patrulla;
            String mensaje = modelo.obtener_mensaje_de_patrulla(soldado3, patrulla);
            vista.mensajepatrullar(mensaje);
            break;
        case SALUDAR:
            Soldado soldado4 = modelo.obtener_soldado(vista.getID());
            String mensaje1 = modelo.Obtener_mensaje_de_saludo(soldado4);
            vista.mensajeMision(mensaje1);
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
        //para actualizar los contadores de la gui
        // y mostrar la cantidad de soldados por terminal
        case OBTENER_CANTIDADES:
           ArrayList<Soldado> cantidad = modelo.getLista_soldados();
           //vista.Cantidadesoldados(modelo.Optener_cantidades(cantidad));
            break;
        default:
            break;
        }
    }


}

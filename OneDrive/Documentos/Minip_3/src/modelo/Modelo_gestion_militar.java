package modelo;

import java.util.ArrayList;
import java.util.List;
import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;
import Militar.Soldados.Soldado;
import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;
import Militar.misiones.Misiones;
import controlador.Controlador;
import controlador.Tipo_soldado;

public class Modelo_gestion_militar {
    private String mayorID = "S000";
    private List<Soldado> lista_soldados = new ArrayList<>();
    private List<Soldado> lista_soldados_defecto = new ArrayList<>();
    private Controlador controlador;

    // Métodos getter y setter
    public String getMayorID() {
        return mayorID;
    }

    public void setMayorID(String mayorID) {
        this.mayorID = mayorID;
    }

    public void addSoldado(Soldado soldado) {
        lista_soldados.add(soldado);
    }

    public void removeSoldado(Soldado soldado) {
        lista_soldados.remove(soldado);
    }

    public String mostrarSoldados(Soldado soldado) {
        return soldado.mostrarInformacion();
    }

    public List<Soldado> getLista_soldados() {
        return lista_soldados;
    }

    public void setLista_soldados(List<Soldado> lista_soldados) {
        this.lista_soldados = lista_soldados;
    }

    public List<Soldado> getLista_soldados_defecto() {
        return lista_soldados_defecto;
    }

    public void setLista_soldados_defecto(List<Soldado> lista_soldados_defecto) {
        this.lista_soldados_defecto = lista_soldados_defecto;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    // Obtener el ID más alto
    public String obtenerMayorID() {
        for (Soldado soldado : lista_soldados) {
            String idActual = soldado.getId();
            if (idActual.compareTo(mayorID) > 0) {
                this.mayorID = idActual;
            }
        }
        return mayorID;
    }

    // Generar ID incremental
    public String idIncremental(String ID) {
        int numeroID = Integer.parseInt(ID.substring(1));
        int nuevoID = numeroID + 1;
        return String.format("S%03d", nuevoID);
    }

    // Mostrar información de un soldado por ID
    public String mostrarSoldadoID(String ID) {
        for (Soldado soldado : lista_soldados) {
            if (soldado.getId().equals(ID)) {
                return soldado.mostrarInformacion();
            }
        }
        return null;
    }

    // Crear una instancia de soldado según el tipo
    public Soldado crearInstanciaSoldado(Tipo_soldado tipo, String nombre, String id) {
        switch (tipo) {
            case Soldado_raso:
                return new SoldadoRaso(nombre, id);
            case Teniente:
                return new Teniente(nombre, id);
            case Capitan:
                return new Capitan(nombre, id);
            case Coronel:
                return new Coronel(nombre, id);
            default:
                return null;
        }
    }

    // Resetear la lista de soldados a la lista predeterminada
    public void resetearLista() {
        SoldadoRaso.cantidad = 3;
        Teniente.cantidad = 1;
        Coronel.cantidad = 1;
        Capitan.cantidad = 1;
        lista_soldados.clear();
        setLista_soldados(lista_soldados_defecto);
    }

    // Mostrar todos los soldados
    public List<String> mostrarSoldados() {
        List<String> listaDatos = new ArrayList<>();
        if (lista_soldados.isEmpty()) {
            return null;
        }
        for (Soldado soldado : lista_soldados) {
            listaDatos.add(soldado.mostrarInformacion());
        }
        return listaDatos;
    }

    // Mostrar soldados por rango
    public List<String> mostrarSoldadosRango(Tipo_soldado rango) {
        List<String> listaDatos = new ArrayList<>();
        if (lista_soldados.isEmpty()) {
            return null;
        }
        for (Soldado soldado : lista_soldados) {
            if (rango.equals(soldado.getRango())) {
                listaDatos.add(soldado.mostrarInformacion());
            }
        }
        return listaDatos;
    }

    // Obtener un soldado por su ID
    public Soldado obtenerSoldado(String ID) {
        for (Soldado soldado : lista_soldados) {
            if (soldado.getId().equalsIgnoreCase(ID)) {
                return soldado;
            }
        }
        return null;
    }

    // Obtener la clase del soldado (Raso, Teniente, etc.)
    public Object obtenerSoldadoClase(Soldado soldado) {
        if (soldado instanceof SoldadoRaso) {
            return (SoldadoRaso) soldado;
        } else if (soldado instanceof Teniente) {
            return (Teniente) soldado;
        } else if (soldado instanceof Capitan) {
            return (Capitan) soldado;
        } else if (soldado instanceof Coronel) {
            return (Coronel) soldado;
        }
        return null;
    }

    // Modificar la unidad de un soldado
    public void modificarUnidad(Soldado soldado, String unidad) {
        if (soldado instanceof SoldadoRaso) {
            ((SoldadoRaso) soldado).setUnidad(unidad);
        } else if (soldado instanceof Teniente) {
            ((Teniente) soldado).setUnidad(unidad);
        } else if (soldado instanceof Capitan) {
            ((Capitan) soldado).setUnidad(unidad);
        } else if (soldado instanceof Coronel) {
            ((Coronel) soldado).setUnidad(unidad);
        }
    }

    // Modificar la estrategia de un Coronel
    public void modificarEstrategia(Soldado soldado, String estrategia) {
        if (soldado instanceof Coronel) {
            ((Coronel) soldado).setEstrategia(estrategia);
        }
    }

    // Modificar los soldados bajo el mando de un Capitán
    public void modificarSoldadosBajoMando(Soldado soldado, int numeroSoldados) {
        if (soldado instanceof Capitan) {
            ((Capitan) soldado).setSoldadosBajoMando(numeroSoldados);
        }
    }

    // Modificar el nombre de un soldado
    public void modificarNombre(Soldado soldado, String nombre) {
        soldado.setNombre(nombre);
    }

    // Subir el rango de un soldado
    public Soldado subirRango(Soldado soldado) {
        if (soldado instanceof SoldadoRaso) {
            SoldadoRaso.remove();
            return new Teniente(soldado.getNombre(), soldado.getId());
        } else if (soldado instanceof Teniente) {
            Teniente.remove();
            return new Capitan(soldado.getNombre(), soldado.getId());
        } else if (soldado instanceof Capitan) {
            Capitan.remove();
            return new Coronel(soldado.getNombre(), soldado.getId());
        }
        return null;
    }

    // Bajar el rango de un soldado
    public Soldado bajarRango(Soldado soldado) {
        if (soldado instanceof Coronel) {
            Coronel.remove();
            return new Capitan(soldado.getNombre(), soldado.getId());
        } else if (soldado instanceof Capitan) {
            Capitan.remove();
            return new Teniente(soldado.getNombre(), soldado.getId());
        } else if (soldado instanceof Teniente) {
            Teniente.remove();
            return new SoldadoRaso(soldado.getNombre(), soldado.getId());
        } else {
            SoldadoRaso.remove();
            return null;
        }
    }

    // Obtener mensaje de regaño
    public String obtenerMensajeRegano(Soldado soldado) {
        if (soldado instanceof SoldadoRaso) {
            return ((SoldadoRaso) soldado).regañado();
        } else if (soldado instanceof Teniente) {
            return ((Teniente) soldado).regañado();
        } else if (soldado instanceof Capitan) {
            return ((Capitan) soldado).regañado();
        } else if (soldado instanceof Coronel) {
            return ((Coronel) soldado).regañado();
        }
        return "";
    }

    // Obtener mensaje de saludo
    public String obtenerMensajeDeSaludo(Soldado soldado) {
        if (soldado instanceof SoldadoRaso) {
            return ((SoldadoRaso) soldado).saludar();
        } else if (soldado instanceof Teniente) {
            return ((Teniente) soldado).saludar();
        } else if (soldado instanceof Capitan) {
            return ((Capitan) soldado).saludar();
        } else if (soldado instanceof Coronel) {
            return ((Coronel) soldado).saludar();
        }
        return "";
    }

    // Obtener mensaje de patrullaje
    public String obtenerMensajeDePatrulla(Soldado soldado, boolean accion) {
        if (soldado instanceof SoldadoRaso) {
            return ((SoldadoRaso) soldado).patrullar(accion);
        } else if (soldado instanceof Teniente) {
            return ((Teniente) soldado).patrullar(accion);
        } else if (soldado instanceof Capitan) {
            return ((Capitan) soldado).patrullar(accion);
        } else if (soldado instanceof Coronel) {
            return ((Coronel) soldado).patrullar(accion);
        }
        return "";
    }

    // Realizar acción del soldado
    public String obtenerMensajeRealizarAccion(Soldado soldado) {
        if (soldado instanceof SoldadoRaso) {
            return ((SoldadoRaso) soldado).realizarAccion();
        } else if (soldado instanceof Teniente) {
            return ((Teniente) soldado).realizarAccion();
        } else if (soldado instanceof Capitan) {
            return ((Capitan) soldado).realizarAccion();
        } else if (soldado instanceof Coronel) {
            return ((Coronel) soldado).realizarAccion();
        }
        return "";
    }

    // Realizar misión con el soldado
    public void realizarMision(Soldado soldado, Misiones mision) {
        soldado.realizarMision(mision);
    }
}

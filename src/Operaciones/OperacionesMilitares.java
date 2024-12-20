package Operaciones;

import java.util.ArrayList;

import Militar.misiones.Misiones;

public interface OperacionesMilitares {
    String asignarMision(Misiones mision);
    ArrayList<String> reportarEstado();
}

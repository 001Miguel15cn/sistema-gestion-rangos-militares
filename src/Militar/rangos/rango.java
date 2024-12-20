package Militar.rangos;

public abstract class rango {
    protected int nivel;
    protected String unidad;
    protected String estrategia = "sin estrategia";
    public rango(){
        this.nivel = 0;
        this.unidad = "sin unidad";
    }


    public rango(int nivel) {
        this.nivel = nivel;
        this.unidad = "sin unidad";
    }

    public rango(int nivel, String unidad) {
        this.nivel = nivel;
        this.unidad = unidad;
    }



    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    

    public abstract String realizarAccion();


    public String getEstrategia() {
        return estrategia;
    }


    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

}

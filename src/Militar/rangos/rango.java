package Militar.rangos;

public abstract class rango {
    protected int nivel;

    public rango() {
        
        this.nivel = 0; // 
    }

    public rango(int nivel) {
        this.nivel = nivel;
    }

    public abstract void realizarAccion();
}

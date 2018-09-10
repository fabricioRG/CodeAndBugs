package project.caso.backend;

/**
 *
 * @author fabricio
 */
public class TipoCaso {
    
    private String nombre;
    private int numeroPasos;

    public TipoCaso(String nombre, int numeroPasos) {
        this.nombre = nombre;
        this.numeroPasos = numeroPasos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroPasos() {
        return numeroPasos;
    }

    public void setNumeroPasos(int numeroPasos) {
        this.numeroPasos = numeroPasos;
    }
}

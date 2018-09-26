package project.caso.backend;

/**
 *
 * @author fabricio
 */
public class CantidadCasos {

    private int idProyecto;
    private String nombreProyecto;
    private int cantidadCasos;
    private int estado;

    public CantidadCasos(int idProyecto, String nombreProyecto, int cantidadCasos, int estado) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.cantidadCasos = cantidadCasos;
        this.estado = estado;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public int getCantidadCasos() {
        return cantidadCasos;
    }

    public void setCantidadCasos(int cantidadCasos) {
        this.cantidadCasos = cantidadCasos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}

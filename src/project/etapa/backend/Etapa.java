package project.etapa.backend;

/**
 *
 * @author fabricio
 */
public class Etapa {
    
    private int numeroPaso;
    private int IdCaso;
    private String Comentario;
    private double horasTrabajadas;
    private byte aprobacion;
    private int dpiDesarrollador;
    private double costo;

    public Etapa(int numeroPaso, int IdCaso, String Comentario, double horasTrabajadas, byte aprobacion, int dpiDesarrollador, double costo) {
        this.numeroPaso = numeroPaso;
        this.IdCaso = IdCaso;
        this.Comentario = Comentario;
        this.horasTrabajadas = horasTrabajadas;
        this.aprobacion = aprobacion;
        this.dpiDesarrollador = dpiDesarrollador;
        this.costo = costo;
    }

    public int getNumeroPaso() {
        return numeroPaso;
    }

    public void setNumeroPaso(int numeroPaso) {
        this.numeroPaso = numeroPaso;
    }

    public int getIdCaso() {
        return IdCaso;
    }

    public void setIdCaso(int IdCaso) {
        this.IdCaso = IdCaso;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public byte getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(byte aprobacion) {
        this.aprobacion = aprobacion;
    }

    public int getDpiDesarrollador() {
        return dpiDesarrollador;
    }

    public void setDpiDesarrollador(int dpiDesarrollador) {
        this.dpiDesarrollador = dpiDesarrollador;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
}

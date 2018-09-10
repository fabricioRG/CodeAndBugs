package project.caso.backend;

import java.util.Date;

/**
 *
 * @author fabricio
 */
public class Caso {
    private int ID;
    private Date fechaInicio;
    private Date fechaLimite;
    private Date fechaEntrega;
    private double avance;
    private String motivoCancelacion;
    private String tipoCaso;
    private int IdProyecto;

    public Caso(int ID, Date fechaInicio, Date fechaLimite, Date fechaEntrega, double avance, String motivoCancelacion, String tipoCaso, int IdProyecto) {
        this.ID = ID;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.fechaEntrega = fechaEntrega;
        this.avance = avance;
        this.motivoCancelacion = motivoCancelacion;
        this.tipoCaso = tipoCaso;
        this.IdProyecto = IdProyecto;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getAvance() {
        return avance;
    }

    public void setAvance(double avance) {
        this.avance = avance;
    }

    public String getMotivoCancelacion() {
        return motivoCancelacion;
    }

    public void setMotivoCancelacion(String motivoCancelacion) {
        this.motivoCancelacion = motivoCancelacion;
    }

    public String getTipoCaso() {
        return tipoCaso;
    }

    public void setTipoCaso(String tipoCaso) {
        this.tipoCaso = tipoCaso;
    }

    public int getIdProyecto() {
        return IdProyecto;
    }

    public void setIdProyecto(int IdProyecto) {
        this.IdProyecto = IdProyecto;
    }
    
}

package project.proyecto.backend;

/**
 *
 * @author fabricio
 */
public class Proyecto {
    private int ID;
    private String nombre;
    private byte Estado;
    private int DPIAdministrador;

    public Proyecto(int ID, String nombre, byte Estado, int DPIAdministrador) {
        this.ID = ID;
        this.nombre = nombre;
        this.Estado = Estado;
        this.DPIAdministrador = DPIAdministrador;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEstado() {
        return Estado;
    }

    public void setEstado(byte Estado) {
        this.Estado = Estado;
    }

    public int getDPIAdministrador() {
        return DPIAdministrador;
    }

    public void setDPIAdministrador(int DPIAdministrador) {
        this.DPIAdministrador = DPIAdministrador;
    }
}

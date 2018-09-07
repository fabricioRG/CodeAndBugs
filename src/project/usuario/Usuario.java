package project.usuario;

/**
 *
 * @author fabricio
 */
public class Usuario {
    
    private int DPI;
    private String nombre;
    private String usuario;
    private String password;
    byte tipo;

    public Usuario(int DPI, String nombre, String usuario, String password, byte tipo) {
        this.DPI = DPI;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
    }

    public int getDPI() {
        return DPI;
    }

    public void setDPI(int DPI) {
        this.DPI = DPI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getTipo() {
        return tipo;
    }

    public void setTipo(byte tipo) {
        this.tipo = tipo;
    }
    
}

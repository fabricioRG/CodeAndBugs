package project.usuario;

/**
 *
 * @author fabricio
 */
public class Usuario {
    
    private char[] DPI = new char[8];
    private String nombre;
    private String usuario;
    private String password;
    char tipo;

    public Usuario(char[] DPI, String nombre, String usuario, String password, char tipo) {
        this.DPI = DPI;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
    }

    public char[] getDPI() {
        return DPI;
    }

    public void setDPI(char[] DPI) {
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

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    
    
}

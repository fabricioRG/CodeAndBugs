package project.usuario;

import project.baseDatos.ManejadorDatosUsuario;

/**
 *
 * @author fabricio
 */
public class ManejadorUsuario {

    public ManejadorUsuario() {
    }

    public Usuario getUsuarioByNombreUsuario(ManejadorDatosUsuario mdu, String nombreUsuario) {
        String consulta = "SELECT * FROM USUARIO WHERE Nombre_Usuario = ?";
        Usuario usr = mdu.getUsuario(nombreUsuario, consulta);
        return usr;
    }
    
    public Usuario getUsuarioByDPI(ManejadorDatosUsuario mdu, String DPIUsuario){
        String consulta = "SELECT * FROM USUARIO WHERE DPI = ?";
        Usuario usr = mdu.getUsuario(DPIUsuario, consulta);
        return usr;
    }

    public void setUsuarioInDatabase(){
        
    }
    
}

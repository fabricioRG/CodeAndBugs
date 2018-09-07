package project.usuario.backend;

import project.frontend.CodeAndBugsDescktop;
import project.baseDatos.ManejadorBaseDatos;
import project.baseDatos.ManejadorDatosUsuario;
import project.usuario.ManejadorUsuario;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class ManejadorFrontEndUsuario {

    CodeAndBugsDescktop cbd = null;
    ManejadorUsuario mu = null;
    ManejadorDatosUsuario mdu = null;

    public ManejadorFrontEndUsuario() {
        this.mu = new ManejadorUsuario();
        this.mdu = new ManejadorDatosUsuario();
    }

    public void showCodeAndBugsDesktop(String nombre, char[] password) throws Exception {
        String passwordUsuario = new String(password);
        Usuario usr = mu.getUsuarioByNombreUsuario(mdu, nombre);
        if (nombre.replaceAll(" ", "").isEmpty()) {
            throw new Exception("No se ha ingresado un \"nombre de usuario\" valido");
        } else if (passwordUsuario.replaceAll(" ", "").isEmpty()) {
            throw new Exception("No se ha ingresado una \"contraseña\" valida");
        } else if (nombre.length() > 10 || passwordUsuario.length() > 10) {
            throw new Exception("Se ha excedido el numero maximo de caracteres validos");
        } else if(usr == null){
            throw new Exception("El usuario no existe");
        } else if(!(usr.getPassword().equals(passwordUsuario))){
            throw new Exception("La contraseña es incorrecta");
        } else {
            cbd = new CodeAndBugsDescktop(usr.getTipo(), usr.getUsuario());
            cbd.setVisible(true);
        }
    }
}

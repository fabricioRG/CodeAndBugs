package project.usuario.backend;

import codeandbugs01.BaseDatos;
import project.frontend.CodeAndBugsDescktop;
import project.baseDatos.ManejadorBaseDatos;
import project.usuario.ManejadorUsuario;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class ManejadorFrontEndUsuario {

    CodeAndBugsDescktop cbd = null;
    ManejadorUsuario mu = null;
    private BaseDatos DB = null;
    
    public ManejadorFrontEndUsuario(BaseDatos DB) {
        this.DB = DB;
        this.mu = new ManejadorUsuario(this.DB);
    }

    public void showCodeAndBugsDesktop(String nombre, char[] password, BaseDatos DB) throws Exception {
        String passwordUsuario = new String(password);
        Usuario usr = null;
        if (nombre.isEmpty()) {
            throw new Exception("No se ha ingresado un \"nombre de usuario\" valido");
        } else if (passwordUsuario.replaceAll(" ", "").isEmpty()) {
            throw new Exception("No se ha ingresado una \"contraseña\" valida");
        }
        if(mu.getUsuarioByNombreUsuario(nombre)!=null){
            usr = (Usuario)mu.getUsuarioByNombreUsuario(nombre).get(0);
            if(!(usr.getPassword().equals(passwordUsuario))){
            throw new Exception("La contraseña es incorrecta");
            } else {
            cbd = new CodeAndBugsDescktop(usr.getTipo(), usr.getUsuario(), DB);
            cbd.setVisible(true);
            }
        } else {
            throw new Exception("El usuario no existe");
        }
    }
}

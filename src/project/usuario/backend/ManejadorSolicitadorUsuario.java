package project.usuario.backend;

import project.frontend.CodeAndBugsDescktop;

/**
 *
 * @author fabricio
 */
public class ManejadorSolicitadorUsuario {

    CodeAndBugsDescktop cbd;
    
    public ManejadorSolicitadorUsuario() {
        cbd = new CodeAndBugsDescktop();
    }
    
    public void showCodeAndBugsDesktop(String nombre, char[] password) throws Exception{
        String passwordUsuario = new String(password);
        if(nombre.replaceAll(" ", "").isEmpty()){
            throw new Exception("No se ha ingresado un \"nombre de usuario\" valido");
        } else if(passwordUsuario.replaceAll(" ", "").isEmpty()){
            throw new Exception("No se ha ingresado una \"contraseña\" valida");
        } else {
            cbd.setVisible(true);
        }
    }
    
}

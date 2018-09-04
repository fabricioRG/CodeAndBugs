package codeandbugs01;

import project.usuario.frontend.SolicitadorUsuario;
/**
 *
 * @author fabricio
 */
public class CodeAndBugs01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SolicitadorUsuario su = new SolicitadorUsuario(null, true);
        su.setVisible(true);
    }
    
}

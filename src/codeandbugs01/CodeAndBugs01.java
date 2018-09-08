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
        BaseDatos BD = new BaseDatos();
        BD.initConection();
        SolicitadorUsuario su = new SolicitadorUsuario(null, true, BD);
        su.setVisible(true);
    }
    
}

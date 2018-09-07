package project.backend;

/**
 *
 * @author fabricio
 */
public class ManejadorDesktop {

    public ManejadorDesktop() {
    }
    
    public void crearUsuario(String DPITemp, String nombreTemp, String TipoTemp, String UsuarioTemp, String passTemp) throws Exception{
        int DPI = Integer.parseInt(DPITemp);
        if(DPITemp.length() != 13){
            throw new Exception("No se ha ingresado un numero de \"DPI\" correcto\nPor favor ingrese un \"DPI\" de 13 caracteres.");
        } else if(nombreTemp.replaceAll(" ", "").isEmpty()){
            throw new Exception("No se ha ingresado un nombre valido, intentalo de nuevo");
        }
    }
    
}
